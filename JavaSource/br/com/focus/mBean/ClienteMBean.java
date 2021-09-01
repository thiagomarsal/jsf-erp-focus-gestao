/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.mBean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.richfaces.ui.model.States;

import br.com.focus.bean.Cidade;
import br.com.focus.bean.Cliente;
import br.com.focus.bean.Estado;
import br.com.focus.bean.Pais;
import br.com.focus.bean.superClasses.Endereco;
import br.com.focus.controller.ControllerCliente;

/**
 * @author Thiago M. Farias
 * 
 */
public class ClienteMBean {

	private Cliente cliente = new Cliente(new Cidade(new Estado(new Pais())));
	private Cliente clienteSearch = new Cliente();
	private Cliente clienteModal = new Cliente();
	private Cidade cidadeCliente = new Cidade();
	private Endereco enderecoCliente = new Endereco();
	private List<Cliente> clientes = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerCliente controllerCliente = new ControllerCliente();
	private int scrollerPage;
	private States states = new States();
	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public ClienteMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Cliente
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.cliente.setCidade(this.cidadeCliente);
		this.cliente.setEndereco(this.enderecoCliente);
		this.cliente.setDataAtualizacao(new Date());
		this.controllerCliente.saveOrUpdate(this.cliente);
		return "success";
	}

	/**
	 * @method Delete MBean Cliente
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerCliente.delete(this.cliente);
	}

	/**
	 * @method Update MBean Cliente
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.cliente.setCidade(this.cidadeCliente);
		this.cliente.setEndereco(this.enderecoCliente);
		this.controllerCliente.update(this.cliente);
	}

	/**
	 * @method Search by ID MBean Cliente
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.cliente = this.controllerCliente.search(this.cliente);
	}

	/**
	 * @method List All MBean Cliente
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.clientes = this.controllerCliente.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Cliente
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.clienteSearch != null)
				&& (!this.clienteSearch.getNomeRazaoSocial().trim().equals(""))) {
			this.clientes = null;
			System.out.println(this.clienteSearch.getNomeRazaoSocial());
			this.clientes = this.controllerCliente
					.searchByParameter(this.clienteSearch);
		} else {
			this.clientes = this.controllerCliente.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Cliente
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.clienteSearch != null)
				&& (!this.clienteSearch.getNomeRazaoSocial().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Cliente clienteAux = new Cliente();
			if (component.getValue() != null) {
				clienteAux.setNomeRazaoSocial("%" + component.getValue() + "%");
			} else {
				clienteAux.setNomeRazaoSocial("%" + clienteSearch.getNomeRazaoSocial() + "%");
			}
			this.clienteSearch = new Cliente();
			this.clienteSearch.setNomeRazaoSocial(clienteAux.getNomeRazaoSocial());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Cliente
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		this.cliente = new Cliente();
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idCliente = Long.valueOf(id);
		if (idCliente != null) {
			cliente.setIdCliente(idCliente);
			this.cliente = this.controllerCliente.search(this.cliente);
			if ((this.cliente != null) && (this.cliente.getCidade() != null)) {
				this.cidadeCliente.setIdCidade(this.cliente.getCidade().getIdCidade());
				this.cidadeCliente.setNome(this.cliente.getCidade().getNome());
				this.enderecoCliente.setLogradouro(this.cliente.getEndereco().getLogradouro());
                this.enderecoCliente.setNumeroPredial(this.cliente.getEndereco().getNumeroPredial());
                this.enderecoCliente.setBairro(this.cliente.getEndereco().getBairro());
                this.enderecoCliente.setCep(this.cliente.getEndereco().getCep());
                this.enderecoCliente.setComplemento(this.cliente.getEndereco().getComplemento());
			}
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Cliente
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.clienteModal = new Cliente();
		this.clienteSearch = new Cliente();
		this.cliente = new Cliente();
		this.cidadeCliente = new Cidade(new Estado(new Pais()));
		this.enderecoCliente = new Endereco();
		this.cliente.setDataCadastro(new Date());
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Cliente
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Cliente
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Long id = (Long) component.getValue();
		Long idCliente = Long.valueOf(id);
		if (idCliente != null) {
			clienteModal.setIdCliente(idCliente);
			this.clienteModal = this.controllerCliente.search(this.clienteModal);
			this.clientes = null;
		}
	}

	/**
	 * @method Listener Save MBean Cliente
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.cliente.setCidade(null);
		this.cliente.setEndereco(null);
		this.save();
		this.clienteModal = new Cliente();
		this.clienteSearch = new Cliente();
		this.cliente = new Cliente();
		this.cidadeCliente = new Cidade();
		this.enderecoCliente = new Endereco();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Cliente
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.cliente = new Cliente();
		this.cidadeCliente = new Cidade();
		this.enderecoCliente = new Endereco();
		this.clienteSearch = new Cliente();
		this.clienteModal = new Cliente();
		this.clientes = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idCliente", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Cliente
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		this.cliente = new Cliente();
		this.states = new States();
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Long id = (Long) component.getValue();
		Long idCliente = Long.valueOf(id);
		if (idCliente != null) {
			cliente.setIdCliente(idCliente);
			this.cliente = this.controllerCliente.search(this.cliente);
			if (this.cliente.getDataNascimento() == null){
				getStates().setCurrentState("juridico");
				if ((this.cliente != null) && (this.cliente.getCidade() != null)) {
					this.cidadeCliente.setIdCidade(this.cliente.getCidade().getIdCidade());
					this.cidadeCliente.setNome(this.cliente.getCidade().getNome());
					this.enderecoCliente.setLogradouro(this.cliente.getEndereco().getLogradouro());
	                this.enderecoCliente.setNumeroPredial(this.cliente.getEndereco().getNumeroPredial());
	                this.enderecoCliente.setBairro(this.cliente.getEndereco().getBairro());
	                this.enderecoCliente.setCep(this.cliente.getEndereco().getCep());
	                this.enderecoCliente.setComplemento(this.cliente.getEndereco().getComplemento());
				}
			}else
				getStates().setCurrentState("fisico");
				if ((this.cliente != null) && (this.cliente.getCidade() != null)) {
					this.cidadeCliente.setIdCidade(this.cliente.getCidade().getIdCidade());
					this.cidadeCliente.setNome(this.cliente.getCidade().getNome());
					this.enderecoCliente.setLogradouro(this.cliente.getEndereco().getLogradouro());
	                this.enderecoCliente.setNumeroPredial(this.cliente.getEndereco().getNumeroPredial());
	                this.enderecoCliente.setBairro(this.cliente.getEndereco().getBairro());
	                this.enderecoCliente.setCep(this.cliente.getEndereco().getCep());
	                this.enderecoCliente.setComplemento(this.cliente.getEndereco().getComplemento());
	                
				}
			this.clientes = null;
			
		}
		
		this.setEditing();
	}

	public States getStates() {
		
		// Registering Cliente Juridico State definition
		states.setCurrentState("juridico");
		states.put("link", "( Cliente Fisico )");
		states.put("stateTitle", "Cliente Juridico ");
		states.put("nomeRazaoSocial", "Razão Social");
		states.put("msgNomeRazaoSocial", "Razão Social é Obrigatório!");
		states.put("showNomeFantasia", Boolean.TRUE);
		states.put("cpfCnpj", "CNPJ");
		states.put("showCNPJ", Boolean.TRUE);
		states.put("showCPF", Boolean.FALSE);
		states.put("msgCpfCnpj", "CNPJ é Obrigatório");
		states.put("rgInscricao", "I.E.");
		states.put("msgRgInscricao", "I.E. é Obrigatório");
		states.put("showFax", Boolean.TRUE);
		states.put("showContato", Boolean.TRUE);
		states.put("showSite", Boolean.TRUE);
		states.put("showDtNascimento", Boolean.FALSE);
		states.put("showSexo", Boolean.FALSE);
		states.put("showEstadoCivil", Boolean.FALSE);

		states.setNavigation("switch", "fisico");
		
		// Registering new Client State definition
		states.setCurrentState("fisico"); // Name of the new state
		// Text labels, properties and Labels for controls in "register" state
		states.put("link", "( Cliente Juridico )"); // Switch State link label
		states.put("stateTitle", "Cliente Fisico "); // Panel title
		states.put("nomeRazaoSocial", "Nome");
		states.put("msgNomeRazaoSocial", "Nome é Obrigatório!");
		states.put("showNomeFantasia", Boolean.FALSE);
		states.put("cpfCnpj", "CPF");
		states.put("showCNPJ", Boolean.FALSE);
		states.put("showCPF", Boolean.TRUE);
		states.put("msgCpfCnpj", "CPF é Obrigatório");
		states.put("rgInscricao", "RG.");
		states.put("msgRgInscricao", "RG. é Obrigatório");
		states.put("showFax", Boolean.FALSE);
		states.put("showContato", Boolean.FALSE);
		states.put("showSite", Boolean.FALSE);
		states.put("showDtNascimento", Boolean.TRUE);
		states.put("showSexo", Boolean.TRUE);
		states.put("showEstadoCivil", Boolean.TRUE);
		
		// Outcome for switching to Client Juridico state definition
		states.setNavigation("switch", "juridico");
		
		return states;
	}
	
	public void setStates(States states) {
		this.states = states;
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
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the clienteSearch
	 */
	public Cliente getClienteSearch() {
		return clienteSearch;
	}

	/**
	 * @param clienteSearch the clienteSearch to set
	 */
	public void setClienteSearch(Cliente clienteSearch) {
		this.clienteSearch = clienteSearch;
	}

	/**
	 * @return the clienteModal
	 */
	public Cliente getClienteModal() {
		return clienteModal;
	}

	/**
	 * @param clienteModal the clienteModal to set
	 */
	public void setClienteModal(Cliente clienteModal) {
		this.clienteModal = clienteModal;
	}

	/**
	 * @return the cidadeCliente
	 */
	public Cidade getCidadeCliente() {
		return cidadeCliente;
	}

	/**
	 * @param cidadeCliente the cidadeCliente to set
	 */
	public void setCidadeCliente(Cidade cidadeCliente) {
		this.cidadeCliente = cidadeCliente;
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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
	 * @return the controllerCliente
	 */
	public ControllerCliente getControllerCliente() {
		return controllerCliente;
	}

	/**
	 * @param controllerCliente the controllerCliente to set
	 */
	public void setControllerCliente(ControllerCliente controllerCliente) {
		this.controllerCliente = controllerCliente;
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
	 * @return the enderecoCliente
	 */
	public Endereco getEnderecoCliente() {
		return enderecoCliente;
	}

	/**
	 * @param enderecoCliente the enderecoCliente to set
	 */
	public void setEnderecoCliente(Endereco enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}


}
