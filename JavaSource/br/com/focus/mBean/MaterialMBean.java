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

import br.com.focus.bean.Material;
import br.com.focus.controller.ControllerMaterial;

/**
 * @author Thiago M. Farias
 * 
 */
public class MaterialMBean {

	private Material material = new Material();
	private Material materialSearch = new Material();
	private Material materialModal = new Material();
	private List<Material> materiais = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerMaterial controllerMaterial = new ControllerMaterial();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public MaterialMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Material
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerMaterial.saveOrUpdate(this.material);
		return "success";
	}

	/**
	 * @method Delete MBean Material
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerMaterial.delete(this.material);
	}

	/**
	 * @method Update MBean Material
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerMaterial.update(this.material);
	}

	/**
	 * @method Search by ID MBean Material
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.material = this.controllerMaterial.search(this.material);
	}

	/**
	 * @method List All MBean Material
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.materiais = this.controllerMaterial.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Material
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.materialSearch != null)
				&& (!this.materialSearch.getDescricao().trim().equals(""))) {
			this.materiais = null;
			System.out.println(this.materialSearch.getDescricao());
			this.materiais = this.controllerMaterial
					.searchByParameter(this.materialSearch);
		} else {
			this.materiais = this.controllerMaterial.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Material
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.materialSearch != null)
				&& (!this.materialSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Material materialAux = new Material();
			if (component.getValue() != null) {
				materialAux.setDescricao("%" + component.getValue() + "%");
			} else {
				materialAux.setDescricao("%" + materialSearch.getDescricao() + "%");
			}
			this.materialSearch = new Material();
			this.materialSearch.setDescricao(materialAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Material
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idMaterial = Long.valueOf(id);
		if (idMaterial != null) {
			material.setIdMaterial(idMaterial);
			this.material = this.controllerMaterial.search(this.material);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Material
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.material = new Material();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Material
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Material
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Material param = (Material) component.getValue();
		if (param != null) {
			this.materialModal = this.controllerMaterial.search(param);
			this.materiais = null;
		}
	}

	/**
	 * @method Listener Save MBean Material
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.material = new Material();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Material
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.material = new Material();
		this.materialSearch = new Material();
		this.materiais = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idMaterial", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Material
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Material param = (Material) component.getValue();
		if (param != null) {
			this.material = this.controllerMaterial.search(param);
			this.materiais = null;
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
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/**
	 * @return the materialSearch
	 */
	public Material getMaterialSearch() {
		return materialSearch;
	}

	/**
	 * @param materialSearch the materialSearch to set
	 */
	public void setMaterialSearch(Material materialSearch) {
		this.materialSearch = materialSearch;
	}

	/**
	 * @return the materialModal
	 */
	public Material getMaterialModal() {
		return materialModal;
	}

	/**
	 * @param materialModal the materialModal to set
	 */
	public void setMaterialModal(Material materialModal) {
		this.materialModal = materialModal;
	}

	/**
	 * @return the materiais
	 */
	public List<Material> getMateriais() {
		return materiais;
	}

	/**
	 * @param materiais the materiais to set
	 */
	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
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
	 * @return the controllerMaterial
	 */
	public ControllerMaterial getControllerMaterial() {
		return controllerMaterial;
	}

	/**
	 * @param controllerMaterial the controllerMaterial to set
	 */
	public void setControllerMaterial(ControllerMaterial controllerMaterial) {
		this.controllerMaterial = controllerMaterial;
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
