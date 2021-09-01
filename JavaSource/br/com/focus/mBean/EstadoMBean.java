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

import br.com.focus.bean.Estado;
import br.com.focus.bean.Pais;
import br.com.focus.controller.ControllerEstado;

/**
 * @author Thiago M. Farias
 * 
 */
public class EstadoMBean {

	private Estado estado = new Estado(new Pais());
	private Estado estadoSearch = new Estado();
	private Estado estadoModal = new Estado();
	private Pais paisEstado = new Pais();
	private List<Estado> estados = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerEstado controllerEstado = new ControllerEstado();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public EstadoMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Estado
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.estado.setPais(this.paisEstado);
		this.controllerEstado.saveOrUpdate(this.estado);
		return "success";
	}

	/**
	 * @method Delete MBean Estado
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerEstado.delete(this.estado);
	}

	/**
	 * @method Update MBean Estado
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.estado.setPais(this.paisEstado);
		this.controllerEstado.update(this.estado);
	}

	/**
	 * @method Search by ID MBean Estado
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.estado = this.controllerEstado.search(this.estado);
	}

	/**
	 * @method List All MBean Estado
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.estados = this.controllerEstado.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Estado
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.estadoSearch != null)
				&& (!this.estadoSearch.getNome().trim().equals(""))) {
			this.estados = null;
			System.out.println(this.estadoSearch.getNome());
			this.estados = this.controllerEstado
					.searchByParameter(this.estadoSearch);
		} else {
			this.estados = this.controllerEstado.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Estado
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.estadoSearch != null)
				&& (!this.estadoSearch.getNome().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Estado estadoAux = new Estado();
			if (component.getValue() != null) {
				estadoAux.setNome("%" + component.getValue() + "%");
			} else {
				estadoAux.setNome("%" + estadoSearch.getNome() + "%");
			}
			this.estadoSearch = new Estado();
			this.estadoSearch.setNome(estadoAux.getNome());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Estado
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idEstado = Long.valueOf(id);
		if (idEstado != null) {
			estado.setIdEstado(idEstado);
			this.estado = this.controllerEstado.search(this.estado);
			if ((this.estado != null) && (this.estado.getPais() != null)) {
				this.paisEstado.setIdPais(this.estado.getPais().getIdPais());
				this.paisEstado.setNome(this.estado.getPais().getNome());
			}
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Estado
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.estado = new Estado();
		this.paisEstado = new Pais();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Estado
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Estado
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Estado param = (Estado) component.getValue();
		if (param != null) {
			this.estadoModal = this.controllerEstado.search(param);
			this.estados = null;
		}
	}

	/**
	 * @method Listener Save MBean Estado
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.estado.setPais(null);
		this.save();
		this.estado = new Estado();
		this.paisEstado = new Pais();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Estado
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.estado = new Estado();
		this.paisEstado = new Pais();
		this.estadoSearch = new Estado();
		this.estados = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idEstado", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Estado
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Estado param = (Estado) component.getValue();
		if (param != null) {
			this.estado = this.controllerEstado.search(param);
			if ((this.estado != null) && (this.estado.getPais() != null)) {
				this.paisEstado.setIdPais(this.estado.getPais().getIdPais());
				this.paisEstado.setNome(this.estado.getPais().getNome());
			}
			this.estados = null;
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
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * @return the estadoSearch
	 */
	public Estado getEstadoSearch() {
		return estadoSearch;
	}

	/**
	 * @param estadoSearch
	 *            the estadoSearch to set
	 */
	public void setEstadoSearch(Estado estadoSearch) {
		this.estadoSearch = estadoSearch;
	}

	/**
	 * @return the estadoModal
	 */
	public Estado getEstadoModal() {
		return estadoModal;
	}

	/**
	 * @param estadoModal
	 *            the estadoModal to set
	 */
	public void setEstadoModal(Estado estadoModal) {
		this.estadoModal = estadoModal;
	}

	/**
	 * @return the estados
	 */
	public List<Estado> getEstados() {
		return estados;
	}

	/**
	 * @param estados
	 *            the estados to set
	 */
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
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
	 * @return the controllerEstado
	 */
	public ControllerEstado getControllerEstado() {
		return controllerEstado;
	}

	/**
	 * @param controllerEstado
	 *            the controllerEstado to set
	 */
	public void setControllerEstado(ControllerEstado controllerEstado) {
		this.controllerEstado = controllerEstado;
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

	/**
	 * @return the paisEstado
	 */
	public Pais getPaisEstado() {
		return paisEstado;
	}

	/**
	 * @param paisEstado
	 *            the paisEstado to set
	 */
	public void setPaisEstado(Pais paisEstado) {
		this.paisEstado = paisEstado;
	}

}
