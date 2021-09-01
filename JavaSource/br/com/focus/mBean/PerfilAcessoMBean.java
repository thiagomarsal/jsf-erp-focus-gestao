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

import br.com.focus.bean.PerfilAcesso;
import br.com.focus.controller.ControllerPerfilAcesso;

/**
 * @author Thiago M. Farias
 * 
 */
public class PerfilAcessoMBean {

	private PerfilAcesso perfilAcesso = new PerfilAcesso();
	private PerfilAcesso perfilAcessoSearch = new PerfilAcesso();
	private PerfilAcesso perfilAcessoModal = new PerfilAcesso();
	private List<PerfilAcesso> perfisAcesso = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerPerfilAcesso controllerPerfilAcesso = new ControllerPerfilAcesso();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public PerfilAcessoMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Perfil
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerPerfilAcesso.saveOrUpdate(this.perfilAcesso);
		return "success";
	}

	/**
	 * @method Delete MBean Perfil
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerPerfilAcesso.delete(this.perfilAcesso);
	}

	/**
	 * @method Update MBean Perfil
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerPerfilAcesso.update(this.perfilAcesso);
	}

	/**
	 * @method Search by ID MBean Perfil
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.perfilAcesso = this.controllerPerfilAcesso.search(this.perfilAcesso);
	}

	/**
	 * @method List All MBean Perfil
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.perfisAcesso = this.controllerPerfilAcesso.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Perfil
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.perfilAcessoSearch != null)
				&& (!this.perfilAcessoSearch.getDescricao().trim().equals(""))) {
			this.perfisAcesso = null;
			this.perfisAcesso = this.controllerPerfilAcesso
					.searchByParameter(this.perfilAcessoSearch);
		} else {
			this.perfisAcesso = this.controllerPerfilAcesso.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Perfil
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.perfilAcessoSearch != null)
				&& (!this.perfilAcessoSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			PerfilAcesso perfilAcessoAux = new PerfilAcesso();
			if (component.getValue() != null) {
				perfilAcessoAux.setDescricao("%" + component.getValue() + "%");
			} else {
				perfilAcessoAux.setDescricao("%" + perfilAcessoSearch.getDescricao() + "%");
			}
			this.perfilAcessoSearch = new PerfilAcesso();
			this.perfilAcessoSearch.setDescricao(perfilAcessoAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Perfil
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idPerfilAcesso = Long.valueOf(id);
		if (idPerfilAcesso != null) {
			perfilAcesso.setIdPerfilAcesso(idPerfilAcesso);
			this.perfilAcesso = this.controllerPerfilAcesso.search(this.perfilAcesso);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Perfil
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.perfilAcesso = new PerfilAcesso();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Perfil
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Perfil
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		PerfilAcesso param = (PerfilAcesso) component.getValue();
		if (param != null) {
			this.perfilAcessoModal = this.controllerPerfilAcesso.search(param);
			this.perfisAcesso = null;
		}
	}

	/**
	 * @method Listener Save MBean Perfil
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.perfilAcesso = new PerfilAcesso();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Perfil
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.perfilAcesso = new PerfilAcesso();
		this.perfilAcessoSearch = new PerfilAcesso();
		this.perfisAcesso = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idPerfilAcesso", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Perfil
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		PerfilAcesso param = (PerfilAcesso) component.getValue();
		if (param != null) {
			this.perfilAcesso = this.controllerPerfilAcesso.search(param);
			this.perfisAcesso = null;
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
	 * @return the perfilAcesso
	 */
	public PerfilAcesso getPerfilAcesso() {
		return perfilAcesso;
	}

	/**
	 * @param perfilAcesso the perfilAcesso to set
	 */
	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

	/**
	 * @return the perfilAcessoSearch
	 */
	public PerfilAcesso getPerfilAcessoSearch() {
		return perfilAcessoSearch;
	}

	/**
	 * @param perfilAcessoSearch the perfilAcessoSearch to set
	 */
	public void setPerfilAcessoSearch(PerfilAcesso perfilAcessoSearch) {
		this.perfilAcessoSearch = perfilAcessoSearch;
	}

	/**
	 * @return the perfilAcessoModal
	 */
	public PerfilAcesso getPerfilAcessoModal() {
		return perfilAcessoModal;
	}

	/**
	 * @param perfilAcessoModal the perfilAcessoModal to set
	 */
	public void setPerfilAcessoModal(PerfilAcesso perfilAcessoModal) {
		this.perfilAcessoModal = perfilAcessoModal;
	}

	/**
	 * @return the perfisAcesso
	 */
	public List<PerfilAcesso> getPerfisAcesso() {
		return perfisAcesso;
	}

	/**
	 * @param perfisAcesso the perfisAcesso to set
	 */
	public void setPerfisAcesso(List<PerfilAcesso> perfisAcesso) {
		this.perfisAcesso = perfisAcesso;
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
	 * @return the controllerPerfilAcesso
	 */
	public ControllerPerfilAcesso getControllerPerfilAcesso() {
		return controllerPerfilAcesso;
	}

	/**
	 * @param controllerPerfilAcesso the controllerPerfilAcesso to set
	 */
	public void setControllerPerfilAcesso(
			ControllerPerfilAcesso controllerPerfilAcesso) {
		this.controllerPerfilAcesso = controllerPerfilAcesso;
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
