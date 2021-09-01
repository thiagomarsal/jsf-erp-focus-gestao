/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.mBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import br.com.focus.bean.FormaPagamento;
import br.com.focus.controller.ControllerFormaPagamento;

/**
 * @author Thiago M. Farias
 * 
 */
public class FormaPagamentoMBean {

	private FormaPagamento formaPagamento = new FormaPagamento();
	private FormaPagamento formaPagamentoSearch = new FormaPagamento();
	private FormaPagamento formaPagamentoModal = new FormaPagamento();
	private List<FormaPagamento> formasPagamento = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerFormaPagamento controllerFormaPagamento = new ControllerFormaPagamento();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public FormaPagamentoMBean() throws Exception {
		this.listAll();
	}
	
	public List<SelectItem> getListFormaPagamento(){
		List<SelectItem> itens = new ArrayList<SelectItem>();
		for (FormaPagamento formaPagamento :  getFormasPagamento()){
			itens.add(new SelectItem(formaPagamento.getDescricao()));
		}
		return itens;
	}
	
	/**
	 * @method Save MBean FormaPagamento
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerFormaPagamento.saveOrUpdate(this.formaPagamento);
		return "success";
	}

	/**
	 * @method Delete MBean FormaPagamento
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerFormaPagamento.delete(this.formaPagamento);
	}

	/**
	 * @method Update MBean FormaPagamento
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerFormaPagamento.update(this.formaPagamento);
	}

	/**
	 * @method Search by ID MBean FormaPagamento
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.formaPagamento = this.controllerFormaPagamento.search(this.formaPagamento);
	}

	/**
	 * @method List All MBean FormaPagamento
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.formasPagamento = this.controllerFormaPagamento.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean FormaPagamento
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.formaPagamentoSearch != null)
				&& (!this.formaPagamentoSearch.getDescricao().trim().equals(""))) {
			this.formasPagamento = null;
			System.out.println(this.formaPagamentoSearch.getDescricao());
			this.formasPagamento = this.controllerFormaPagamento
					.searchByParameter(this.formaPagamentoSearch);
		} else {
			this.formasPagamento = this.controllerFormaPagamento.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean FormaPagamento
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.formaPagamentoSearch != null)
				&& (!this.formaPagamentoSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			FormaPagamento formaPagamentoAux = new FormaPagamento();
			if (component.getValue() != null) {
				formaPagamentoAux.setDescricao("%" + component.getValue() + "%");
			} else {
				formaPagamentoAux.setDescricao("%" + formaPagamentoSearch.getDescricao() + "%");
			}
			this.formaPagamentoSearch = new FormaPagamento();
			this.formaPagamentoSearch.setDescricao(formaPagamentoAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean FormaPagamento
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idFormaPagamento = Long.valueOf(id);
		if (idFormaPagamento != null) {
			formaPagamento.setIdFormaPagamento(idFormaPagamento);
			this.formaPagamento = this.controllerFormaPagamento.search(this.formaPagamento);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean FormaPagamento
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.formaPagamento = new FormaPagamento();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean FormaPagamento
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean FormaPagamento
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		FormaPagamento param = (FormaPagamento) component.getValue();
		if (param != null) {
			this.formaPagamentoModal = this.controllerFormaPagamento.search(param);
			this.formasPagamento = null;
		}
	}

	/**
	 * @method Listener Save MBean FormaPagamento
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.formaPagamento = new FormaPagamento();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean FormaPagamento
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.formaPagamento = new FormaPagamento();
		this.formaPagamentoSearch = new FormaPagamento();
		this.formasPagamento = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idFormaPagamento", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean FormaPagamento
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		FormaPagamento param = (FormaPagamento) component.getValue();
		if (param != null) {
			this.formaPagamento = this.controllerFormaPagamento.search(param);
			this.formasPagamento = null;
		}
		this.setEditing();
	}

	/**
	 * @method Set the screen for editing 
	 * the showButton to set true 
	 * the inEditing to set false
	 */
	private void setEditing() {
		this.showButton = true;
		this.inEditing = false;
	}

	/**
	 * @method Set the screen for deleting 
	 * the showButton to set false 
	 * the inEditing to set true
	 */
	private void setDeleting() {
		this.showButton = false;
		this.inEditing = true;
	}

	/**
	 * @return the formaPagamento
	 */
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	/**
	 * @param formaPagamento the formaPagamento to set
	 */
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	/**
	 * @return the formaPagamentoSearch
	 */
	public FormaPagamento getFormaPagamentoSearch() {
		return formaPagamentoSearch;
	}

	/**
	 * @param formaPagamentoSearch the formaPagamentoSearch to set
	 */
	public void setFormaPagamentoSearch(FormaPagamento formaPagamentoSearch) {
		this.formaPagamentoSearch = formaPagamentoSearch;
	}

	/**
	 * @return the formaPagamentoModal
	 */
	public FormaPagamento getFormaPagamentoModal() {
		return formaPagamentoModal;
	}

	/**
	 * @param formaPagamentoModal the formaPagamentoModal to set
	 */
	public void setFormaPagamentoModal(FormaPagamento formaPagamentoModal) {
		this.formaPagamentoModal = formaPagamentoModal;
	}

	/**
	 * @return the formasPagamento
	 */
	public List<FormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	/**
	 * @param formasPagamento the formasPagamento to set
	 */
	public void setFormasPagamento(List<FormaPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
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
	 * @return the controllerFormaPagamento
	 */
	public ControllerFormaPagamento getControllerFormaPagamento() {
		return controllerFormaPagamento;
	}

	/**
	 * @param controllerFormaPagamento the controllerFormaPagamento to set
	 */
	public void setControllerFormaPagamento(
			ControllerFormaPagamento controllerFormaPagamento) {
		this.controllerFormaPagamento = controllerFormaPagamento;
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
