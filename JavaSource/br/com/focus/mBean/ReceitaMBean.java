/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.mBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.focus.bean.Receita;
import br.com.focus.bean.Servico;
import br.com.focus.bean.ServicosSelecionados;
import br.com.focus.controller.ControllerReceita;
import br.com.focus.controller.ControllerServico;
import br.com.focus.controller.ControllerServicosSelecionados;



/**
 * @author Thiago M. Farias
 * 
 */
public class ReceitaMBean {

	private Receita receita = new Receita();
    private Receita receitaSearch = new Receita();
    private Receita receitaModal = new Receita();
    private Servico servico = new Servico();
    private ServicosSelecionados servicoSelecionado = new ServicosSelecionados();
    private List<ServicosSelecionados> servicosSelecionados = null;
    private List<Receita> receitas = null;
    private boolean inEditing = false;
    private boolean showButton = false;
    private ControllerReceita controllerReceita = new ControllerReceita();
    private ControllerServico controllerServico = new ControllerServico();
    private ControllerServicosSelecionados controllerServicosSelecionados = new ControllerServicosSelecionados();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public ReceitaMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Receita
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.receita.setServicosSelecionados(this.servicosSelecionados);
		this.calculaPrecoVenda();
		this.controllerReceita.saveOrUpdate(this.receita);
		return "success";
	}

	/**
	 * @method Delete MBean Receita
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerReceita.delete(this.receita);
	}

	/**
	 * @method Update MBean Receita
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.receita.setServicosSelecionados(this.servicosSelecionados);
		this.calculaPrecoVenda();
		this.controllerReceita.update(this.receita);
	}

	/**
	 * @method Search by ID MBean Receita
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.receita = this.controllerReceita.search(this.receita);
	}

	/**
	 * @method List All MBean Receita
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.receitas = this.controllerReceita.listAll();
		return "receita";
	}
	
	/**
	 * @method Search by Parameter with Like MBean Receita
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.receitaSearch != null)
				&& (!this.receitaSearch.getDescricao().trim().equals(""))) {
			this.receitas = null;
			this.receitas = this.controllerReceita
					.searchByParameter(this.receitaSearch);
		} else {
			this.receitas = this.controllerReceita.listAll();
		}
		return null;
	}

	/**
	 * @method Calculate value of services MBean Receita
	 * @return Double
	 * @throws Exception
	 */
	public Double somaTotalServicos(){
	Double total = 0.0;
		for (ServicosSelecionados item : getServicosSelecionados()) {
			if(item.getPreco()!=null)
			total += item.getPreco();
		}
	    receita.setTotalServicos(total);
		return total;
	}
	
	/**
	 * @method Calculate value of services MBean Receita
	 * @return Double
	 * @throws Exception
	 */
	public Double calculaPrecoVenda(){
	Double precoVenda, valor = 0.0;
			if(receita.getTotalServicos() !=null)
			 valor = receita.getTotalServicos();
			 precoVenda = valor;
	    this.receita.setPrecoVenda(precoVenda);
		return precoVenda;
	}
	
	/**
	 * @method Listener Insert Item List Service MBean Receita
	 */
	public void listenerInsertItemList(ActionEvent actionEvent) throws Exception {
		UIParameter component = null; 
		component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Servico param = null;
		param = (Servico) component.getValue();
		if (param != null) {
			Servico servico = new Servico();
			servico = this.controllerServico.search(param);
			List<ServicosSelecionados> slb = servicosSelecionados;
			if (slb == null){
				slb = new ArrayList<ServicosSelecionados>();
			}
			ServicosSelecionados item = new ServicosSelecionados();
			item.setServico(servico.clone());
			item.setDescricao(servico.getDescricao());
			item.setPreco(servico.getPreco());
			boolean isInsert = false;
			for (ServicosSelecionados ss : slb){
				if(ss.getServico().getIdServico().longValue() == item.getServico().getIdServico().longValue()){
					isInsert = true;
				}
			}
			if(!isInsert){
				slb.add(item);
				this.servicosSelecionados = slb;
				this.somaTotalServicos();
				receita.getPrecoVenda();
				this.calculaPrecoVenda();
			}else{
				FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Serviço já Existente", "Erro!");
				FacesContext.getCurrentInstance().addMessage("descricaoServicoSelecionado", facesMessage);
			}
		}
	}
	
	/**
	 * @method Listener Remove Item List Service MBean Receita
	 */
	public void listenerRemoveItemList(ActionEvent actionEvent) throws Exception {
		UIParameter component = null; 
		component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		ServicosSelecionados param = null;
		param = (ServicosSelecionados) component.getValue();
		if (param != null) {
			getServicosSelecionados().remove(param);
			controllerServicosSelecionados.delete(param);
			this.somaTotalServicos();
			receita.getPrecoVenda();
			this.calculaPrecoVenda();
		}
	}
	
	/**
	 * @method Listener Search by Parameter MBean Receita
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.receitaSearch != null)
				&& (!this.receitaSearch.getDescricao().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Receita receitaAux = new Receita();
			if (component.getValue() != null) {
				receitaAux.setDescricao("%" + component.getValue() + "%");
			} else {
				receitaAux.setDescricao("%" + receitaSearch.getDescricao() + "%");
			}
			this.receitaSearch = new Receita();
			this.receitaSearch.setDescricao(receitaAux.getDescricao());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Receita
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idReceita = Long.valueOf(id);
		if (idReceita != null) {
			receita.setIdReceita(idReceita);
			this.receita = this.controllerReceita.search(this.receita);
			if (this.receita != null) {
				this.servicosSelecionados = this.receita.getServicosSelecionados();
            }
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Receita
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.servicosSelecionados = new ArrayList<ServicosSelecionados>();
		this.servicoSelecionado = new ServicosSelecionados();
		this.receita = new Receita();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Receita
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Save MBean Receita
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.receita.setServicosSelecionados(null);
		this.save();
		this.servicosSelecionados = new ArrayList<ServicosSelecionados>();
		this.servicoSelecionado = new ServicosSelecionados();
		this.setEditing();
	}
	
	/**
	 * @method Listener Delete MBean Receita
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.receita = new Receita();
		this.receitaSearch = new Receita();
		this.servicosSelecionados  = new ArrayList<ServicosSelecionados>(); 
		this.receitas = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idReceita", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Receita
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Receita param = (Receita) component.getValue();
		if (param != null) {
			this.receita = this.controllerReceita.search(param);
			if (this.receita != null) {
				this.servicosSelecionados = this.receita.getServicosSelecionados();
            }
			this.receitas = null;
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
	 * @return the receita
	 */
	public Receita getReceita() {
		return receita;
	}

	/**
	 * @param receita the receita to set
	 */
	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	/**
	 * @return the receitaSearch
	 */
	public Receita getReceitaSearch() {
		return receitaSearch;
	}

	/**
	 * @param receitaSearch the receitaSearch to set
	 */
	public void setReceitaSearch(Receita receitaSearch) {
		this.receitaSearch = receitaSearch;
	}

	/**
	 * @return the receitaModal
	 */
	public Receita getReceitaModal() {
		return receitaModal;
	}

	/**
	 * @param receitaModal the receitaModal to set
	 */
	public void setReceitaModal(Receita receitaModal) {
		this.receitaModal = receitaModal;
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
	 * @return the controllerReceita
	 */
	public ControllerReceita getControllerReceita() {
		return controllerReceita;
	}

	/**
	 * @param controllerReceita the controllerReceita to set
	 */
	public void setControllerReceita(ControllerReceita controllerReceita) {
		this.controllerReceita = controllerReceita;
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

	/**
	 * @return the controllerServico
	 */
	public ControllerServico getControllerServico() {
		return controllerServico;
	}

	/**
	 * @param controllerServico the controllerServico to set
	 */
	public void setControllerServico(ControllerServico controllerServico) {
		this.controllerServico = controllerServico;
	}

	/**
	 * @return the servico
	 */
	public Servico getServico() {
		return servico;
	}

	/**
	 * @param servico the servico to set
	 */
	public void setServico(Servico servico) {
		this.servico = servico;
	}

	/**
	 * @return the servicoReceita
	 */
	public ServicosSelecionados getServicoReceita() {
		return servicoSelecionado;
	}

	/**
	 * @param servicoReceita the servicoReceita to set
	 */
	public void setServicoReceita(ServicosSelecionados servicoReceita) {
		this.servicoSelecionado = servicoReceita;
	}

	/**
	 * @return the servicosSelecionados
	 */
	public List<ServicosSelecionados> getServicosSelecionados() {
		return servicosSelecionados;
	}

	/**
	 * @param servicosSelecionados the servicosSelecionados to set
	 */
	public void setServicosSelecionados(List<ServicosSelecionados> servicosSelecionados) {
		this.servicosSelecionados = servicosSelecionados;
	}

	/**
	 * @return the controllerServicosSelecionados
	 */
	public ControllerServicosSelecionados getControllerServicosSelecionados() {
		return controllerServicosSelecionados;
	}

	/**
	 * @param controllerServicosSelecionados the controllerServicosSelecionados to set
	 */
	public void setControllerServicosSelecionados(
			ControllerServicosSelecionados controllerServicosSelecionados) {
		this.controllerServicosSelecionados = controllerServicosSelecionados;
	}

	/**
	 * @return the servicoSelecionado
	 */
	public ServicosSelecionados getServicoSelecionado() {
		return servicoSelecionado;
	}

	/**
	 * @param servicoSelecionado the servicoSelecionado to set
	 */
	public void setServicoSelecionado(ServicosSelecionados servicoSelecionado) {
		this.servicoSelecionado = servicoSelecionado;
	}

	/**
	 * @return the receitas
	 */
	public List<Receita> getReceitas() {
		return receitas;
	}

	/**
	 * @param receitas the receitas to set
	 */
	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

}
