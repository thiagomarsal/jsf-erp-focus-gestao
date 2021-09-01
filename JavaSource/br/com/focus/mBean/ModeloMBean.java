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

import br.com.focus.bean.Modelo;
import br.com.focus.controller.ControllerModelo;

/**
 * @author Thiago M. Farias
 * 
 */
public class ModeloMBean {

	private Modelo modelo = new Modelo();
	private Modelo modeloSearch = new Modelo();
	private Modelo modeloModal = new Modelo();
	private List<Modelo> modelos = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerModelo controllerModelo = new ControllerModelo();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public ModeloMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Modelo
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerModelo.saveOrUpdate(this.modelo);
		return "success";
	}

	/**
	 * @method Delete MBean Modelo
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerModelo.delete(this.modelo);
	}

	/**
	 * @method Update MBean Modelo
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerModelo.update(this.modelo);
	}

	/**
	 * @method Search by ID MBean Modelo
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.modelo = this.controllerModelo.search(this.modelo);
	}

	/**
	 * @method List All MBean Modelo
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.modelos = this.controllerModelo.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Modelo
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.modeloSearch != null)
				&& (!this.modeloSearch.getDescricao().trim().equals(""))) {
			this.modelos = null;
			System.out.println(this.modeloSearch.getDescricao());
			this.modelos = this.controllerModelo
					.searchByParameter(this.modeloSearch);
		} else {
			this.modelos = this.controllerModelo.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Modelo
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.modeloSearch != null)
				&& (!this.modeloSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Modelo modeloAux = new Modelo();
			if (component.getValue() != null) {
				modeloAux.setDescricao("%" + component.getValue() + "%");
			} else {
				modeloAux.setDescricao("%" + modeloSearch.getDescricao() + "%");
			}
			this.modeloSearch = new Modelo();
			this.modeloSearch.setDescricao(modeloAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Modelo
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idModelo = Long.valueOf(id);
		if (idModelo != null) {
			modelo.setIdModelo(idModelo);
			this.modelo = this.controllerModelo.search(this.modelo);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Modelo
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.modelo = new Modelo();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Modelo
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Modelo
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Modelo param = (Modelo) component.getValue();
		if (param != null) {
			this.modeloModal = this.controllerModelo.search(param);
			this.modelos = null;
		}
	}

	/**
	 * @method Listener Save MBean Modelo
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.modelo = new Modelo();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Modelo
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.modelo = new Modelo();
		this.modeloSearch = new Modelo();
		this.modelos = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idModelo", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Modelo
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Modelo param = (Modelo) component.getValue();
		if (param != null) {
			this.modelo = this.controllerModelo.search(param);
			this.modelos = null;
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
	 * @return the modelo
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the modeloSearch
	 */
	public Modelo getModeloSearch() {
		return modeloSearch;
	}

	/**
	 * @param modeloSearch the modeloSearch to set
	 */
	public void setModeloSearch(Modelo modeloSearch) {
		this.modeloSearch = modeloSearch;
	}

	/**
	 * @return the modeloModal
	 */
	public Modelo getModeloModal() {
		return modeloModal;
	}

	/**
	 * @param modeloModal the modeloModal to set
	 */
	public void setModeloModal(Modelo modeloModal) {
		this.modeloModal = modeloModal;
	}

	/**
	 * @return the modelos
	 */
	public List<Modelo> getModelos() {
		return modelos;
	}

	/**
	 * @param modelos the modelos to set
	 */
	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
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
	 * @return the controllerModelo
	 */
	public ControllerModelo getControllerModelo() {
		return controllerModelo;
	}

	/**
	 * @param controllerModelo the controllerModelo to set
	 */
	public void setControllerModelo(ControllerModelo controllerModelo) {
		this.controllerModelo = controllerModelo;
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
