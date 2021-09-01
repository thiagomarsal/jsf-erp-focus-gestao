/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.mBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.focus.bean.Material;
import br.com.focus.bean.Tipo;
import br.com.focus.bean.Unidade;
import br.com.focus.bean.Cor;
import br.com.focus.bean.Grupo;
import br.com.focus.bean.Linha;
import br.com.focus.bean.Marca;
import br.com.focus.bean.Modelo;
import br.com.focus.bean.Produto;
import br.com.focus.controller.ControllerProduto;


/**
 * @author Thiago M. Farias
 * 
 */
public class ProdutoMBean {

	private Produto produto = new Produto(new Marca(), new Linha(), new Unidade(), new Modelo(), new Cor(), new Grupo(), new Tipo(), new Material());
    private Produto produtoSearch = new Produto();
    private Produto produtoModal = new Produto();
    private Marca marcaProduto = new Marca();
    private Linha linhaProduto = new Linha();
    private Unidade unidadeProduto = new Unidade();
    private Modelo modeloProduto = new Modelo();
    private Tipo tipoProduto = new Tipo();
    private Material materialProduto = new Material();
    private Grupo grupoProduto = new Grupo();
    private Cor corProduto = new Cor();
    private List<Produto> produtos = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerProduto controllerProduto = new ControllerProduto();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public ProdutoMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Produto
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.produto.setUnidade(this.unidadeProduto);
        this.produto.setCor(this.corProduto);
        this.produto.setMarca(this.marcaProduto);
        this.produto.setLinha(this.linhaProduto);
        this.produto.setModelo(this.modeloProduto);
        this.produto.setGrupo(this.grupoProduto);
        this.produto.setTipo(this.tipoProduto);
        this.produto.setMaterial(this.materialProduto);
        this.calculaPrecoVenda();
		this.controllerProduto.saveOrUpdate(this.produto);
		return "success";
	}

	/**
	 * @method Delete MBean Produto
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerProduto.delete(this.produto);
	}

	/**
	 * @method Update MBean Produto
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.produto.setUnidade(this.unidadeProduto);
        this.produto.setCor(this.corProduto);
        this.produto.setMarca(this.marcaProduto);
        this.produto.setLinha(this.linhaProduto);
        this.produto.setModelo(this.modeloProduto);
        this.produto.setGrupo(this.grupoProduto);
        this.produto.setTipo(this.tipoProduto);
        this.produto.setMaterial(this.materialProduto);
        this.calculaPrecoVenda();
		this.controllerProduto.update(this.produto);
	}

	/**
	 * @method Search by ID MBean Produto
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.produto = this.controllerProduto.search(this.produto);
	}

	/**
	 * @method List All MBean Produto
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.produtos = this.controllerProduto.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Produto
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.produtoSearch != null)
				&& (!this.produtoSearch.getDescricao().trim().equals(""))) {
			this.produtos = null;
			this.produtos = this.controllerProduto
					.searchByParameter(this.produtoSearch);
		} else {
			this.produtos = this.controllerProduto.listAll();
		}
		return null;
	}
	
	/**
	 * @method Calculate value of services MBean Produto
	 * @return Double
	 * @throws Exception
	 */
	public Double calculaPrecoVenda(){
	Double precoVenda, valor = 0.0;
		if((produto.getAcrescimo() !=null) && (produto.getPrecoCusto() !=null))
			 valor = produto.getPrecoCusto();
			 precoVenda = (valor * produto.getAcrescimo() / 100.0) + valor ;
	    this.produto.setPrecoVenda(precoVenda);
		return precoVenda;
	}

	/**
	 * @method Listener Search by Parameter MBean Produto
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.produtoSearch != null)
				&& (!this.produtoSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Produto produtoAux = new Produto();
			if (component.getValue() != null) {
				produtoAux.setDescricao("%" + component.getValue() + "%");
			} else {
				produtoAux.setDescricao("%" + produtoSearch.getDescricao() + "%");
			}
			this.produtoSearch = new Produto();
			this.produtoSearch.setDescricao(produtoAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Produto
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idProduto = Long.valueOf(id);
		if (idProduto != null) {
			produto.setIdProduto(idProduto);
			this.produto = this.controllerProduto.search(this.produto);
			if ((this.produto != null) && (this.produto.getMarca() != null) && (this.produto.getLinha() != null) && (this.produto.getUnidade() != null) && (this.produto.getModelo() != null) && (this.produto.getGrupo() != null) && (this.produto.getCor() != null)) {
                this.marcaProduto.setIdMarca(this.produto.getMarca().getIdMarca());
                this.marcaProduto.setDescricao(this.produto.getMarca().getDescricao());
                this.linhaProduto.setIdLinha(this.produto.getLinha().getIdLinha());
                this.linhaProduto.setDescricao(this.produto.getLinha().getDescricao());
                this.unidadeProduto.setIdUnidade(this.produto.getUnidade().getIdUnidade());
                this.unidadeProduto.setSigla(this.produto.getUnidade().getSigla());
                this.modeloProduto.setIdModelo(this.produto.getModelo().getIdModelo());
                this.modeloProduto.setDescricao(this.produto.getModelo().getDescricao());
                this.grupoProduto.setIdGrupo(this.produto.getGrupo().getIdGrupo());
                this.grupoProduto.setDescricao(this.produto.getGrupo().getDescricao());
                this.corProduto.setIdCor(this.produto.getCor().getIdCor());
                this.corProduto.setDescricao(this.produto.getCor().getDescricao());
                this.tipoProduto.setIdTipo(this.produto.getTipo().getIdTipo());
                this.tipoProduto.setDescricao(this.produto.getTipo().getDescricao());
                this.materialProduto.setIdMaterial(this.produto.getMaterial().getIdMaterial());
                this.materialProduto.setDescricao(this.produto.getMaterial().getDescricao());
            }
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Produto
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.produto = new Produto();
		this.produtoModal = new Produto();
		this.produtoSearch = new Produto();
		this.produto.setEstoque(0);
		this.produto.setPrecoCusto(0.0);
		this.produto.setAcrescimo(0.0);
		this.unidadeProduto = new Unidade();
        this.corProduto = new Cor();
        this.marcaProduto = new Marca();
        this.linhaProduto = new Linha();
        this.modeloProduto = new Modelo();
        this.grupoProduto = new Grupo();
        this.tipoProduto = new Tipo();
        this.materialProduto = new Material();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Produto
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Produto
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Long id = (Long) component.getValue();
		Long idProduto = Long.valueOf(id);
		if (idProduto != null) {
			produtoModal.setIdProduto(idProduto);
			this.produtoModal = this.controllerProduto.search(this.produtoModal);
			this.produtos = null;
		}
	}

	/**
	 * @method Listener Save MBean Produto
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.produto.setMarca(null);
        this.produto.setCor(null);
        this.produto.setUnidade(null);
        this.produto.setLinha(null);
        this.produto.setModelo(null);
        this.produto.setGrupo(null);
        this.produto.setTipo(null);
        this.produto.setMaterial(null);
		this.save();
		this.produto = new Produto();
		this.produtoModal = new Produto();
		this.produtoSearch = new Produto();
		this.unidadeProduto = new Unidade();
        this.corProduto = new Cor();
        this.marcaProduto = new Marca();
        this.linhaProduto = new Linha();
        this.modeloProduto = new Modelo();
        this.grupoProduto = new Grupo();
        this.tipoProduto = new Tipo();
        this.materialProduto = new Material();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Produto
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.produto = new Produto();
		this.unidadeProduto = new Unidade();
        this.corProduto = new Cor();
        this.marcaProduto = new Marca();
        this.linhaProduto = new Linha();
        this.modeloProduto = new Modelo();
        this.grupoProduto = new Grupo();
        this.tipoProduto = new Tipo();
        this.materialProduto = new Material();
        this.produtoModal = new Produto();
		this.produtoSearch = new Produto();
		this.produtos = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idProduto", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Produto
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		this.produto = new Produto();
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Long id = (Long) component.getValue();
		Long idProduto = Long.valueOf(id);
		if (idProduto != null) {
			produto.setIdProduto(idProduto);
			this.produto = this.controllerProduto.search(this.produto);
			if ((this.produto != null) && (this.produto.getMarca() != null) && (this.produto.getLinha() != null) && (this.produto.getUnidade() != null) && (this.produto.getModelo() != null) && (this.produto.getGrupo() != null) && (this.produto.getCor() != null)) {
				this.marcaProduto.setIdMarca(this.produto.getMarca().getIdMarca());
                this.marcaProduto.setDescricao(this.produto.getMarca().getDescricao());
                this.linhaProduto.setIdLinha(this.produto.getLinha().getIdLinha());
                this.linhaProduto.setDescricao(this.produto.getLinha().getDescricao());
                this.unidadeProduto.setIdUnidade(this.produto.getUnidade().getIdUnidade());
                this.unidadeProduto.setSigla(this.produto.getUnidade().getSigla());
                this.modeloProduto.setIdModelo(this.produto.getModelo().getIdModelo());
                this.modeloProduto.setDescricao(this.produto.getModelo().getDescricao());
                this.grupoProduto.setIdGrupo(this.produto.getGrupo().getIdGrupo());
                this.grupoProduto.setDescricao(this.produto.getGrupo().getDescricao());
                this.corProduto.setIdCor(this.produto.getCor().getIdCor());
                this.corProduto.setDescricao(this.produto.getCor().getDescricao());
                this.tipoProduto.setIdTipo(this.produto.getTipo().getIdTipo());
                this.tipoProduto.setDescricao(this.produto.getTipo().getDescricao());
                this.materialProduto.setIdMaterial(this.produto.getMaterial().getIdMaterial());
                this.materialProduto.setDescricao(this.produto.getMaterial().getDescricao());
            }
			this.produtos = null;
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
	 * @return the produtoSearch
	 */
	public Produto getProdutoSearch() {
		return produtoSearch;
	}

	/**
	 * @param produtoSearch the produtoSearch to set
	 */
	public void setProdutoSearch(Produto produtoSearch) {
		this.produtoSearch = produtoSearch;
	}

	/**
	 * @return the produtoModal
	 */
	public Produto getProdutoModal() {
		return produtoModal;
	}

	/**
	 * @param produtoModal the produtoModal to set
	 */
	public void setProdutoModal(Produto produtoModal) {
		this.produtoModal = produtoModal;
	}

	/**
	 * @return the marcaProduto
	 */
	public Marca getMarcaProduto() {
		return marcaProduto;
	}

	/**
	 * @param marcaProduto the marcaProduto to set
	 */
	public void setMarcaProduto(Marca marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	/**
	 * @return the linhaProduto
	 */
	public Linha getLinhaProduto() {
		return linhaProduto;
	}

	/**
	 * @param linhaProduto the linhaProduto to set
	 */
	public void setLinhaProduto(Linha linhaProduto) {
		this.linhaProduto = linhaProduto;
	}

	/**
	 * @return the unidadeProduto
	 */
	public Unidade getUnidadeProduto() {
		return unidadeProduto;
	}

	/**
	 * @param unidadeProduto the unidadeProduto to set
	 */
	public void setUnidadeProduto(Unidade unidadeProduto) {
		this.unidadeProduto = unidadeProduto;
	}

	/**
	 * @return the modeloProduto
	 */
	public Modelo getModeloProduto() {
		return modeloProduto;
	}

	/**
	 * @param modeloProduto the modeloProduto to set
	 */
	public void setModeloProduto(Modelo modeloProduto) {
		this.modeloProduto = modeloProduto;
	}

	/**
	 * @return the tipoProduto
	 */
	public Tipo getTipoProduto() {
		return tipoProduto;
	}

	/**
	 * @param tipoProduto the tipoProduto to set
	 */
	public void setTipoProduto(Tipo tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	/**
	 * @return the materialProduto
	 */
	public Material getMaterialProduto() {
		return materialProduto;
	}

	/**
	 * @param materialProduto the materialProduto to set
	 */
	public void setMaterialProduto(Material materialProduto) {
		this.materialProduto = materialProduto;
	}

	/**
	 * @return the grupoProduto
	 */
	public Grupo getGrupoProduto() {
		return grupoProduto;
	}

	/**
	 * @param grupoProduto the grupoProduto to set
	 */
	public void setGrupoProduto(Grupo grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	/**
	 * @return the corProduto
	 */
	public Cor getCorProduto() {
		return corProduto;
	}

	/**
	 * @param corProduto the corProduto to set
	 */
	public void setCorProduto(Cor corProduto) {
		this.corProduto = corProduto;
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

}
