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

import br.com.focus.bean.ContaPagar;
import br.com.focus.bean.FormaPagamento;
import br.com.focus.bean.Fornecedor;
import br.com.focus.bean.StatusContas;
import br.com.focus.controller.ControllerContaPagar;

/**
 * @author Thiago M. Farias
 * 
 */
public class ContaPagarMBean {

	private ContaPagar contaPagar = new ContaPagar(new FormaPagamento(), new Fornecedor());
	private ContaPagar contaPagarSearch = new ContaPagar();
	private ContaPagar contaPagarModal = new ContaPagar();
	private FormaPagamento formaPagamentoContaPagar = new FormaPagamento();
	private Fornecedor fornecedorContaPagar = new Fornecedor();
	private List<ContaPagar> contasPagar = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerContaPagar controllerContaPagar = new ControllerContaPagar();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public ContaPagarMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean ContaPagar
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.contaPagar.setFormaPagamento(this.formaPagamentoContaPagar);
		this.contaPagar.setFornecedor(this.fornecedorContaPagar);
		this.contaPagar.setStatusContas(StatusContas.ABERTO);
		this.controllerContaPagar.saveOrUpdate(this.contaPagar);
		return "success";
	}

	/**
	 * @method Delete MBean ContaPagar
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.contaPagar.setStatusContas(StatusContas.CANCELADO);
		this.controllerContaPagar.saveOrUpdate(this.contaPagar);
	}

	/**
	 * @method Update MBean ContaPagar
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.contaPagar.setFormaPagamento(this.formaPagamentoContaPagar);
		this.contaPagar.setFornecedor(this.fornecedorContaPagar);
		this.controllerContaPagar.update(this.contaPagar);
	}

	/**
	 * @method Search by ID MBean ContaPagar
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.contaPagar = this.controllerContaPagar.search(this.contaPagar);
	}

	/**
	 * @method List All MBean ContaPagar
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.contasPagar = this.controllerContaPagar.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean ContaPagar
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.contaPagarSearch != null)
				&& (!this.contaPagarSearch.getNumeroDocumento().trim().equals(""))) {
			this.contasPagar = null;
			System.out.println(this.contaPagarSearch.getNumeroDocumento());
			this.contasPagar = this.controllerContaPagar
					.searchByParameter(this.contaPagarSearch);
		} else {
			this.contasPagar = this.controllerContaPagar.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean ContaPagar
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.contaPagarSearch != null)
				&& (!this.contaPagarSearch.getNumeroDocumento().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			ContaPagar contaPagarAux = new ContaPagar();
			if (component.getValue() != null) {
				contaPagarAux.setNumeroDocumento("%" + component.getValue() + "%");
			} else {
				contaPagarAux.setNumeroDocumento("%" + contaPagarSearch.getNumeroDocumento() + "%");
			}
			this.contaPagarSearch = new ContaPagar();
			this.contaPagarSearch.setNumeroDocumento(contaPagarAux.getNumeroDocumento());
		}
	}

	/**
	 * @method Listener Delete Screen MBean ContaPagar
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idContaPagar = Long.valueOf(id);
		if (idContaPagar != null) {
			contaPagar.setIdContaPagar(idContaPagar);
			this.contaPagar = this.controllerContaPagar.search(this.contaPagar);
			if ((this.contaPagar != null) && (this.contaPagar.getFormaPagamento() != null)) {
				this.formaPagamentoContaPagar.setIdFormaPagamento(this.contaPagar.getFormaPagamento().getIdFormaPagamento());
				this.formaPagamentoContaPagar.setDescricao(this.contaPagar.getFormaPagamento().getDescricao());
				this.fornecedorContaPagar.setIdFornecedor(this.contaPagar.getFornecedor().getIdFornecedor());
				this.fornecedorContaPagar.setNomeRazaoSocial(this.contaPagar.getFornecedor().getNomeRazaoSocial());
			}
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean ContaPagar
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.contaPagar = new ContaPagar();
		this.formaPagamentoContaPagar = new FormaPagamento();
		this.fornecedorContaPagar = new Fornecedor();
		this.setEditing();
	}

	/**
	 * @method Listener Select Screen MBean ContaPagar
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean ContaPagar
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Long id = (Long) component.getValue();
		Long idContaPagar = Long.valueOf(id);
		if (idContaPagar != null) {
			contaPagar.setIdContaPagar(idContaPagar);
			this.contaPagar = this.controllerContaPagar.search(this.contaPagar);
			this.contasPagar = null;
		}
	}

	/**
	 * @method Listener Save MBean ContaPagar
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.contaPagar.setFormaPagamento(null);
		this.contaPagar.setFornecedor(null);
		this.save();
		this.contaPagar = new ContaPagar();
		this.formaPagamentoContaPagar = new FormaPagamento();
		this.fornecedorContaPagar = new Fornecedor();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean ContaPagar
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.contaPagar = new ContaPagar();
		this.formaPagamentoContaPagar = new FormaPagamento();
		this.fornecedorContaPagar = new Fornecedor();
		this.contaPagarSearch = new ContaPagar();
		this.contasPagar = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idContaPagar", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean ContaPagar
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Long id = (Long) component.getValue();
		Long idContaPagar = Long.valueOf(id);
		if (idContaPagar != null) {
			contaPagar.setIdContaPagar(idContaPagar);
			this.contaPagar = this.controllerContaPagar.search(this.contaPagar);
			if ((this.contaPagar != null) && (this.contaPagar.getFormaPagamento() != null)) {
				this.formaPagamentoContaPagar.setIdFormaPagamento(this.contaPagar.getFormaPagamento().getIdFormaPagamento());
				this.formaPagamentoContaPagar.setDescricao(this.contaPagar.getFormaPagamento().getDescricao());
				this.fornecedorContaPagar.setIdFornecedor(this.contaPagar.getFornecedor().getIdFornecedor());
				this.fornecedorContaPagar.setNomeRazaoSocial(this.contaPagar.getFornecedor().getNomeRazaoSocial());
			}
			this.contasPagar = null;
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
	 * @return the contaPagar
	 */
	public ContaPagar getContaPagar() {
		return contaPagar;
	}

	/**
	 * @param contaPagar the contaPagar to set
	 */
	public void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
	}

	/**
	 * @return the contaPagarSearch
	 */
	public ContaPagar getContaPagarSearch() {
		return contaPagarSearch;
	}

	/**
	 * @param contaPagarSearch the contaPagarSearch to set
	 */
	public void setContaPagarSearch(ContaPagar contaPagarSearch) {
		this.contaPagarSearch = contaPagarSearch;
	}

	/**
	 * @return the contaPagarModal
	 */
	public ContaPagar getContaPagarModal() {
		return contaPagarModal;
	}

	/**
	 * @param contaPagarModal the contaPagarModal to set
	 */
	public void setContaPagarModal(ContaPagar contaPagarModal) {
		this.contaPagarModal = contaPagarModal;
	}

	/**
	 * @return the contasPagar
	 */
	public List<ContaPagar> getContaPagars() {
		return contasPagar;
	}

	/**
	 * @param contasPagar the contasPagar to set
	 */
	public void setContaPagars(List<ContaPagar> contasPagar) {
		this.contasPagar = contasPagar;
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
	 * @return the controllerContaPagar
	 */
	public ControllerContaPagar getControllerContaPagar() {
		return controllerContaPagar;
	}

	/**
	 * @param controllerContaPagar the controllerContaPagar to set
	 */
	public void setControllerContaPagar(ControllerContaPagar controllerContaPagar) {
		this.controllerContaPagar = controllerContaPagar;
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
	 * @return the formaPagamentoContaPagar
	 */
	public FormaPagamento getFormaPagamentoContaPagar() {
		return formaPagamentoContaPagar;
	}

	/**
	 * @param formaPagamentoContaPagar the formaPagamentoContaPagar to set
	 */
	public void setFormaPagamentoContaPagar(FormaPagamento formaPagamentoContaPagar) {
		this.formaPagamentoContaPagar = formaPagamentoContaPagar;
	}

	/**
	 * @return the fornecedorContaPagar
	 */
	public Fornecedor getFornecedorContaPagar() {
		return fornecedorContaPagar;
	}

	/**
	 * @param fornecedorContaPagar the fornecedorContaPagar to set
	 */
	public void setFornecedorContaPagar(Fornecedor fornecedorContaPagar) {
		this.fornecedorContaPagar = fornecedorContaPagar;
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
	
}
