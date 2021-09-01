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

import br.com.focus.bean.Receita;
import br.com.focus.bean.Venda;
import br.com.focus.bean.CondicaoPagamento;
import br.com.focus.bean.ContaReceber;
import br.com.focus.bean.Cliente;
import br.com.focus.bean.Produto;
import br.com.focus.bean.ProdutosSelecionados;
import br.com.focus.bean.StatusContas;
import br.com.focus.bean.StatusPedido;
import br.com.focus.bean.Usuario;
import br.com.focus.controller.ControllerReceita;
import br.com.focus.controller.ControllerVenda;
import br.com.focus.controller.ControllerProduto;
import br.com.focus.controller.ControllerProdutosSelecionados;



/**
 * @author Thiago M. Farias
 * 
 */
public class VendaMBean {

	private Venda venda = new Venda(new Cliente(), new CondicaoPagamento(), new Usuario());
    private Venda vendaSearch = new Venda(new Cliente(), new CondicaoPagamento(), new Usuario());
    private Venda vendaModal = new Venda(new Cliente(), new CondicaoPagamento(), new Usuario());
    private Cliente clienteVenda = new Cliente();
    private Usuario usuarioVenda = new Usuario();
    private CondicaoPagamento condicaoPagamentoVenda = new CondicaoPagamento();
    private Produto produto = new Produto();
    private List<Produto> produtos = null;
    private List<ProdutosSelecionados> produtosSelecionados = null;
    private List<ContaReceber> contasReceber = null;
    private List<Venda> vendas = null;
    private boolean inEditing = false;
    private boolean showButton = false;
    private ControllerVenda controllerVenda = new ControllerVenda();
    private ControllerProduto controllerProduto = new ControllerProduto();
    private ControllerReceita controllerReceita = new ControllerReceita();
    private ControllerProdutosSelecionados controllerProdutosSelecionados = new ControllerProdutosSelecionados();
    private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public VendaMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Venda
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.venda.setContasReceber(this.contasReceber);
		this.venda.setProdutosSelecionados(this.produtosSelecionados);
		this.venda.setCliente(this.clienteVenda);
		this.venda.setCondicaoPagamento(this.condicaoPagamentoVenda);
		this.venda.setUsuario(this.usuarioVenda);
		this.venda.setStatusPedido(StatusPedido.CONCLUIDO);
		this.venda.setDataEmissao(new Date());
		this.controllerVenda.saveOrUpdate(this.venda);
		this.removeEstoque();
		return "success";
	}

	/**
	 * @method Delete MBean Venda
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.venda.setStatusPedido(StatusPedido.CANCELADO);
		for (ContaReceber cp : contasReceber){
			cp.setStatusContas(StatusContas.CANCELADO);
		}
		this.controllerVenda.saveOrUpdate(this.venda);
		this.geraEstoque();
	}

	/**
	 * @method Update MBean Venda
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.venda.setContasReceber(this.contasReceber);
		this.venda.setProdutosSelecionados(this.produtosSelecionados);
		this.venda.setCliente(this.clienteVenda);
		this.venda.setCondicaoPagamento(this.condicaoPagamentoVenda);
		this.venda.setUsuario(this.usuarioVenda);
		this.controllerVenda.update(this.venda);
	}

	/**
	 * @method Search by ID MBean Venda
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.venda = this.controllerVenda.search(this.venda);
	}

	/**
	 * @method List All MBean Venda
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.vendas = this.controllerVenda.listAll();
		return "welcome";
	}
	
	/**
	 * @method List All MBean Venda
	 * @return String
	 * @throws Exception
	 */
	public List<Produto> listAllProdutos() throws Exception {
		this.produtos = this.controllerProduto.listAll();
		return produtos;
	}
	
	/**
	 * @method Search by Parameter with Like MBean Venda
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.vendaSearch != null)
				&& (!this.vendaSearch.getCliente().getNomeRazaoSocial().trim().equals(""))) {
			this.vendas = null;
			this.vendas = this.controllerVenda.searchByParameter(this.vendaSearch);
		} else {
			this.vendas = this.controllerVenda.listAll();
		}
		return null;
	}

	/**
	 * @method Calculate value of services MBean Venda
	 * @return Double
	 * @throws Exception
	 **/
	public Double somaTotalProdutos(){
	Double total = 0.0;
		for (ProdutosSelecionados item : getProdutosSelecionados()) {
			if(item.getPrecoTotal()!=null)
			total += item.getPrecoTotal();
		}
		venda.setTotalProdutos(total);
		venda.setDesconto(new Double(0));
		this.calculaValores();
		return total;
	}
	
	public Long setaNumeroNota(){
		Long idNota = new Long(0);
		Long j = new Long(0);
		for (int i = 0; i < vendas.size(); i++){
			Venda v = vendas.get(i);
			j = v.getIdVenda();
			if (j <= v.getIdVenda()){
				idNota = v.getIdVenda() + 1;
				System.out.println("XXXXXXXXXxX" + idNota);
				j = v.getIdVenda();
			}
		}
		return idNota;
	}
	
	public Double calculaDesconto(){
		Double total = 0.0;
		//this.somaTotalProdutos();
		total = venda.getTotalProdutos() - venda.getDesconto();
		venda.setTotalProdutos(total);
		venda.setTotalVenda(total);
		return total;
	}
	
	public Double calculaValores(){
		Double total = 0.0;
		total = venda.getTotalProdutos();
		venda.setTotalVenda(total);
		return total;
	}

	public void geraEstoque() throws Exception{
		List<Produto> listProdutos = this.listAllProdutos();
		for (int i = 0; i < produtosSelecionados.size(); i++){
			ProdutosSelecionados ps = produtosSelecionados.get(i);
			for (int j = 0; j < listProdutos.size(); j++){
				Produto p = listProdutos.get(j);
				if (ps.getProduto().getIdProduto().longValue() == p.getIdProduto() && (p.getEstoque() != null)){
					p.setEstoque(p.getEstoque() + ps.getQuantidade().intValue());
				}else{
					p.setEstoque(ps.getQuantidade().intValue());
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
	 * @method Listener Insert Item List Service MBean Venda
	 */
	public void listenerInsertItemList(ActionEvent actionEvent) throws Exception {
		UIParameter componentProduto = (UIParameter) actionEvent.getComponent().findComponent("paramModalProduto");
		UIParameter componentReceita = (UIParameter) actionEvent.getComponent().findComponent("paramModalReceita");
		if (componentProduto != null){
		Produto paramP = null;
		paramP = (Produto) componentProduto.getValue();
		if (paramP != null) {
			Produto produto = new Produto();
			produto = this.controllerProduto.search(paramP);
			List<ProdutosSelecionados> ps = produtosSelecionados;
			if (ps == null){
				ps = new ArrayList<ProdutosSelecionados>();
			}
			ProdutosSelecionados item = new ProdutosSelecionados();
			item.setIdentificador("P");
			item.setProduto(produto.clone());
			item.setDescricao(produto.getDescricao());
			item.setUnidade(produto.getUnidade().getSigla());
			item.setPrecoUnitario(produto.getPrecoVenda());
			boolean isInsert = false;
			for (ProdutosSelecionados prodsel : ps){
				if((prodsel.getProduto().getIdProduto().longValue() == item.getProduto().getIdProduto().longValue()) && (item.getIdentificador().equals("P"))){
					isInsert = true;
				}
			}
			if (!isInsert){
				ps.add(item);
				this.produtosSelecionados = ps;
			}else{
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Produto já Existente", "Erro!");
				FacesContext.getCurrentInstance().addMessage("descricaoProdutoSelecionado", facesMessage);
			}
			componentProduto = null;
		}
		}else{
			Receita paramR = null;
			paramR = (Receita) componentReceita.getValue();
			if (paramR != null) {
				Receita receita = new Receita();
				receita = this.controllerReceita.search(paramR);
				List<ProdutosSelecionados> ps = produtosSelecionados;
				if (ps == null){
					ps = new ArrayList<ProdutosSelecionados>();
				}
				ProdutosSelecionados item = new ProdutosSelecionados();
				item.setIdentificador("R");
				item.setReceita(receita.clone());
				item.setDescricao(receita.getDescricao());
				item.setUnidade("UN");
				item.setPrecoUnitario(receita.getPrecoVenda());
				boolean isInsert = false;
				for (ProdutosSelecionados prodsel : ps){
					if((prodsel.getReceita().getIdReceita().longValue() == item.getReceita().getIdReceita().longValue()) && (item.getIdentificador().equals("R"))){
						isInsert = true;
					}
				}
				if (!isInsert){
					ps.add(item);
					this.produtosSelecionados = ps;
				}else{
					FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Receita já Existente", "Erro!");
					FacesContext.getCurrentInstance().addMessage("descricaoProdutoSelecionado", facesMessage);
				}
				componentReceita = null;
			}
		}
	}
	
	/**
	 * @method Listener Remove Item List Service MBean Venda
	 */
	public void listenerRemoveItemList(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		ProdutosSelecionados param = (ProdutosSelecionados) component.getValue();
		if (param != null) {
			getProdutosSelecionados().remove(param);
			controllerProdutosSelecionados.delete(param);
			this.somaTotalProdutos();
			venda.getTotalProdutos();
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
		Double valorTotalVenda = this.venda.getTotalVenda();
		Long numeroDocumento = this.setaNumeroNota();
		Double valorParcela = new Double(valorTotalVenda / parcelas);
		Date dataVencimento = new Date();
		Calendar calendar = Calendar.getInstance();
		List<ContaReceber>rc = new ArrayList<ContaReceber>();
			for (int i = 0; i < parcelas; i++) {
				int j = 0;
				j = i + 1;
				ContaReceber cp = new ContaReceber();
				cp.setDataVencimento(dataVencimento);
				cp.setCliente(this.clienteVenda);
				cp.setNumeroDocumento(numeroDocumento + "/" + j );
				cp.setValor(valorParcela);
				cp.setStatusContas(StatusContas.ABERTO);
				calendar.add(Calendar.MONTH, 1);
				dataVencimento = calendar.getTime();
				rc.add(cp);
				this.contasReceber = rc;
			}
		}
	}
	
	/**
	 * @method Listener Search by Parameter MBean Venda
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.vendaSearch != null)
				&& (!this.vendaSearch.getCliente().getNomeRazaoSocial().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Cliente clienteAux = new Cliente();
			if (component.getValue() != null) {
				clienteAux.setNomeRazaoSocial("%" + component.getValue() + "%");
			} else {
				clienteAux.setNomeRazaoSocial("%" + vendaSearch.getCliente().getNomeRazaoSocial() + "%");
			}
			this.vendaSearch = new Venda();
			this.vendaSearch.getCliente().setNomeRazaoSocial(clienteAux.getNomeRazaoSocial());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Venda
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		this.venda = new Venda();
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idVenda = Long.valueOf(id);
		if (idVenda != null) {
			venda.setIdVenda(idVenda);
			this.venda = this.controllerVenda.search(this.venda);
			if ((this.venda != null) && (this.venda.getCliente() != null) && (this.venda.getUsuario() != null)) {
				this.contasReceber = this.venda.getContasReceber();
				this.produtosSelecionados = this.venda.getProdutosSelecionados();
                this.clienteVenda.setIdCliente(this.venda.getCliente().getIdCliente());
                this.clienteVenda.setNomeRazaoSocial(this.venda.getCliente().getNomeRazaoSocial());
                this.usuarioVenda.setIdUsuario(this.venda.getUsuario().getIdUsuario());
                this.usuarioVenda.setLogin(this.venda.getUsuario().getLogin());
                this.condicaoPagamentoVenda.setIdCondicaoPagamento(this.venda.getCondicaoPagamento().getIdCondicaoPagamento());
                this.condicaoPagamentoVenda.setDescricao(this.venda.getCondicaoPagamento().getDescricao());
            }
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Venda
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.venda = new Venda();
		this.produtosSelecionados = null;
		this.contasReceber = new ArrayList<ContaReceber>();
		this.produtosSelecionados = new ArrayList<ProdutosSelecionados>();
		this.venda.setTotalProdutos(new Double(0));
		this.venda.setTotalVenda(new Double(0));
		this.venda.setDesconto(new Double(0));
		this.venda.setDataEmissao(new Date());
        this.condicaoPagamentoVenda = new CondicaoPagamento();
        this.clienteVenda = new Cliente();
        this.usuarioVenda = new Usuario();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Venda
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Venda
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Long id = (Long) component.getValue();
		Long idVenda = Long.valueOf(id);
		if (idVenda != null) {
			venda.setIdVenda(idVenda);
			this.venda = this.controllerVenda.search(this.venda);
			this.vendas = null;
		}
	}

	/**
	 * @method Listener Save MBean Venda
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.venda.setContasReceber(null);
		this.venda.setProdutosSelecionados(null);
		this.venda.setCliente(null);
		this.venda.setCondicaoPagamento(null);
        this.venda.setUsuario(null);
		this.save();
		this.contasReceber = new ArrayList<ContaReceber>();
		this.produtosSelecionados = new ArrayList<ProdutosSelecionados>();
        this.condicaoPagamentoVenda = new CondicaoPagamento();
        this.clienteVenda = new Cliente();
        this.usuarioVenda = new Usuario();
		this.setEditing();
	}
	
	/**
	 * @method Listener Delete MBean Venda
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.venda = new Venda();
        this.condicaoPagamentoVenda = new CondicaoPagamento();
        this.clienteVenda = new Cliente();
        this.usuarioVenda = new Usuario();
		this.vendaSearch = new Venda();
		this.produtosSelecionados = new ArrayList<ProdutosSelecionados>();
		this.contasReceber = new ArrayList<ContaReceber>();
		this.vendas = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idVenda", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Venda
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		this.venda = new Venda();
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Long id = (Long) component.getValue();
		Long idVenda = Long.valueOf(id);
		if (idVenda != null) {
			venda.setIdVenda(idVenda);
			this.venda = this.controllerVenda.search(this.venda);
			if ((this.venda != null) && (this.venda.getCliente() != null) && (this.venda.getUsuario() != null)) {
				this.contasReceber = this.venda.getContasReceber();
				this.produtosSelecionados = this.venda.getProdutosSelecionados();
                this.clienteVenda.setIdCliente(this.venda.getCliente().getIdCliente());
                this.clienteVenda.setNomeRazaoSocial(this.venda.getCliente().getNomeRazaoSocial());
                this.usuarioVenda.setIdUsuario(this.venda.getUsuario().getIdUsuario());
                this.usuarioVenda.setLogin(this.venda.getUsuario().getLogin());
                this.condicaoPagamentoVenda.setIdCondicaoPagamento(this.venda.getCondicaoPagamento().getIdCondicaoPagamento());
                this.condicaoPagamentoVenda.setDescricao(this.venda.getCondicaoPagamento().getDescricao());
            }
			this.vendas = null;
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
	 * @return the venda
	 */
	public Venda getVenda() {
		return venda;
	}

	/**
	 * @param venda the venda to set
	 */
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	/**
	 * @return the vendaSearch
	 */
	public Venda getVendaSearch() {
		return vendaSearch;
	}

	/**
	 * @param vendaSearch the vendaSearch to set
	 */
	public void setVendaSearch(Venda vendaSearch) {
		this.vendaSearch = vendaSearch;
	}

	/**
	 * @return the vendaModal
	 */
	public Venda getVendaModal() {
		return vendaModal;
	}

	/**
	 * @param vendaModal the vendaModal to set
	 */
	public void setVendaModal(Venda vendaModal) {
		this.vendaModal = vendaModal;
	}

	/**
	 * @return the clienteVenda
	 */
	public Cliente getClienteVenda() {
		return clienteVenda;
	}

	/**
	 * @param clienteVenda the clienteVenda to set
	 */
	public void setClienteVenda(Cliente clienteVenda) {
		this.clienteVenda = clienteVenda;
	}

	/**
	 * @return the usuarioVenda
	 */
	public Usuario getUsuarioVenda() {
		return usuarioVenda;
	}

	/**
	 * @param usuarioVenda the usuarioVenda to set
	 */
	public void setUsuarioVenda(Usuario usuarioVenda) {
		this.usuarioVenda = usuarioVenda;
	}

	/**
	 * @return the condicaoPagamentoVenda
	 */
	public CondicaoPagamento getCondicaoPagamentoVenda() {
		return condicaoPagamentoVenda;
	}

	/**
	 * @param condicaoPagamentoVenda the condicaoPagamentoVenda to set
	 */
	public void setCondicaoPagamentoVenda(CondicaoPagamento condicaoPagamentoVenda) {
		this.condicaoPagamentoVenda = condicaoPagamentoVenda;
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
	 * @return the produtos
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
	 * @return the contasReceber
	 */
	public List<ContaReceber> getContasReceber() {
		return contasReceber;
	}

	/**
	 * @param contasReceber the contasReceber to set
	 */
	public void setContasReceber(List<ContaReceber> contasReceber) {
		this.contasReceber = contasReceber;
	}

	/**
	 * @return the vendas
	 */
	public List<Venda> getVendas() {
		return vendas;
	}

	/**
	 * @param vendas the vendas to set
	 */
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
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
	 * @return the controllerVenda
	 */
	public ControllerVenda getControllerVenda() {
		return controllerVenda;
	}

	/**
	 * @param controllerVenda the controllerVenda to set
	 */
	public void setControllerVenda(ControllerVenda controllerVenda) {
		this.controllerVenda = controllerVenda;
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
	 * @return the controllerReceita
	 */
	public ControllerReceita getControllerReceita() {
		return controllerReceita;
	}

	/**
	 * @param controllerReceita the controllerReceita to set
	 */
	public void setControllerReceita(ControllerReceita controllerReceita) {
		this.controllerReceita = controllerReceita;
	}
}
