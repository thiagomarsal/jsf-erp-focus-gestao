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

import br.com.focus.bean.Cor;
import br.com.focus.controller.ControllerCor;


/**
 * @author Thiago M. Farias
 * 
 */
public class CorMBean {

	private Cor cor = new Cor();
	private Cor corSearch = new Cor();
	private Cor corModal = new Cor();
	private List<Cor> cores = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerCor controllerCor = new ControllerCor();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public CorMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Cor
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerCor.saveOrUpdate(this.cor);
		return "success";
	}

	/**
	 * @method Delete MBean Cor
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerCor.delete(this.cor);
	}

	/**
	 * @method Update MBean Cor
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerCor.update(this.cor);
	}

	/**
	 * @method Search by ID MBean Cor
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.cor = this.controllerCor.search(this.cor);
	}

	/**
	 * @method List All MBean Cor
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.cores = this.controllerCor.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Cor
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.corSearch != null)
				&& (!this.corSearch.getDescricao().trim().equals(""))) {
			this.cores = null;
			System.out.println(this.corSearch.getDescricao());
			this.cores = this.controllerCor
					.searchByParameter(this.corSearch);
		} else {
			this.cores = this.controllerCor.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Cor
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.corSearch != null)
				&& (!this.corSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Cor corAux = new Cor();
			if (component.getValue() != null) {
				corAux.setDescricao("%" + component.getValue() + "%");
			} else {
				corAux.setDescricao("%" + corSearch.getDescricao() + "%");
			}
			this.corSearch = new Cor();
			this.corSearch.setDescricao(corAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Cor
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idCor = Long.valueOf(id);
		if (idCor != null) {
			cor.setIdCor(idCor);
			this.cor = this.controllerCor.search(this.cor);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Cor
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.cor = new Cor();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Cor
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Cor
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Cor param = (Cor) component.getValue();
		if (param != null) {
			this.corModal = this.controllerCor.search(param);
			this.cores = null;
		}
	}

	/**
	 * @method Listener Save MBean Cor
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.cor = new Cor();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Cor
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.cor = new Cor();
		this.corSearch = new Cor();
		this.cores = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idCor", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Cor
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramUpdate");
		Cor param = (Cor) component.getValue();
		if (param != null) {
			this.cor = this.controllerCor.search(param);
			this.cores = null;
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
	 * @return the cor
	 */
	public Cor getCor() {
		return cor;
	}

	/**
	 * @param cor the cor to set
	 */
	public void setCor(Cor cor) {
		this.cor = cor;
	}

	/**
	 * @return the corSearch
	 */
	public Cor getCorSearch() {
		return corSearch;
	}

	/**
	 * @param corSearch the corSearch to set
	 */
	public void setCorSearch(Cor corSearch) {
		this.corSearch = corSearch;
	}

	/**
	 * @return the corModal
	 */
	public Cor getCorModal() {
		return corModal;
	}

	/**
	 * @param corModal the corModal to set
	 */
	public void setCorModal(Cor corModal) {
		this.corModal = corModal;
	}

	/**
	 * @return the cores
	 */
	public List<Cor> getCores() {
		return cores;
	}

	/**
	 * @param cores the cores to set
	 */
	public void setCores(List<Cor> cores) {
		this.cores = cores;
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
	 * @return the controllerCor
	 */
	public ControllerCor getControllerCor() {
		return controllerCor;
	}

	/**
	 * @param controllerCor the controllerCor to set
	 */
	public void setControllerCor(ControllerCor controllerCor) {
		this.controllerCor = controllerCor;
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
