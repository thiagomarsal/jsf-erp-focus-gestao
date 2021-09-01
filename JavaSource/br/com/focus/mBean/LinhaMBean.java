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

import br.com.focus.bean.Linha;
import br.com.focus.controller.ControllerLinha;

/**
 * @author Thiago M. Farias
 * 
 */
public class LinhaMBean {

	private Linha linha = new Linha();
	private Linha linhaSearch = new Linha();
	private Linha linhaModal = new Linha();
	private List<Linha> linhas = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerLinha controllerLinha = new ControllerLinha();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public LinhaMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Linha
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.controllerLinha.saveOrUpdate(this.linha);
		return "success";
	}

	/**
	 * @method Delete MBean Linha
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerLinha.delete(this.linha);
	}

	/**
	 * @method Update MBean Linha
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.controllerLinha.update(this.linha);
	}

	/**
	 * @method Search by ID MBean Linha
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.linha = this.controllerLinha.search(this.linha);
	}

	/**
	 * @method List All MBean Linha
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.linhas = this.controllerLinha.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Linha
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.linhaSearch != null)
				&& (!this.linhaSearch.getDescricao().trim().equals(""))) {
			this.linhas = null;
			System.out.println(this.linhaSearch.getDescricao());
			this.linhas = this.controllerLinha
					.searchByParameter(this.linhaSearch);
		} else {
			this.linhas = this.controllerLinha.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Linha
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.linhaSearch != null)
				&& (!this.linhaSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Linha linhaAux = new Linha();
			if (component.getValue() != null) {
				linhaAux.setDescricao("%" + component.getValue() + "%");
			} else {
				linhaAux.setDescricao("%" + linhaSearch.getDescricao() + "%");
			}
			this.linhaSearch = new Linha();
			this.linhaSearch.setDescricao(linhaAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Linha
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idLinha = Long.valueOf(id);
		if (idLinha != null) {
			linha.setIdLinha(idLinha);
			this.linha = this.controllerLinha.search(this.linha);
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Linha
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.linha = new Linha();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Linha
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Linha
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent()
				.findComponent("paramModal");
		Linha param = (Linha) component.getValue();
		if (param != null) {
			this.linhaModal = this.controllerLinha.search(param);
			this.linhas = null;
		}
	}

	/**
	 * @method Listener Save MBean Linha
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.save();
		this.linha = new Linha();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Linha
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.linha = new Linha();
		this.linhaSearch = new Linha();
		this.linhas = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idLinha", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Linha
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Linha param = (Linha) component.getValue();
		if (param != null) {
			this.linha = this.controllerLinha.search(param);
			this.linhas = null;
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
	 * @return the linha
	 */
	public Linha getLinha() {
		return linha;
	}

	/**
	 * @param linha the linha to set
	 */
	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	/**
	 * @return the linhaSearch
	 */
	public Linha getLinhaSearch() {
		return linhaSearch;
	}

	/**
	 * @param linhaSearch the linhaSearch to set
	 */
	public void setLinhaSearch(Linha linhaSearch) {
		this.linhaSearch = linhaSearch;
	}

	/**
	 * @return the linhaModal
	 */
	public Linha getLinhaModal() {
		return linhaModal;
	}

	/**
	 * @param linhaModal the linhaModal to set
	 */
	public void setLinhaModal(Linha linhaModal) {
		this.linhaModal = linhaModal;
	}

	/**
	 * @return the linhas
	 */
	public List<Linha> getLinhas() {
		return linhas;
	}

	/**
	 * @param linhas the linhas to set
	 */
	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
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
	 * @return the controllerLinha
	 */
	public ControllerLinha getControllerLinha() {
		return controllerLinha;
	}

	/**
	 * @param controllerLinha the controllerLinha to set
	 */
	public void setControllerLinha(ControllerLinha controllerLinha) {
		this.controllerLinha = controllerLinha;
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
