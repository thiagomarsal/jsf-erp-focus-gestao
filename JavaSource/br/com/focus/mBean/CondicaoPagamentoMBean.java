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

import br.com.focus.bean.CondicaoPagamento;
import br.com.focus.bean.FormaPagamento;
import br.com.focus.controller.ControllerCondicaoPagamento;

/**
 * @author Thiago M. Farias
 * 
 */
public class CondicaoPagamentoMBean {

	private CondicaoPagamento condicaoPagamento = new CondicaoPagamento(new FormaPagamento());
	private CondicaoPagamento condicaoPagamentoSearch = new CondicaoPagamento();
	private CondicaoPagamento condicaoPagamentoModal = new CondicaoPagamento();
	private FormaPagamento formaPagamentoCondicaoPagamento = new FormaPagamento();
	private List<CondicaoPagamento> condicoesPagamento = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerCondicaoPagamento controllerCondicaoPagamento = new ControllerCondicaoPagamento();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public CondicaoPagamentoMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean CondicaoPagamento
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerCondicaoPagamento.saveOrUpdate(this.condicaoPagamento);
		return "success";
	}

	/**
	 * @method Delete MBean CondicaoPagamento
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerCondicaoPagamento.delete(this.condicaoPagamento);
	}

	/**
	 * @method Update MBean CondicaoPagamento
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerCondicaoPagamento.update(this.condicaoPagamento);
	}

	/**
	 * @method Search by ID MBean CondicaoPagamento
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.condicaoPagamento = this.controllerCondicaoPagamento.search(this.condicaoPagamento);
	}

	/**
	 * @method List All MBean CondicaoPagamento
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.condicoesPagamento = this.controllerCondicaoPagamento.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean CondicaoPagamento
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.condicaoPagamentoSearch != null)
				&& (!this.condicaoPagamentoSearch.getDescricao().trim().equals(""))) {
			this.condicoesPagamento = null;
			this.condicoesPagamento = this.controllerCondicaoPagamento
					.searchByParameter(this.condicaoPagamentoSearch);
		} else {
			this.condicoesPagamento = this.controllerCondicaoPagamento.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean CondicaoPagamento
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.condicaoPagamentoSearch != null)
				&& (!this.condicaoPagamentoSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			CondicaoPagamento condicaoPagamentoAux = new CondicaoPagamento();
			if (component.getValue() != null) {
				condicaoPagamentoAux.setDescricao("%" + component.getValue() + "%");
			} else {
				condicaoPagamentoAux.setDescricao("%" + condicaoPagamentoSearch.getDescricao() + "%");
			}
			this.condicaoPagamentoSearch = new CondicaoPagamento();
			this.condicaoPagamentoSearch.setDescricao(condicaoPagamentoAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean CondicaoPagamento
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idCondicaoPagamento = Long.valueOf(id);
		if (idCondicaoPagamento != null) {
			condicaoPagamento.setIdCondicaoPagamento(idCondicaoPagamento);
			this.condicaoPagamento = this.controllerCondicaoPagamento.search(this.condicaoPagamento);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean CondicaoPagamento
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.condicaoPagamento = new CondicaoPagamento();
		this.formaPagamentoCondicaoPagamento = new FormaPagamento();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean CondicaoPagamento
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean CondicaoPagamento
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		CondicaoPagamento param = (CondicaoPagamento) component.getValue();
		if (param != null) {
			this.condicaoPagamentoModal = this.controllerCondicaoPagamento.search(param);
			this.condicoesPagamento = null;
		}
	}

	/**
	 * @method Listener Save MBean CondicaoPagamento
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.condicaoPagamento = new CondicaoPagamento();
		this.formaPagamentoCondicaoPagamento = new FormaPagamento();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean CondicaoPagamento
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.condicaoPagamento = new CondicaoPagamento();
		this.formaPagamentoCondicaoPagamento = new FormaPagamento();
		this.condicaoPagamentoSearch = new CondicaoPagamento();
		this.condicoesPagamento = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idCondicaoPagamento", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean CondicaoPagamento
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		CondicaoPagamento param = (CondicaoPagamento) component.getValue();
		if (param != null) {
			this.condicaoPagamento = this.controllerCondicaoPagamento.search(param);
			this.condicoesPagamento = null;
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
	 * @return the condicaoPagamento
	 */
	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	/**
	 * @param condicaoPagamento the condicaoPagamento to set
	 */
	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	/**
	 * @return the condicaoPagamentoSearch
	 */
	public CondicaoPagamento getCondicaoPagamentoSearch() {
		return condicaoPagamentoSearch;
	}

	/**
	 * @param condicaoPagamentoSearch the condicaoPagamentoSearch to set
	 */
	public void setCondicaoPagamentoSearch(CondicaoPagamento condicaoPagamentoSearch) {
		this.condicaoPagamentoSearch = condicaoPagamentoSearch;
	}

	/**
	 * @return the condicaoPagamentoModal
	 */
	public CondicaoPagamento getCondicaoPagamentoModal() {
		return condicaoPagamentoModal;
	}

	/**
	 * @param condicaoPagamentoModal the condicaoPagamentoModal to set
	 */
	public void setCondicaoPagamentoModal(CondicaoPagamento condicaoPagamentoModal) {
		this.condicaoPagamentoModal = condicaoPagamentoModal;
	}

	/**
	 * @return the formaPagamentoCondicaoPagamento
	 */
	public FormaPagamento getFormaPagamentoCondicaoPagamento() {
		return formaPagamentoCondicaoPagamento;
	}

	/**
	 * @param formaPagamentoCondicaoPagamento the formaPagamentoCondicaoPagamento to set
	 */
	public void setFormaPagamentoCondicaoPagamento(
			FormaPagamento formaPagamentoCondicaoPagamento) {
		this.formaPagamentoCondicaoPagamento = formaPagamentoCondicaoPagamento;
	}

	/**
	 * @return the condicoesPagamento
	 */
	public List<CondicaoPagamento> getCondicoesPagamento() {
		return condicoesPagamento;
	}

	/**
	 * @param condicoesPagamento the condicoesPagamento to set
	 */
	public void setCondicoesPagamento(List<CondicaoPagamento> condicoesPagamento) {
		this.condicoesPagamento = condicoesPagamento;
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
	 * @return the controllerCondicaoPagamento
	 */
	public ControllerCondicaoPagamento getControllerCondicaoPagamento() {
		return controllerCondicaoPagamento;
	}

	/**
	 * @param controllerCondicaoPagamento the controllerCondicaoPagamento to set
	 */
	public void setControllerCondicaoPagamento(
			ControllerCondicaoPagamento controllerCondicaoPagamento) {
		this.controllerCondicaoPagamento = controllerCondicaoPagamento;
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
