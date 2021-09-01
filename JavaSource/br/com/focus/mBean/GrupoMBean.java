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

import br.com.focus.bean.Grupo;
import br.com.focus.controller.ControllerGrupo;

/**
 * @author Thiago M. Farias
 * 
 */
public class GrupoMBean {

	private Grupo grupo = new Grupo();
	private Grupo grupoSearch = new Grupo();
	private Grupo grupoModal = new Grupo();
	private List<Grupo> grupos = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerGrupo controllerGrupo = new ControllerGrupo();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public GrupoMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Grupo
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerGrupo.saveOrUpdate(this.grupo);
		return "success";
	}

	/**
	 * @method Delete MBean Grupo
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerGrupo.delete(this.grupo);
	}

	/**
	 * @method Update MBean Grupo
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerGrupo.update(this.grupo);
	}

	/**
	 * @method Search by ID MBean Grupo
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.grupo = this.controllerGrupo.search(this.grupo);
	}

	/**
	 * @method List All MBean Grupo
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.grupos = this.controllerGrupo.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Grupo
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.grupoSearch != null)
				&& (!this.grupoSearch.getDescricao().trim().equals(""))) {
			this.grupos = null;
			System.out.println(this.grupoSearch.getDescricao());
			this.grupos = this.controllerGrupo
					.searchByParameter(this.grupoSearch);
		} else {
			this.grupos = this.controllerGrupo.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Grupo
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.grupoSearch != null)
				&& (!this.grupoSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Grupo grupoAux = new Grupo();
			if (component.getValue() != null) {
				grupoAux.setDescricao("%" + component.getValue() + "%");
			} else {
				grupoAux.setDescricao("%" + grupoSearch.getDescricao() + "%");
			}
			this.grupoSearch = new Grupo();
			this.grupoSearch.setDescricao(grupoAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Grupo
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idGrupo = Long.valueOf(id);
		if (idGrupo != null) {
			grupo.setIdGrupo(idGrupo);
			this.grupo = this.controllerGrupo.search(this.grupo);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Grupo
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.grupo = new Grupo();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Grupo
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Grupo
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Grupo param = (Grupo) component.getValue();
		if (param != null) {
			this.grupoModal = this.controllerGrupo.search(param);
			this.grupos = null;
		}
	}

	/**
	 * @method Listener Save MBean Grupo
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.grupo = new Grupo();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Grupo
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.grupo = new Grupo();
		this.grupoSearch = new Grupo();
		this.grupos = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idGrupo", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Grupo
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Grupo param = (Grupo) component.getValue();
		if (param != null) {
			this.grupo = this.controllerGrupo.search(param);
			this.grupos = null;
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
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the grupoSearch
	 */
	public Grupo getGrupoSearch() {
		return grupoSearch;
	}

	/**
	 * @param grupoSearch the grupoSearch to set
	 */
	public void setGrupoSearch(Grupo grupoSearch) {
		this.grupoSearch = grupoSearch;
	}

	/**
	 * @return the grupoModal
	 */
	public Grupo getGrupoModal() {
		return grupoModal;
	}

	/**
	 * @param grupoModal the grupoModal to set
	 */
	public void setGrupoModal(Grupo grupoModal) {
		this.grupoModal = grupoModal;
	}

	/**
	 * @return the grupos
	 */
	public List<Grupo> getGrupos() {
		return grupos;
	}

	/**
	 * @param grupos the grupos to set
	 */
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
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
	 * @return the controllerGrupo
	 */
	public ControllerGrupo getControllerGrupo() {
		return controllerGrupo;
	}

	/**
	 * @param controllerGrupo the controllerGrupo to set
	 */
	public void setControllerGrupo(ControllerGrupo controllerGrupo) {
		this.controllerGrupo = controllerGrupo;
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
