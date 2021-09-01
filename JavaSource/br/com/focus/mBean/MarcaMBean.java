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

import br.com.focus.bean.Marca;
import br.com.focus.controller.ControllerMarca;

/**
 * @author Thiago M. Farias
 * 
 */
public class MarcaMBean {

	private Marca marca = new Marca();
	private Marca marcaSearch = new Marca();
	private Marca marcaModal = new Marca();
	private List<Marca> marcas = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerMarca controllerMarca = new ControllerMarca();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public MarcaMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Marca
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerMarca.saveOrUpdate(this.marca);
		return "success";
	}

	/**
	 * @method Delete MBean Marca
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerMarca.delete(this.marca);
	}

	/**
	 * @method Update MBean Marca
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerMarca.update(this.marca);
	}

	/**
	 * @method Search by ID MBean Marca
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.marca = this.controllerMarca.search(this.marca);
	}

	/**
	 * @method List All MBean Marca
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.marcas = this.controllerMarca.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Marca
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.marcaSearch != null)
				&& (!this.marcaSearch.getDescricao().trim().equals(""))) {
			this.marcas = null;
			System.out.println(this.marcaSearch.getDescricao());
			this.marcas = this.controllerMarca
					.searchByParameter(this.marcaSearch);
		} else {
			this.marcas = this.controllerMarca.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Marca
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.marcaSearch != null)
				&& (!this.marcaSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Marca marcaAux = new Marca();
			if (component.getValue() != null) {
				marcaAux.setDescricao("%" + component.getValue() + "%");
			} else {
				marcaAux.setDescricao("%" + marcaSearch.getDescricao() + "%");
			}
			this.marcaSearch = new Marca();
			this.marcaSearch.setDescricao(marcaAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Marca
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idMarca = Long.valueOf(id);
		if (idMarca != null) {
			marca.setIdMarca(idMarca);
			this.marca = this.controllerMarca.search(this.marca);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Marca
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.marca = new Marca();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Marca
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Marca
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Marca param = (Marca) component.getValue();
		if (param != null) {
			this.marcaModal = this.controllerMarca.search(param);
			this.marcas = null;
		}
	}

	/**
	 * @method Listener Save MBean Marca
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.marca = new Marca();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Marca
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.marca = new Marca();
		this.marcaSearch = new Marca();
		this.marcas = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idMarca", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Marca
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Marca param = (Marca) component.getValue();
		if (param != null) {
			this.marca = this.controllerMarca.search(param);
			this.marcas = null;
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
	 * @return the marca
	 */
	public Marca getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	/**
	 * @return the marcaSearch
	 */
	public Marca getMarcaSearch() {
		return marcaSearch;
	}

	/**
	 * @param marcaSearch the marcaSearch to set
	 */
	public void setMarcaSearch(Marca marcaSearch) {
		this.marcaSearch = marcaSearch;
	}

	/**
	 * @return the marcaModal
	 */
	public Marca getMarcaModal() {
		return marcaModal;
	}

	/**
	 * @param marcaModal the marcaModal to set
	 */
	public void setMarcaModal(Marca marcaModal) {
		this.marcaModal = marcaModal;
	}

	/**
	 * @return the marcas
	 */
	public List<Marca> getMarcas() {
		return marcas;
	}

	/**
	 * @param marcas the marcas to set
	 */
	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
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
	 * @return the controllerMarca
	 */
	public ControllerMarca getControllerMarca() {
		return controllerMarca;
	}

	/**
	 * @param controllerMarca the controllerMarca to set
	 */
	public void setControllerMarca(ControllerMarca controllerMarca) {
		this.controllerMarca = controllerMarca;
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
