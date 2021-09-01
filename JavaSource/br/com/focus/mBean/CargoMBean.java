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

import br.com.focus.bean.Cargo;
import br.com.focus.controller.ControllerCargo;

/**
 * @author Thiago M. Farias
 * 
 */
public class CargoMBean {

	private Cargo cargo = new Cargo();
	private Cargo cargoSearch = new Cargo();
	private Cargo cargoModal = new Cargo();
	private List<Cargo> cargos = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerCargo controllerCargo = new ControllerCargo();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public CargoMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Cargo
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerCargo.saveOrUpdate(this.cargo);
		return "success";
	}

	/**
	 * @method Delete MBean Cargo
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerCargo.delete(this.cargo);
	}

	/**
	 * @method Update MBean Cargo
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerCargo.update(this.cargo);
	}

	/**
	 * @method Search by ID MBean Cargo
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.cargo = this.controllerCargo.search(this.cargo);
	}

	/**
	 * @method List All MBean Cargo
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.cargos = this.controllerCargo.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Cargo
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.cargoSearch != null)
				&& (!this.cargoSearch.getDescricao().trim().equals(""))) {
			this.cargos = null;
			System.out.println(this.cargoSearch.getDescricao());
			this.cargos = this.controllerCargo
					.searchByParameter(this.cargoSearch);
		} else {
			this.cargos = this.controllerCargo.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Cargo
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.cargoSearch != null)
				&& (!this.cargoSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Cargo cargoAux = new Cargo();
			if (component.getValue() != null) {
				cargoAux.setDescricao("%" + component.getValue() + "%");
			} else {
				cargoAux.setDescricao("%" + cargoSearch.getDescricao() + "%");
			}
			this.cargoSearch = new Cargo();
			this.cargoSearch.setDescricao(cargoAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Cargo
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idCargo = Long.valueOf(id);
		if (idCargo != null) {
			cargo.setIdCargo(idCargo);
			this.cargo = this.controllerCargo.search(this.cargo);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Cargo
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.cargo = new Cargo();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Cargo
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Cargo
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Cargo param = (Cargo) component.getValue();
		if (param != null) {
			this.cargoModal = this.controllerCargo.search(param);
			this.cargos = null;
		}
	}

	/**
	 * @method Listener Save MBean Cargo
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.cargo = new Cargo();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Cargo
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.cargo = new Cargo();
		this.cargoSearch = new Cargo();
		this.cargos = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idCargo", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Cargo
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Cargo param = (Cargo) component.getValue();
		if (param != null) {
			this.cargo = this.controllerCargo.search(param);
			this.cargos = null;
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
	 * @return the cargo
	 */
	public Cargo getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the cargoSearch
	 */
	public Cargo getCargoSearch() {
		return cargoSearch;
	}

	/**
	 * @param cargoSearch the cargoSearch to set
	 */
	public void setCargoSearch(Cargo cargoSearch) {
		this.cargoSearch = cargoSearch;
	}

	/**
	 * @return the cargoModal
	 */
	public Cargo getCargoModal() {
		return cargoModal;
	}

	/**
	 * @param cargoModal the cargoModal to set
	 */
	public void setCargoModal(Cargo cargoModal) {
		this.cargoModal = cargoModal;
	}

	/**
	 * @return the cargos
	 */
	public List<Cargo> getCargos() {
		return cargos;
	}

	/**
	 * @param cargos the cargos to set
	 */
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
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
	 * @return the controllerCargo
	 */
	public ControllerCargo getControllerCargo() {
		return controllerCargo;
	}

	/**
	 * @param controllerCargo the controllerCargo to set
	 */
	public void setControllerCargo(ControllerCargo controllerCargo) {
		this.controllerCargo = controllerCargo;
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
