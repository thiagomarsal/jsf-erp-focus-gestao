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

import br.com.focus.bean.ContaReceber;
import br.com.focus.bean.FormaPagamento;
import br.com.focus.bean.Cliente;
import br.com.focus.bean.StatusContas;
import br.com.focus.controller.ControllerContaReceber;

/**
 * @author Thiago M. Farias
 * 
 */
public class ContaReceberMBean {

	private ContaReceber contaReceber = new ContaReceber(new FormaPagamento(), new Cliente());
	private ContaReceber contaReceberSearch = new ContaReceber();
	private ContaReceber contaReceberModal = new ContaReceber();
	private FormaPagamento formaPagamentoContaReceber = new FormaPagamento();
	private Cliente clienteContaReceber = new Cliente();
	private List<ContaReceber> contasReceber = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerContaReceber controllerContaReceber = new ControllerContaReceber();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public ContaReceberMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean ContaReceber
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.contaReceber.setFormaPagamento(this.formaPagamentoContaReceber);
		this.contaReceber.setCliente(this.clienteContaReceber);
		this.contaReceber.setStatusContas(StatusContas.ABERTO);
		this.controllerContaReceber.saveOrUpdate(this.contaReceber);
		return "success";
	}

	/**
	 * @method Delete MBean ContaReceber
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.contaReceber.setStatusContas(StatusContas.CANCELADO);
		this.controllerContaReceber.saveOrUpdate(this.contaReceber);
	}

	/**
	 * @method Update MBean ContaReceber
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.contaReceber.setFormaPagamento(this.formaPagamentoContaReceber);
		this.contaReceber.setCliente(this.clienteContaReceber);
		this.controllerContaReceber.update(this.contaReceber);
	}

	/**
	 * @method Search by ID MBean ContaReceber
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.contaReceber = this.controllerContaReceber.search(this.contaReceber);
	}

	/**
	 * @method List All MBean ContaReceber
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.contasReceber = this.controllerContaReceber.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean ContaReceber
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.contaReceberSearch != null)
				&& (!this.contaReceberSearch.getNumeroDocumento().trim().equals(""))) {
			this.contasReceber = null;
			System.out.println(this.contaReceberSearch.getNumeroDocumento());
			this.contasReceber = this.controllerContaReceber
					.searchByParameter(this.contaReceberSearch);
		} else {
			this.contasReceber = this.controllerContaReceber.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean ContaReceber
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.contaReceberSearch != null)
				&& (!this.contaReceberSearch.getNumeroDocumento().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			ContaReceber contaReceberAux = new ContaReceber();
			if (component.getValue() != null) {
				contaReceberAux.setNumeroDocumento("%" + component.getValue() + "%");
			} else {
				contaReceberAux.setNumeroDocumento("%" + contaReceberSearch.getNumeroDocumento() + "%");
			}
			this.contaReceberSearch = new ContaReceber();
			this.contaReceberSearch.setNumeroDocumento(contaReceberAux.getNumeroDocumento());
		}
	}

	/**
	 * @method Listener Delete Screen MBean ContaReceber
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idContaReceber = Long.valueOf(id);
		if (idContaReceber != null) {
			contaReceber.setIdContaReceber(idContaReceber);
			this.contaReceber = this.controllerContaReceber.search(this.contaReceber);
			if ((this.contaReceber != null) && (this.contaReceber.getFormaPagamento() != null)) {
				this.formaPagamentoContaReceber.setIdFormaPagamento(this.contaReceber.getFormaPagamento().getIdFormaPagamento());
				this.formaPagamentoContaReceber.setDescricao(this.contaReceber.getFormaPagamento().getDescricao());
				this.clienteContaReceber.setIdCliente(this.contaReceber.getCliente().getIdCliente());
				this.clienteContaReceber.setNomeRazaoSocial(this.contaReceber.getCliente().getNomeRazaoSocial());
			}
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean ContaReceber
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.contaReceber = new ContaReceber();
		this.formaPagamentoContaReceber = new FormaPagamento();
		this.clienteContaReceber = new Cliente();
		this.setEditing();
	}

	/**
	 * @method Listener Select Screen MBean ContaReceber
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean ContaReceber
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		ContaReceber param = (ContaReceber) component.getValue();
		if (param != null) {
			this.contaReceberModal = this.controllerContaReceber.search(param);
			this.contasReceber = null;
		}
	}

	/**
	 * @method Listener Save MBean ContaReceber
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.contaReceber.setFormaPagamento(null);
		this.contaReceber.setCliente(null);
		this.save();
		this.contaReceber = new ContaReceber();
		this.formaPagamentoContaReceber = new FormaPagamento();
		this.clienteContaReceber = new Cliente();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean ContaReceber
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.contaReceber = new ContaReceber();
		this.formaPagamentoContaReceber = new FormaPagamento();
		this.clienteContaReceber = new Cliente();
		this.contaReceberSearch = new ContaReceber();
		this.contasReceber = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idContaReceber", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean ContaReceber
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		ContaReceber param = (ContaReceber) component.getValue();
		if (param != null) {
			this.contaReceber = this.controllerContaReceber.search(param);
			if ((this.contaReceber != null) && (this.contaReceber.getFormaPagamento() != null)) {
				this.formaPagamentoContaReceber.setIdFormaPagamento(this.contaReceber.getFormaPagamento().getIdFormaPagamento());
				this.formaPagamentoContaReceber.setDescricao(this.contaReceber.getFormaPagamento().getDescricao());
				this.clienteContaReceber.setIdCliente(this.contaReceber.getCliente().getIdCliente());
				this.clienteContaReceber.setNomeRazaoSocial(this.contaReceber.getCliente().getNomeRazaoSocial());
			}
			this.contasReceber = null;
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
	 * @return the contaReceber
	 */
	public ContaReceber getContaReceber() {
		return contaReceber;
	}

	/**
	 * @param contaReceber the contaReceber to set
	 */
	public void setContaReceber(ContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}

	/**
	 * @return the contaReceberSearch
	 */
	public ContaReceber getContaReceberSearch() {
		return contaReceberSearch;
	}

	/**
	 * @param contaReceberSearch the contaReceberSearch to set
	 */
	public void setContaReceberSearch(ContaReceber contaReceberSearch) {
		this.contaReceberSearch = contaReceberSearch;
	}

	/**
	 * @return the contaReceberModal
	 */
	public ContaReceber getContaReceberModal() {
		return contaReceberModal;
	}

	/**
	 * @param contaReceberModal the contaReceberModal to set
	 */
	public void setContaReceberModal(ContaReceber contaReceberModal) {
		this.contaReceberModal = contaReceberModal;
	}

	/**
	 * @return the contasReceber
	 */
	public List<ContaReceber> getContaRecebers() {
		return contasReceber;
	}

	/**
	 * @param contasReceber the contasReceber to set
	 */
	public void setContaRecebers(List<ContaReceber> contasReceber) {
		this.contasReceber = contasReceber;
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
	 * @return the controllerContaReceber
	 */
	public ControllerContaReceber getControllerContaReceber() {
		return controllerContaReceber;
	}

	/**
	 * @param controllerContaReceber the controllerContaReceber to set
	 */
	public void setControllerContaReceber(ControllerContaReceber controllerContaReceber) {
		this.controllerContaReceber = controllerContaReceber;
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
	 * @return the formaPagamentoContaReceber
	 */
	public FormaPagamento getFormaPagamentoContaReceber() {
		return formaPagamentoContaReceber;
	}

	/**
	 * @param formaPagamentoContaReceber the formaPagamentoContaReceber to set
	 */
	public void setFormaPagamentoContaReceber(FormaPagamento formaPagamentoContaReceber) {
		this.formaPagamentoContaReceber = formaPagamentoContaReceber;
	}

	/**
	 * @return the clienteContaReceber
	 */
	public Cliente getClienteContaReceber() {
		return clienteContaReceber;
	}

	/**
	 * @param clienteContaReceber the clienteContaReceber to set
	 */
	public void setClienteContaReceber(Cliente clienteContaReceber) {
		this.clienteContaReceber = clienteContaReceber;
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
	
}
