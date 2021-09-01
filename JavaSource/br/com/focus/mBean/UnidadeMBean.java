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

import br.com.focus.bean.Unidade;
import br.com.focus.controller.ControllerUnidade;

/**
 * @author Thiago M. Farias
 * 
 */
public class UnidadeMBean {

	private Unidade unidade = new Unidade();
	private Unidade unidadeSearch = new Unidade();
	private Unidade unidadeModal = new Unidade();
	private List<Unidade> unidades = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerUnidade controllerUnidade = new ControllerUnidade();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public UnidadeMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Unidade
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerUnidade.saveOrUpdate(this.unidade);
		return "success";
	}

	/**
	 * @method Delete MBean Unidade
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerUnidade.delete(this.unidade);
	}

	/**
	 * @method Update MBean Unidade
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerUnidade.update(this.unidade);
	}

	/**
	 * @method Search by ID MBean Unidade
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.unidade = this.controllerUnidade.search(this.unidade);
	}

	/**
	 * @method List All MBean Unidade
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.unidades = this.controllerUnidade.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Unidade
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.unidadeSearch != null)
				&& (!this.unidadeSearch.getDescricao().trim().equals(""))) {
			this.unidades = null;
			System.out.println(this.unidadeSearch.getDescricao());
			this.unidades = this.controllerUnidade
					.searchByParameter(this.unidadeSearch);
		} else {
			this.unidades = this.controllerUnidade.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Unidade
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.unidadeSearch != null)
				&& (!this.unidadeSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Unidade unidadeAux = new Unidade();
			if (component.getValue() != null) {
				unidadeAux.setDescricao("%" + component.getValue() + "%");
			} else {
				unidadeAux.setDescricao("%" + unidadeSearch.getDescricao() + "%");
			}
			this.unidadeSearch = new Unidade();
			this.unidadeSearch.setDescricao(unidadeAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Unidade
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idUnidade = Long.valueOf(id);
		if (idUnidade != null) {
			unidade.setIdUnidade(idUnidade);
			this.unidade = this.controllerUnidade.search(this.unidade);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Unidade
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.unidade = new Unidade();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Unidade
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Unidade
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Unidade param = (Unidade) component.getValue();
		if (param != null) {
			this.unidadeModal = this.controllerUnidade.search(param);
			this.unidades = this.controllerUnidade.listAll();
		}
	}

	/**
	 * @method Listener Save MBean Unidade
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.unidade = new Unidade();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Unidade
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.unidade = new Unidade();
		this.unidadeSearch = new Unidade();
		this.unidades = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idUnidade", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Unidade
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Unidade param = (Unidade) component.getValue();
		if (param != null) {
			this.unidade = this.controllerUnidade.search(param);
			this.unidades = null;
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
	 * @return the unidade
	 */
	public Unidade getUnidade() {
		return unidade;
	}

	/**
	 * @param unidade the unidade to set
	 */
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	/**
	 * @return the unidadeSearch
	 */
	public Unidade getUnidadeSearch() {
		return unidadeSearch;
	}

	/**
	 * @param unidadeSearch the unidadeSearch to set
	 */
	public void setUnidadeSearch(Unidade unidadeSearch) {
		this.unidadeSearch = unidadeSearch;
	}

	/**
	 * @return the unidadeModal
	 */
	public Unidade getUnidadeModal() {
		return unidadeModal;
	}

	/**
	 * @param unidadeModal the unidadeModal to set
	 */
	public void setUnidadeModal(Unidade unidadeModal) {
		this.unidadeModal = unidadeModal;
	}

	/**
	 * @return the unidades
	 */
	public List<Unidade> getUnidades() {
		return unidades;
	}

	/**
	 * @param unidades the unidades to set
	 */
	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
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
	 * @return the controllerUnidade
	 */
	public ControllerUnidade getControllerUnidade() {
		return controllerUnidade;
	}

	/**
	 * @param controllerUnidade the controllerUnidade to set
	 */
	public void setControllerUnidade(
			ControllerUnidade controllerUnidade) {
		this.controllerUnidade = controllerUnidade;
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
