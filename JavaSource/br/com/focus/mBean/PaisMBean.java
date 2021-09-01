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

import br.com.focus.bean.Pais;
import br.com.focus.controller.ControllerPais;

/**
 * @author Thiago M. Farias
 * 
 */
public class PaisMBean{

	private Pais pais = new Pais();
	private Pais paisSearch = new Pais();
	private Pais paisModal = new Pais();
	private List<Pais> paises = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerPais controllerPais = new ControllerPais();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public PaisMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Pais
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerPais.saveOrUpdate(this.pais);
		return "success";
	}

	/**
	 * @method Delete MBean Pais
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerPais.delete(this.pais);
	}

	/**
	 * @method Update MBean Pais
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerPais.update(this.pais);
	}

	/**
	 * @method Search by ID MBean Pais
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.pais = this.controllerPais.search(this.pais);
	}

	/**
	 * @method List All MBean Pais
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.paises = this.controllerPais.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Pais
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.paisSearch != null)
				&& (!this.paisSearch.getNome().trim().equals(""))) {
			this.paises = null;
			System.out.println(this.paisSearch.getNome());
			this.paises = this.controllerPais
					.searchByParameter(this.paisSearch);
		} else {
			this.paises = this.controllerPais.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Pais
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.paisSearch != null)
				&& (!this.paisSearch.getNome().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Pais paisAux = new Pais();
			if (component.getValue() != null) {
				paisAux.setNome("%" + component.getValue() + "%");
			} else {
				paisAux.setNome("%" + paisSearch.getNome() + "%");
			}
			this.paisSearch = new Pais();
			this.paisSearch.setNome(paisAux.getNome());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Pais
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idPais = Long.valueOf(id);
		if (idPais != null) {
			pais.setIdPais(idPais);
			this.pais = this.controllerPais.search(this.pais);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Pais
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.pais = new Pais();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Pais
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Pais
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Pais param = (Pais) component.getValue();
		if (param != null) {
			this.paisModal = this.controllerPais.search(param);
			this.paises = null;
		}
	}

	/**
	 * @method Listener Save MBean Pais
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		try{
		this.save();
		this.pais = new Pais();
		this.setEditing();
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("nomePais", facesMessage);
		}
	}

	/**
	 * @method Listener Delete MBean Pais
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.pais = new Pais();
		this.paisSearch = new Pais();
		this.paises = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idPais", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Pais
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Pais param = (Pais) component.getValue();
		if (param != null) {
			this.pais = this.controllerPais.search(param);
			this.paises = null;
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
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return the paisSearch
	 */
	public Pais getPaisSearch() {
		return paisSearch;
	}

	/**
	 * @param paisSearch
	 *            the paisSearch to set
	 */
	public void setPaisSearch(Pais paisSearch) {
		this.paisSearch = paisSearch;
	}

	/**
	 * @return the paisModal
	 */
	public Pais getPaisModal() {
		return paisModal;
	}

	/**
	 * @param paisModal
	 *            the paisModal to set
	 */
	public void setPaisModal(Pais paisModal) {
		this.paisModal = paisModal;
	}

	/**
	 * @return the paises
	 */
	public List<Pais> getPaises() {
		return paises;
	}

	/**
	 * @param paises
	 *            the paises to set
	 */
	public void setPaises(List<Pais> paises) {
		this.paises = paises;
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
	 * @return the controllerPais
	 */
	public ControllerPais getControllerPais() {
		return controllerPais;
	}

	/**
	 * @param controllerPais
	 *            the controllerPais to set
	 */
	public void setControllerPais(ControllerPais controllerPais) {
		this.controllerPais = controllerPais;
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
