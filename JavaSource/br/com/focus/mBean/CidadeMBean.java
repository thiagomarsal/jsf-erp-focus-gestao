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

import br.com.focus.bean.Cidade;
import br.com.focus.bean.Estado;
import br.com.focus.controller.ControllerCidade;

/**
 * @author Thiago M. Farias
 * 
 */
public class CidadeMBean {

	private Cidade cidade = new Cidade(new Estado());
	private Cidade cidadeSearch = new Cidade();
	private Cidade cidadeModal = new Cidade();
	private Estado estadoCidade = new Estado();
	private List<Cidade> cidades = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerCidade controllerCidade = new ControllerCidade();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public CidadeMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Cidade
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.cidade.setEstado(this.estadoCidade);
		this.controllerCidade.saveOrUpdate(this.cidade);
		return "success";
	}

	/**
	 * @method Delete MBean Cidade
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerCidade.delete(this.cidade);
	}

	/**
	 * @method Update MBean Cidade
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.cidade.setEstado(this.estadoCidade);
		this.controllerCidade.update(this.cidade);
	}

	/**
	 * @method Search by ID MBean Cidade
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.cidade = this.controllerCidade.search(this.cidade);
	}

	/**
	 * @method List All MBean Cidade
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.cidades = this.controllerCidade.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Cidade
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.cidadeSearch != null)
				&& (!this.cidadeSearch.getNome().trim().equals(""))) {
			this.cidades = null;
			System.out.println(this.cidadeSearch.getNome());
			this.cidades = this.controllerCidade
					.searchByParameter(this.cidadeSearch);
		} else {
			this.cidades = this.controllerCidade.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Cidade
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.cidadeSearch != null)
				&& (!this.cidadeSearch.getNome().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Cidade cidadeAux = new Cidade();
			if (component.getValue() != null) {
				cidadeAux.setNome("%" + component.getValue() + "%");
			} else {
				cidadeAux.setNome("%" + cidadeSearch.getNome() + "%");
			}
			this.cidadeSearch = new Cidade();
			this.cidadeSearch.setNome(cidadeAux.getNome());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Cidade
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idCidade = Long.valueOf(id);
		if (idCidade != null) {
			cidade.setIdCidade(idCidade);
			this.cidade = this.controllerCidade.search(this.cidade);
			if ((this.cidade != null) && (this.cidade.getEstado() != null)) {
				this.estadoCidade.setIdEstado(this.cidade.getEstado().getIdEstado());
				this.estadoCidade.setNome(this.cidade.getEstado().getNome());
			}
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Cidade
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.cidade = new Cidade();
		this.estadoCidade = new Estado();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Cidade
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Cidade
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Cidade param = (Cidade) component.getValue();
		if (param != null) {
			this.cidadeModal = this.controllerCidade.search(param);
			this.cidades = null;
		}
	}

	/**
	 * @method Listener Save MBean Cidade
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.cidade.setEstado(null);
		this.save();
		this.cidade = new Cidade();
		this.estadoCidade = new Estado();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Cidade
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.cidade = new Cidade();
		this.estadoCidade = new Estado();
		this.cidadeSearch = new Cidade();
		this.cidades = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idCidade", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Cidade
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Cidade param = (Cidade) component.getValue();
		if (param != null) {
			this.cidade = this.controllerCidade.search(param);
			if ((this.cidade != null) && (this.cidade.getEstado() != null)) {
				this.estadoCidade.setIdEstado(this.cidade.getEstado().getIdEstado());
				this.estadoCidade.setNome(this.cidade.getEstado().getNome());
			}
			this.cidades = null;
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
	 * @return the cidade
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the cidadeSearch
	 */
	public Cidade getCidadeSearch() {
		return cidadeSearch;
	}

	/**
	 * @param cidadeSearch the cidadeSearch to set
	 */
	public void setCidadeSearch(Cidade cidadeSearch) {
		this.cidadeSearch = cidadeSearch;
	}

	/**
	 * @return the cidadeModal
	 */
	public Cidade getCidadeModal() {
		return cidadeModal;
	}

	/**
	 * @param cidadeModal the cidadeModal to set
	 */
	public void setCidadeModal(Cidade cidadeModal) {
		this.cidadeModal = cidadeModal;
	}

	/**
	 * @return the estadoCidade
	 */
	public Estado getEstadoCidade() {
		return estadoCidade;
	}

	/**
	 * @param estadoCidade the estadoCidade to set
	 */
	public void setEstadoCidade(Estado estadoCidade) {
		this.estadoCidade = estadoCidade;
	}

	/**
	 * @return the cidades
	 */
	public List<Cidade> getCidades() {
		return cidades;
	}

	/**
	 * @param cidades the cidades to set
	 */
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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
	 * @return the controllerCidade
	 */
	public ControllerCidade getControllerCidade() {
		return controllerCidade;
	}

	/**
	 * @param controllerCidade the controllerCidade to set
	 */
	public void setControllerCidade(ControllerCidade controllerCidade) {
		this.controllerCidade = controllerCidade;
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
