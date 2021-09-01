/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.mBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.focus.bean.Compra;
import br.com.focus.bean.CondicaoPagamento;
import br.com.focus.bean.ContaPagar;
import br.com.focus.bean.Fornecedor;
import br.com.focus.bean.Produto;
import br.com.focus.bean.ProdutosSelecionados;
import br.com.focus.bean.StatusContas;
import br.com.focus.bean.StatusPedido;
import br.com.focus.bean.Usuario;
import br.com.focus.controller.ControllerCompra;
import br.com.focus.controller.ControllerFornecedor;
import br.com.focus.controller.ControllerProduto;
import br.com.focus.controller.ControllerProdutosSelecionados;



/**
 * @author Thiago M. Farias
 * 
 */
public class CompraMBean {

	private Compra compra = new Compra(new Fornecedor(), new CondicaoPagamento(), new Usuario());
    private Compra compraSearch = new Compra();
    private Compra compraModal = new Compra();
    private Fornecedor fornecedorCompra = new Fornecedor();
    private Usuario usuarioCompra = new Usuario();
    private CondicaoPagamento condicaoPagamentoCompra = new CondicaoPagamento();
    private Produto produto = new Produto();
    private List<Produto> produtos = null;
    private List<ProdutosSelecionados> produtosSelecionados = null;
    private List<ContaPagar> contasPagar = null;
    private List<Compra> compras = null;
    private boolean inEditing = false;
    private boolean showButton = false;
    private boolean salva = false;
    private ControllerCompra controllerCompra = new ControllerCompra();
    private ControllerProduto controllerProduto = new ControllerProduto();
    private ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    private ControllerProdutosSelecionados controllerProdutosSelecionados = new ControllerProdutosSelecionados();
    private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public CompraMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Compra
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.compra.setContasPagar(this.contasPagar);
		this.compra.setProdutosSelecionados(this.produtosSelecionados);
		this.compra.setFornecedor(this.fornecedorCompra);
		this.compra.setCondicaoPagamento(this.condicaoPagamentoCompra);
		this.compra.setUsuario(this.usuarioCompra);
		this.compra.setStatusPedido(StatusPedido.CONCLUIDO);
		this.compra.setDataEmissao(new Date());
		this.controllerCompra.saveOrUpdate(this.compra);
		this.geraEstoquePrecoCusto();
		return "success";
	}

	/**
	 * @method Delete MBean Compra
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.compra.setStatusPedido(StatusPedido.CANCELADO);
		for (ContaPagar cp : contasPagar){
			cp.setStatusContas(StatusContas.CANCELADO);
		}
		this.controllerCompra.saveOrUpdate(this.compra);
		this.removeEstoque();
	}

	/**
	 * @method Update MBean Compra
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.compra.setContasPagar(this.contasPagar);
		this.compra.setProdutosSelecionados(this.produtosSelecionados);
		this.compra.setFornecedor(this.fornecedorCompra);
		this.compra.setCondicaoPagamento(this.condicaoPagamentoCompra);
		this.compra.setUsuario(this.usuarioCompra);
		this.controllerCompra.update(this.compra);
	}

	/**
	 * @method Search by ID MBean Compra
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.compra = this.controllerCompra.search(this.compra);
	}

	/**
	 * @method List All MBean Compra
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.compras = this.controllerCompra.listAll();
		return "success";
		/*if (this.salva = false)
			return "compra";
		else
			return "error";*/
	}
	
	/**
	 * @method List All MBean Compra
	 * @return String
	 * @throws Exception
	 */
	public List<Produto> listAllProdutos() throws Exception {
		this.produtos = this.controllerProduto.listAll();
		return produtos;
	}
	
	/**
	 * @method Search by Parameter with Like MBean Compra
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.compraSearch != null)
				&& (!this.compraSearch.getNumero().trim().equals(""))) {
			this.compras = null;
			this.compras = this.controllerCompra
					.searchByParameter(this.compraSearch);
		} else {
			this.compras = this.controllerCompra.listAll();
		}
		return null;
	}

	/**
	 * @method Calculate value of services MBean Compra
	 * @return Double
	 * @throws Exception
	 **/
	public Double somaTotalProdutos(){
	Double total = 0.0;
		for (ProdutosSelecionados item : getProdutosSelecionados()) {
			if(item.getPrecoTotal()!=null)
			total += item.getPrecoTotal();
		}
		compra.setTotalProdutos(total);
		this.calculaValores();
		return total;
	}
	
	public String setaNumeroNota(){
		String numeroNota = new String();
		numeroNota = compra.getNumero();
		compra.setNumero(numeroNota);
		return numeroNota;
	}
	
	public Double calculaDesconto(){
		Double total = 0.0;
		this.somaTotalProdutos();
		total = compra.getTotalProdutos() - compra.getDesconto();
		compra.setTotalProdutos(total);
		compra.setTotalCompra(total);
		return total;
	}
	
	public Double calculaValores(){
		Double total = 0.0;
		total = compra.getTotalProdutos() + compra.getValorIcms() + compra.getValorIcmsSubstituicao() + compra.getValorFrete() 
				+ compra.getValorSeguro() + compra.getValorTotalIpi() + compra.getOutrasDespesas();
		compra.setTotalCompra(total);
		return total;
	}

	public void geraEstoquePrecoCusto() throws Exception{
		List<Produto> listProdutos = this.listAllProdutos();
		for (int i = 0; i < produtosSelecionados.size(); i++){
			ProdutosSelecionados ps = produtosSelecionados.get(i);
			for (int j = 0; j < listProdutos.size(); j++){
				Produto p = listProdutos.get(j);
				if (ps.getProduto().getIdProduto().longValue() == p.getIdProduto() && (p.getEstoque() != null) && (p.getPrecoCusto() != null)){
					p.setEstoque(p.getEstoque() + ps.getQuantidade().intValue());
					p.setPrecoCusto(ps.getPrecoUnitario());
				}else{
					p.setEstoque(ps.getQuantidade().intValue());
					p.setPrecoCusto(ps.getPrecoUnitario().doubleValue());
				}
				this.controllerProduto.saveOrUpdate(p);
			}
		}
	}
	
	public void removeEstoque() throws Exception{
		List<Produto> listProdutos = this.listAllProdutos();
		for (int i = 0; i < produtosSelecionados.size(); i++){
			ProdutosSelecionados ps = produtosSelecionados.get(i);
			for (int j = 0; j < listProdutos.size(); j++){
				Produto p = listProdutos.get(j);
				if (ps.getProduto().getIdProduto().longValue() == p.getIdProduto() && (p.getEstoque() != null)){
					p.setEstoque(p.getEstoque() - ps.getQuantidade().intValue());
				this.controllerProduto.saveOrUpdate(p);
				}
			}
		}
	}
	
	/**
	 * @method Listener Insert Item List Service MBean Compra
	 */
	public void listenerInsertItemList(ActionEvent actionEvent) throws Exception {
		UIParameter component = null;
		component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Produto param = null;
		param = (Produto) component.getValue();
		if (param != null) {
			Produto produto = new Produto();
			produto = this.controllerProduto.search(param);
			List<ProdutosSelecionados> ps = produtosSelecionados;
			if (ps == null ){
				ps = new ArrayList<ProdutosSelecionados>();
			}
			ProdutosSelecionados item = new ProdutosSelecionados();
			item.setProduto(produto.clone());
			item.setDescricao(produto.getDescricao());
			item.setUnidade(produto.getUnidade().getSigla());
			boolean isInsert = false;
			for (ProdutosSelecionados prodsel : ps ){
				if(prodsel.getProduto().getIdProduto().longValue() == item.getProduto().getIdProduto().longValue()){
					isInsert = true;
				}
			}
			if (!isInsert){
				ps.add(item);
				this.produtosSelecionados = ps;
			}else{
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Item já Existente", "Erro!");
				FacesContext.getCurrentInstance().addMessage("descricaoProdutoSelecionado", facesMessage);
			}
		}
	}
	
	/**
	 * @method Listener Remove Item List Service MBean Compra
	 */
	public void listenerRemoveItemList(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		ProdutosSelecionados param = (ProdutosSelecionados) component.getValue();
		if (param != null) {
			getProdutosSelecionados().remove(param);
			controllerProdutosSelecionados.delete(param);
			this.somaTotalProdutos();
			compra.getTotalProdutos();
			this.calculaValores();
		}
	}
	
	public void listenerGeraParcelasPagamento(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		CondicaoPagamento param = (CondicaoPagamento) component.getValue();
		if (param != null) {
		Integer parcelas = param.getParcelas();
		if(parcelas == 0)
			parcelas = 1;
		Double valorTotalCompra = this.compra.getTotalCompra();
		Double valorParcela = new Double(valorTotalCompra / parcelas);
		Date dataVencimento = new Date();
		Calendar calendar = Calendar.getInstance();
		List<ContaPagar>rc = new ArrayList<ContaPagar>();
			for (int i = 0; i < parcelas; i++) {
				int j = 0;
				j = i + 1;
				ContaPagar cp = new ContaPagar();
				cp.setDataVencimento(dataVencimento);
				cp.setFornecedor(this.fornecedorCompra);
				cp.setNumeroDocumento(this.compra.getNumero() + "/" + j );
				cp.setValor(valorParcela);
				cp.setStatusContas(StatusContas.ABERTO);
				calendar.add(Calendar.MONTH, 1);
				dataVencimento = calendar.getTime();
				rc.add(cp);
				this.contasPagar = rc;
			}
		}
	}
	
	/**
	 * @method Listener Search by Parameter MBean Compra
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.compraSearch != null)	&& (!this.compraSearch.getNumero().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramSearch");
			Compra compraAux = new Compra();
			if (component.getValue() != null) {
				compraAux.setNumero("%" + component.getValue() + "%");
			} else {
				compraAux.setNumero("%" + compraSearch.getNumero() + "%");
			}
			this.compraSearch = new Compra();
			this.compraSearch.setNumero(compraAux.getNumero());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Compra
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idCompra = Long.valueOf(id);
		if (idCompra != null) {
			compra.setIdCompra(idCompra);
			this.compra = this.controllerCompra.search(this.compra);
			if ((this.compra != null) && (this.compra.getFornecedor() != null) && (this.compra.getUsuario() != null)) {
				this.contasPagar = this.compra.getContasPagar();
				this.produtosSelecionados = this.compra.getProdutosSelecionados();
                this.fornecedorCompra.setIdFornecedor(this.compra.getFornecedor().getIdFornecedor());
                this.fornecedorCompra.setNomeRazaoSocial(this.compra.getFornecedor().getNomeRazaoSocial());
                this.usuarioCompra.setIdUsuario(this.compra.getUsuario().getIdUsuario());
                this.usuarioCompra.setLogin(this.compra.getUsuario().getLogin());
                this.condicaoPagamentoCompra.setIdCondicaoPagamento(this.compra.getCondicaoPagamento().getIdCondicaoPagamento());
                this.condicaoPagamentoCompra.setDescricao(this.compra.getCondicaoPagamento().getDescricao());
            }
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Compra
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.contasPagar = new ArrayList<ContaPagar>();
		this.produtosSelecionados = new ArrayList<ProdutosSelecionados>();
		this.compra = new Compra();
		this.compra.setDataEmissao(new Date());
		this.compra.setDataEntrada(new Date());
		this.compra.setTotalProdutos(new Double(0));
		this.compra.setTotalCompra(new Double(0));
		this.compra.setValorFrete(new Double(0));
		this.compra.setDesconto(new Double(0));
		this.compra.setValorIcms(new Double(0));
		this.compra.setValorIcmsSubstituicao(new Double(0));
		this.compra.setValorSeguro(new Double(0));
		this.compra.setValorTotalIpi(new Double(0));
		this.compra.setOutrasDespesas(new Double(0));
        this.condicaoPagamentoCompra = new CondicaoPagamento();
        this.fornecedorCompra = new Fornecedor();
        this.usuarioCompra = new Usuario();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Compra
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Compra
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Long id = (Long) component.getValue();
		Long idCompra = Long.valueOf(id);
		if (idCompra != null) {
			compra.setIdCompra(idCompra);
			this.compra = this.controllerCompra.search(this.compra);
			this.compras = null;
		}
	}

	/**
	 * @method Listener Save MBean Compra
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
        Boolean isInserido = false;
		for (Compra c : compras){
			if ((compra.getNumero().toString().equals(c.getNumero().toString()) && (this.fornecedorCompra.getIdFornecedor().longValue() == c.getFornecedor().getIdFornecedor().longValue()))){
				isInserido = true;
			}
		}
		if(!isInserido){
			this.compra.setContasPagar(null);
			this.compra.setProdutosSelecionados(null);
			this.compra.setFornecedor(null);
			this.compra.setCondicaoPagamento(null);
	        this.compra.setUsuario(null);
			this.save();
			this.contasPagar = new ArrayList<ContaPagar>();
			this.produtosSelecionados = new ArrayList<ProdutosSelecionados>();
	        this.condicaoPagamentoCompra = new CondicaoPagamento();
	        this.fornecedorCompra = new Fornecedor();
	        this.usuarioCompra = new Usuario();
			this.setEditing();
			this.salva = false;
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Compra efetuada com sucesso!!!", "Erro!");
			FacesContext.getCurrentInstance().addMessage("descricaoProdutoSelecionado", facesMessage);
		}
		else{
			this.compra.setContasPagar(null);
			this.compra.setProdutosSelecionados(null);
			this.compra.setFornecedor(null);
			this.compra.setCondicaoPagamento(null);
	        this.compra.setUsuario(null);
			this.contasPagar = new ArrayList<ContaPagar>();
			this.produtosSelecionados = new ArrayList<ProdutosSelecionados>();
	        this.condicaoPagamentoCompra = new CondicaoPagamento();
	        this.fornecedorCompra = new Fornecedor();
	        this.usuarioCompra = new Usuario();
			this.setEditing();
			this.salva = true;
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Nota n�o pode ser inserida, uma nota com o mesmo n�mero j� est� cadastrada para este fornecedor!!!", "Erro!");
			FacesContext.getCurrentInstance().addMessage("descricaoProdutoSelecionado", facesMessage);
			
		}
		
	}
	
	/**
	 * @method Listener Delete MBean Compra
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.compra = new Compra();
        this.condicaoPagamentoCompra = new CondicaoPagamento();
        this.fornecedorCompra = new Fornecedor();
        this.usuarioCompra = new Usuario();
		this.compraSearch = new Compra();
		this.produtosSelecionados = new ArrayList<ProdutosSelecionados>();
		this.contasPagar = new ArrayList<ContaPagar>();
		this.compras = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idCompra", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Compra
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Long id = (Long) component.getValue();
		Long idCompra = Long.valueOf(id);
		if (idCompra != null) {
			compra.setIdCompra(idCompra);
			this.compra = this.controllerCompra.search(this.compra);
			if ((this.compra != null) && (this.compra.getFornecedor() != null) && (this.compra.getUsuario() != null)) {
				this.contasPagar = this.compra.getContasPagar();
				this.produtosSelecionados = this.compra.getProdutosSelecionados();
                this.fornecedorCompra.setIdFornecedor(this.compra.getFornecedor().getIdFornecedor());
                this.fornecedorCompra.setNomeRazaoSocial(this.compra.getFornecedor().getNomeRazaoSocial());
                this.usuarioCompra.setIdUsuario(this.compra.getUsuario().getIdUsuario());
                this.usuarioCompra.setLogin(this.compra.getUsuario().getLogin());
                this.condicaoPagamentoCompra.setIdCondicaoPagamento(this.compra.getCondicaoPagamento().getIdCondicaoPagamento());
                this.condicaoPagamentoCompra.setDescricao(this.compra.getCondicaoPagamento().getDescricao());
            }
			this.compras = null;
		}
		this.setEditing();
	}

	/**
	 * @method Set the screen for editing the showButton to set true the
	 *         inEditing to set false
	 */
	private void setEditing() {
		this.showButton = true;
		this.inEditing = false;
	}

	/**
	 * @method Set the screen for deleting the showButton to set false the
	 *         inEditing to set true
	 */
	private void setDeleting() {
		this.showButton = false;
		this.inEditing = true;
	}

	/**
	 * @return the compra
	 */
	public Compra getCompra() {
		return compra;
	}

	/**
	 * @param compra the compra to set
	 */
	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	/**
	 * @return the compraSearch
	 */
	public Compra getCompraSearch() {
		return compraSearch;
	}

	/**
	 * @param compraSearch the compraSearch to set
	 */
	public void setCompraSearch(Compra compraSearch) {
		this.compraSearch = compraSearch;
	}

	/**
	 * @return the compraModal
	 */
	public Compra getCompraModal() {
		return compraModal;
	}

	/**
	 * @param compraModal the compraModal to set
	 */
	public void setCompraModal(Compra compraModal) {
		this.compraModal = compraModal;
	}

	/**
	 * @return the fornecedorCompra
	 */
	public Fornecedor getFornecedorCompra() {
		return fornecedorCompra;
	}

	/**
	 * @param fornecedorCompra the fornecedorCompra to set
	 */
	public void setFornecedorCompra(Fornecedor fornecedorCompra) {
		this.fornecedorCompra = fornecedorCompra;
	}

	/**
	 * @return the usuarioCompra
	 */
	public Usuario getUsuarioCompra() {
		return usuarioCompra;
	}

	/**
	 * @param usuarioCompra the usuarioCompra to set
	 */
	public void setUsuarioCompra(Usuario usuarioCompra) {
		this.usuarioCompra = usuarioCompra;
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return the produtosSelecionados
	 */
	public List<ProdutosSelecionados> getProdutosSelecionados() {
		return produtosSelecionados;
	}

	/**
	 * @param produtosSelecionados the produtosSelecionados to set
	 */
	public void setProdutosSelecionados(
			List<ProdutosSelecionados> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}

	/**
	 * @return the compras
	 */
	public List<Compra> getCompras() {
		return compras;
	}

	/**
	 * @param compras the compras to set
	 */
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	/**
	 * @return the inEditing
	 */
	public boolean isInEditing() {
		return inEditing;
	}

	/**
	 * @param inEditing the inEditing to set
	 */
	public void setInEditing(boolean inEditing) {
		this.inEditing = inEditing;
	}

	/**
	 * @return the showButton
	 */
	public boolean isShowButton() {
		return showButton;
	}

	/**
	 * @param showButton the showButton to set
	 */
	public void setShowButton(boolean showButton) {
		this.showButton = showButton;
	}

	/**
	 * @return the controllerCompra
	 */
	public ControllerCompra getControllerCompra() {
		return controllerCompra;
	}

	/**
	 * @param controllerCompra the controllerCompra to set
	 */
	public void setControllerCompra(ControllerCompra controllerCompra) {
		this.controllerCompra = controllerCompra;
	}

	/**
	 * @return the controllerProduto
	 */
	public ControllerProduto getControllerProduto() {
		return controllerProduto;
	}

	/**
	 * @param controllerProduto the controllerProduto to set
	 */
	public void setControllerProduto(ControllerProduto controllerProduto) {
		this.controllerProduto = controllerProduto;
	}

	/**
	 * @return the controllerProdutosSelecionados
	 */
	public ControllerProdutosSelecionados getControllerProdutosSelecionados() {
		return controllerProdutosSelecionados;
	}

	/**
	 * @param controllerProdutosSelecionados the controllerProdutosSelecionados to set
	 */
	public void setControllerProdutosSelecionados(
			ControllerProdutosSelecionados controllerProdutosSelecionados) {
		this.controllerProdutosSelecionados = controllerProdutosSelecionados;
	}

	/**
	 * @return the scrollerPage
	 */
	public int getScrollerPage() {
		return scrollerPage;
	}

	/**
	 * @param scrollerPage the scrollerPage to set
	 */
	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	/**
	 * @return the condicaoPagamentoCompra
	 */
	public CondicaoPagamento getCondicaoPagamentoCompra() {
		return condicaoPagamentoCompra;
	}

	/**
	 * @param condicaoPagamentoCompra the condicaoPagamentoCompra to set
	 */
	public void setCondicaoPagamentoCompra(CondicaoPagamento condicaoPagamentoCompra) {
		this.condicaoPagamentoCompra = condicaoPagamentoCompra;
	}

	/**
	 * @return the contasPagar
	 */
	public List<ContaPagar> getContasPagar() {
		return contasPagar;
	}

	/**
	 * @param contasPagar the contasPagar to set
	 */
	public void setContasPagar(List<ContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
	}

	/**
	 * @return the produtos
	 * @throws Exception 
	 */
	public List<Produto> getProdutos() throws Exception {
		return produtos;
	}

	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	/**
	 * @return the controllerFornecedor
	 */
	public ControllerFornecedor getControllerFornecedor() {
		return controllerFornecedor;
	}

	/**
	 * @param controllerFornecedor the controllerFornecedor to set
	 */
	public void setControllerFornecedor(ControllerFornecedor controllerFornecedor) {
		this.controllerFornecedor = controllerFornecedor;
	}

	/**
	 * @return the salva
	 */
	public boolean isSalva() {
		return salva;
	}

	/**
	 * @param salva the salva to set
	 */
	public void setSalva(boolean salva) {
		this.salva = salva;
	}
	
}
