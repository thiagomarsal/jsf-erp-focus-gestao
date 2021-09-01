/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.mBean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.focus.bean.Cidade;
import br.com.focus.bean.Estado;
import br.com.focus.bean.Fornecedor;
import br.com.focus.bean.Pais;
import br.com.focus.bean.superClasses.Endereco;
import br.com.focus.controller.ControllerFornecedor;

/**
 * @author Thiago M. Farias
 * 
 */
public class FornecedorMBean {

	private Fornecedor fornecedor = new Fornecedor(new Cidade());
	private Fornecedor fornecedorSearch = new Fornecedor();
	private Fornecedor fornecedorModal = new Fornecedor();
	private Cidade cidadeFornecedor = new Cidade();
	private Endereco enderecoFornecedor = new Endereco();
	private List<Fornecedor> fornecedores = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public FornecedorMBean() throws Exception {
		this.listAll();
	}
	
	/**
	 * @method Save MBean Fornecedor
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.fornecedor.setCidade(this.cidadeFornecedor);
		this.fornecedor.setEndereco(this.enderecoFornecedor);
		this.fornecedor.setDataAtualizacao(new Date());
		this.controllerFornecedor.saveOrUpdate(this.fornecedor);
		return "success";
	}

	/**
	 * @method Delete MBean Fornecedor
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerFornecedor.delete(this.fornecedor);
	}

	/**
	 * @method Update MBean Fornecedor
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.fornecedor.setCidade(this.cidadeFornecedor);
		this.fornecedor.setEndereco(this.enderecoFornecedor);
		this.controllerFornecedor.update(this.fornecedor);
	}

	/**
	 * @method Search by ID MBean Fornecedor
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.fornecedor = this.controllerFornecedor.search(this.fornecedor);
	}

	/**
	 * @method List All MBean Fornecedor
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.fornecedores = this.controllerFornecedor.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Fornecedor
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.fornecedorSearch != null)
				&& (!this.fornecedorSearch.getNomeRazaoSocial().trim().equals(""))) {
			this.fornecedores = null;
			System.out.println(this.fornecedorSearch.getNomeRazaoSocial());
			this.fornecedores = this.controllerFornecedor
					.searchByParameter(this.fornecedorSearch);
		} else {
			this.fornecedores = this.controllerFornecedor.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Fornecedor
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.fornecedorSearch != null)
				&& (!this.fornecedorSearch.getNomeRazaoSocial().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Fornecedor fornecedorAux = new Fornecedor();
			if (component.getValue() != null) {
				fornecedorAux.setNomeRazaoSocial("%" + component.getValue() + "%");
			} else {
				fornecedorAux.setNomeRazaoSocial("%" + fornecedorSearch.getNomeRazaoSocial() + "%");
			}
			this.fornecedorSearch = new Fornecedor();
			this.fornecedorSearch.setNomeRazaoSocial(fornecedorAux.getNomeRazaoSocial());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Fornecedor
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		this.fornecedor = new Fornecedor();
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idFornecedor = Long.valueOf(id);
		if (idFornecedor != null) {
			fornecedor.setIdFornecedor(idFornecedor);
			this.fornecedor = this.controllerFornecedor.search(this.fornecedor);
			if ((this.fornecedor != null) && (this.fornecedor.getCidade() != null)) {
				this.cidadeFornecedor.setIdCidade(this.fornecedor.getCidade().getIdCidade());
				this.cidadeFornecedor.setNome(this.fornecedor.getCidade().getNome());
				this.enderecoFornecedor.setLogradouro(this.fornecedor.getEndereco().getLogradouro());
                this.enderecoFornecedor.setNumeroPredial(this.fornecedor.getEndereco().getNumeroPredial());
                this.enderecoFornecedor.setBairro(this.fornecedor.getEndereco().getBairro());
                this.enderecoFornecedor.setCep(this.fornecedor.getEndereco().getCep());
                this.enderecoFornecedor.setComplemento(this.fornecedor.getEndereco().getComplemento());
			}
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Fornecedor
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.fornecedorModal = new Fornecedor();
		this.fornecedorSearch = new Fornecedor(); 
		this.fornecedor = new Fornecedor();
		this.cidadeFornecedor = new Cidade(new Estado(new Pais()));
		this.enderecoFornecedor = new Endereco();
		this.fornecedor.setDataCadastro(new Date());
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Fornecedor
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Fornecedor
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Long id = (Long) component.getValue();
		Long idFornecedor = Long.valueOf(id);
		if (idFornecedor != null) {
			fornecedorModal.setIdFornecedor(idFornecedor);
			this.fornecedorModal = this.controllerFornecedor.search(this.fornecedor);
			this.fornecedores = null;
		}
	}

	/**
	 * @method Listener Save MBean Fornecedor
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.fornecedor.setCidade(null);
		this.fornecedor.setEndereco(null);
		this.save();
		this.fornecedorModal = new Fornecedor();
		this.fornecedorSearch = new Fornecedor();
		this.fornecedor = new Fornecedor();
		this.cidadeFornecedor = new Cidade();
		this.enderecoFornecedor = new Endereco();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Fornecedor
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.fornecedor = new Fornecedor();
		this.cidadeFornecedor = new Cidade();
		this.enderecoFornecedor = new Endereco();
		this.fornecedorModal = new Fornecedor();
		this.fornecedorSearch = new Fornecedor();
		this.fornecedores = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idFornecedor", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Fornecedor
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		this.fornecedor = new Fornecedor();
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Long id = (Long) component.getValue();
		Long idFornecedor = Long.valueOf(id);
		if (idFornecedor != null) {
			fornecedor.setIdFornecedor(idFornecedor);
			this.fornecedor = this.controllerFornecedor.search(this.fornecedor);
			if ((this.fornecedor != null) && (this.fornecedor.getCidade() != null)) {
				this.cidadeFornecedor.setIdCidade(this.fornecedor.getCidade().getIdCidade());
				this.cidadeFornecedor.setNome(this.fornecedor.getCidade().getNome());
				this.enderecoFornecedor.setLogradouro(this.fornecedor.getEndereco().getLogradouro());
                this.enderecoFornecedor.setNumeroPredial(this.fornecedor.getEndereco().getNumeroPredial());
                this.enderecoFornecedor.setBairro(this.fornecedor.getEndereco().getBairro());
                this.enderecoFornecedor.setCep(this.fornecedor.getEndereco().getCep());
                this.enderecoFornecedor.setComplemento(this.fornecedor.getEndereco().getComplemento());
			}
			this.fornecedores = null;
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
	 * @return the fornecedor
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * @return the fornecedorSearch
	 */
	public Fornecedor getFornecedorSearch() {
		return fornecedorSearch;
	}

