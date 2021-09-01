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

import br.com.focus.bean.Servico;
import br.com.focus.controller.ControllerServico;

/**
 * @author Thiago M. Farias
 * 
 */
public class ServicoMBean {

	private Servico servico = new Servico();
	private Servico servicoSearch = new Servico();
	private Servico servicoModal = new Servico();
	private List<Servico> servicos = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerServico controllerServico = new ControllerServico();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public ServicoMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Servico
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerServico.saveOrUpdate(this.servico);
		return "success";
	}

	/**
	 * @method Delete MBean Servico
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerServico.delete(this.servico);
	}

	/**
	 * @method Update MBean Servico
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerServico.update(this.servico);
	}

	/**
	 * @method Search by ID MBean Servico
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.servico = this.controllerServico.search(this.servico);
	}

	/**
	 * @method List All MBean Servico
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.servicos = this.controllerServico.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Servico
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.servicoSearch != null)
				&& (!this.servicoSearch.getDescricao().trim().equals(""))) {
			this.servicos = null;
			this.servicos = this.controllerServico
					.searchByParameter(this.servicoSearch);
		} else {
			this.servicos = this.controllerServico.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Servico
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.servicoSearch != null)
				&& (!this.servicoSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Servico servicoAux = new Servico();
			if (component.getValue() != null) {
				servicoAux.setDescricao("%" + component.getValue() + "%");
			} else {
				servicoAux.setDescricao("%" + servicoSearch.getDescricao()
						+ "%");
			}
			this.servicoSearch = new Servico();
			this.servicoSearch.setDescricao(servicoAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Servico
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idServico = Long.valueOf(id);
		if (idServico != null) {
			servico.setIdServico(idServico);
			this.servico = this.controllerServico.search(this.servico);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Servico
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.servico = new Servico();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Servico
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Servico
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Servico param = (Servico) component.getValue();
		if (param != null) {
			this.servicoModal = this.controllerServico.search(param);
			this.servicos = null;
		}
	}

	/**
	 * @method Listener Save MBean Servico
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.servico = new Servico();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Servico
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.servico = new Servico();
		this.servicoSearch = new Servico();
		this.servicos = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idServico", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Servico
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramUpdate");
		Servico param = (Servico) component.getValue();
		if (param != null) {
			this.servico = this.controllerServico.search(param);
			this.servicos = null;
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
	 * @return the servico
	 */
	public Servico getServico() {
		return servico;
	}

	/**
	 * @param servico
	 *            the servico to set
	 */
	public void setServico(Servico servico) {
		this.servico = servico;
	}

	/**
	 * @return the servicoSearch
	 */
	public Servico getServicoSearch() {
		return servicoSearch;
	}

	/**
	 * @param servicoSearch
	 *            the servicoSearch to set
	 */
	public void setServicoSearch(Servico servicoSearch) {
		this.servicoSearch = servicoSearch;
	}

	/**
	 * @return the servicoModal
	 */
	public Servico getServicoModal() {
		return servicoModal;
	}

	/**
	 * @param servicoModal
	 *            the servicoModal to set
	 */
	public void setServicoModal(Servico servicoModal) {
		this.servicoModal = servicoModal;
	}

	/**
	 * @return the servicos
	 */
	public List<Servico> getServicos() {
		return servicos;
	}

	/**
	 * @param servicos
	 *            the servicos to set
	 */
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	/**
	 * @return the inEditing
	 */
	public boolean isInEditing() {
		return inEditing;
	}

	/**
	 * @param inEditing
	 *            the inEditing to set
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
	 * @param showButton
	 *            the showButton to set
	 */
	public void setShowButton(boolean showButton) {
		this.showButton = showButton;
	}

	/**
	 * @return the controllerServico
	 */
	public ControllerServico getControllerServico() {
		return controllerServico;
	}

	/**
	 * @param controllerServico
	 *            the controllerServico to set
	 */
	public void setControllerServico(ControllerServico controllerServico) {
		this.controllerServico = controllerServico;
	}

	/**
	 * @return the scrollerPage
	 */
	public int getScrollerPage() {
		return scrollerPage;
	}

	/**
	 * @param scrollerPage
	 *            the scrollerPage to set
	 */
	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

}
