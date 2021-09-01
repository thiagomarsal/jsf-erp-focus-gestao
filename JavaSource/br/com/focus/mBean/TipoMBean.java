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

import br.com.focus.bean.Tipo;
import br.com.focus.controller.ControllerTipo;

/**
 * @author Thiago M. Farias
 * 
 */
public class TipoMBean {

	private Tipo tipo = new Tipo();
	private Tipo tipoSearch = new Tipo();
	private Tipo tipoModal = new Tipo();
	private List<Tipo> tipos = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerTipo controllerTipo = new ControllerTipo();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public TipoMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Tipo
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerTipo.saveOrUpdate(this.tipo);
		return "success";
	}

	/**
	 * @method Delete MBean Tipo
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerTipo.delete(this.tipo);
	}

	/**
	 * @method Update MBean Tipo
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerTipo.update(this.tipo);
	}

	/**
	 * @method Search by ID MBean Tipo
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.tipo = this.controllerTipo.search(this.tipo);
	}

	/**
	 * @method List All MBean Tipo
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.tipos = this.controllerTipo.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Tipo
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.tipoSearch != null)
				&& (!this.tipoSearch.getDescricao().trim().equals(""))) {
			this.tipos = null;
			System.out.println(this.tipoSearch.getDescricao());
			this.tipos = this.controllerTipo
					.searchByParameter(this.tipoSearch);
		} else {
			this.tipos = this.controllerTipo.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Tipo
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.tipoSearch != null)
				&& (!this.tipoSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Tipo tipoAux = new Tipo();
			if (component.getValue() != null) {
				tipoAux.setDescricao("%" + component.getValue() + "%");
			} else {
				tipoAux.setDescricao("%" + tipoSearch.getDescricao() + "%");
			}
			this.tipoSearch = new Tipo();
			this.tipoSearch.setDescricao(tipoAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Tipo
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idTipo = Long.valueOf(id);
		if (idTipo != null) {
			tipo.setIdTipo(idTipo);
			this.tipo = this.controllerTipo.search(this.tipo);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Tipo
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.tipo = new Tipo();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Tipo
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Tipo
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Tipo param = (Tipo) component.getValue();
		if (param != null) {
			this.tipoModal = this.controllerTipo.search(param);
			this.tipos = null;
		}
	}

	/**
	 * @method Listener Save MBean Tipo
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.tipo = new Tipo();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Tipo
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.tipo = new Tipo();
		this.tipoSearch = new Tipo();
		this.tipos = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idTipo", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Tipo
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Tipo param = (Tipo) component.getValue();
		if (param != null) {
			this.tipo = this.controllerTipo.search(param);
			this.tipos = null;
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
	 * @return the tipo
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the tipoSearch
	 */
	public Tipo getTipoSearch() {
		return tipoSearch;
	}

	/**
	 * @param tipoSearch the tipoSearch to set
	 */
	public void setTipoSearch(Tipo tipoSearch) {
		this.tipoSearch = tipoSearch;
	}

	/**
	 * @return the tipoModal
	 */
	public Tipo getTipoModal() {
		return tipoModal;
	}

	/**
	 * @param tipoModal the tipoModal to set
	 */
	public void setTipoModal(Tipo tipoModal) {
		this.tipoModal = tipoModal;
	}

	/**
	 * @return the tipos
	 */
	public List<Tipo> getTipos() {
		return tipos;
	}

	/**
	 * @param tipos the tipos to set
	 */
	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
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
	 * @return the controllerTipo
	 */
	public ControllerTipo getControllerTipo() {
		return controllerTipo;
	}

	/**
	 * @param controllerTipo the controllerTipo to set
	 */
	public void setControllerTipo(ControllerTipo controllerTipo) {
		this.controllerTipo = controllerTipo;
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