	/**
	 * @param fornecedorSearch the fornecedorSearch to set
	 */
	public void setFornecedorSearch(Fornecedor fornecedorSearch) {
		this.fornecedorSearch = fornecedorSearch;
	}

	/**
	 * @return the fornecedorModal
	 */
	public Fornecedor getFornecedorModal() {
		return fornecedorModal;
	}

	/**
	 * @param fornecedorModal the fornecedorModal to set
	 */
	public void setFornecedorModal(Fornecedor fornecedorModal) {
		this.fornecedorModal = fornecedorModal;
	}

	/**
	 * @return the cidadeFornecedor
	 */
	public Cidade getCidadeFornecedor() {
		return cidadeFornecedor;
	}

	/**
	 * @param cidadeFornecedor the cidadeFornecedor to set
	 */
	public void setCidadeFornecedor(Cidade cidadeFornecedor) {
		this.cidadeFornecedor = cidadeFornecedor;
	}

	/**
	 * @return the fornecedores
	 */
	public List<Fornecedor> getFornecedors() {
		return fornecedores;
	}

	/**
	 * @param fornecedores the fornecedores to set
	 */
	public void setFornecedors(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
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
	 * @return the fornecedores
	 */
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	/**
	 * @param fornecedores the fornecedores to set
	 */
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
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
	 * @return the enderecoFornecedor
	 */
	public Endereco getEnderecoFornecedor() {
		return enderecoFornecedor;
	}

	/**
	 * @param enderecoFornecedor the enderecoFornecedor to set
	 */
	public void setEnderecoFornecedor(Endereco enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}


}
