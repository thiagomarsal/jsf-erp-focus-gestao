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

import br.com.focus.bean.Cargo;
import br.com.focus.bean.Funcionario;
import br.com.focus.bean.Cidade;
import br.com.focus.bean.Usuario;
import br.com.focus.bean.superClasses.Endereco;
import br.com.focus.controller.ControllerFuncionario;

/**
 * @author Thiago M. Farias
 * 
 */
public class FuncionarioMBean {

	private Funcionario funcionario = new Funcionario(new Cidade(), new Cargo(), new Usuario());
	private Funcionario funcionarioSearch = new Funcionario();
	private Funcionario funcionarioModal = new Funcionario();
	private Cidade cidadeFuncionario = new Cidade();
	private Cargo cargoFuncionario = new Cargo();
	private Usuario usuarioFuncionario = new Usuario();
	private Endereco enderecoFuncionario = new Endereco();
	private List<Funcionario> funcionarios = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerFuncionario controllerFuncionario = new ControllerFuncionario();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public FuncionarioMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Funcionario
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.funcionario.setCargo(this.cargoFuncionario);
		this.funcionario.setUsuario(this.usuarioFuncionario);
		this.funcionario.setCidade(this.cidadeFuncionario);
		this.funcionario.setEndereco(this.enderecoFuncionario);
		this.funcionario.setDataAtualizacao(new Date());
		this.controllerFuncionario.saveOrUpdate(this.funcionario);
		return "success";
	}

	/**
	 * @method Delete MBean Funcionario
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerFuncionario.delete(this.funcionario);
	}

	/**
	 * @method Update MBean Funcionario
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.funcionario.setCargo(this.cargoFuncionario);
		this.funcionario.setUsuario(this.usuarioFuncionario);
		this.funcionario.setCidade(this.cidadeFuncionario);
		this.funcionario.setEndereco(this.enderecoFuncionario);
		this.controllerFuncionario.update(this.funcionario);
	}

	/**
	 * @method Search by ID MBean Funcionario
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.funcionario = this.controllerFuncionario.search(this.funcionario);
	}

	/**
	 * @method List All MBean Funcionario
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.funcionarios = this.controllerFuncionario.listAll();
		return "success";
	}

	/**
	 * @method Search by Parameter with Like MBean Funcionario
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.funcionarioSearch != null)
				&& (!this.funcionarioSearch.getNomeRazaoSocial().trim().equals(""))) {
			this.funcionarios = null;
			System.out.println(this.funcionarioSearch.getNomeRazaoSocial());
			this.funcionarios = this.controllerFuncionario
					.searchByParameter(this.funcionarioSearch);
		} else {
			this.funcionarios = this.controllerFuncionario.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Funcionario
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.funcionarioSearch != null)
				&& (!this.funcionarioSearch.getNomeRazaoSocial().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Funcionario funcionarioAux = new Funcionario();
			if (component.getValue() != null) {
				funcionarioAux.setNomeRazaoSocial("%" + component.getValue() + "%");
			} else {
				funcionarioAux.setNomeRazaoSocial("%" + funcionarioSearch.getNomeRazaoSocial() + "%");
			}
			this.funcionarioSearch = new Funcionario();
			this.funcionarioSearch.setNomeRazaoSocial(funcionarioAux.getNomeRazaoSocial());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Funcionario
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		this.funcionario = new Funcionario();
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idFuncionario = Long.valueOf(id);
		if (idFuncionario != null) {
			funcionario.setIdFuncionario(idFuncionario);
			this.funcionario = this.controllerFuncionario.search(this.funcionario);
			if ((this.funcionario != null) && (this.funcionario.getCidade() != null)) {
				this.cargoFuncionario.setIdCargo(this.funcionario.getCargo().getIdCargo());
				this.cargoFuncionario.setDescricao(this.funcionario.getCargo().getDescricao());
				this.usuarioFuncionario.setIdUsuario(this.funcionario.getUsuario().getIdUsuario());
				this.usuarioFuncionario.setLogin(this.funcionario.getUsuario().getLogin());
				this.usuarioFuncionario.setPerfilAcesso(this.funcionario.getUsuario().getPerfilAcesso());
				this.cidadeFuncionario.setIdCidade(this.funcionario.getCidade().getIdCidade());
				this.cidadeFuncionario.setNome(this.funcionario.getCidade().getNome());
				this.enderecoFuncionario.setLogradouro(this.funcionario.getEndereco().getLogradouro());
                this.enderecoFuncionario.setNumeroPredial(this.funcionario.getEndereco().getNumeroPredial());
                this.enderecoFuncionario.setBairro(this.funcionario.getEndereco().getBairro());
                this.enderecoFuncionario.setCep(this.funcionario.getEndereco().getCep());
                this.enderecoFuncionario.setComplemento(this.funcionario.getEndereco().getComplemento());
			}
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Funcionario
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.funcionarioModal = new Funcionario();
		this.funcionarioSearch = new Funcionario();
		this.funcionario = new Funcionario();
		this.cidadeFuncionario = new Cidade();
		this.cargoFuncionario = new Cargo();
		this.usuarioFuncionario = new Usuario();
		this.funcionario.setDataCadastro(new Date());
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Funcionario
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Funcionario
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Long id = (Long) component.getValue();
		Long idFuncionario = Long.valueOf(id);
		if (idFuncionario != null) {
			funcionarioModal.setIdFuncionario(idFuncionario);
			this.funcionarioModal = this.controllerFuncionario.search(this.funcionarioModal);
			this.funcionarios = null;
		}
	}

	/**
	 * @method Listener Save MBean Funcionario
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.funcionario.setCidade(null);
		this.funcionario.setCargo(null);
		this.funcionario.setUsuario(null);
		this.funcionario.setEndereco(null);
		this.save();
		this.funcionario = new Funcionario();
		this.cidadeFuncionario = new Cidade();
		this.cargoFuncionario = new Cargo();
		this.usuarioFuncionario = new Usuario();
		this.enderecoFuncionario = new Endereco();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Funcionario
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.funcionario = new Funcionario();
		this.cidadeFuncionario = new Cidade();
		this.cargoFuncionario = new Cargo();
		this.usuarioFuncionario = new Usuario();
		this.enderecoFuncionario = new Endereco();
		this.funcionarioModal = new Funcionario();
		this.funcionarioSearch = new Funcionario();
		this.funcionarios = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idFuncionario", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Funcionario
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		this.funcionario = new Funcionario();
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Long id = (Long) component.getValue();
		Long idFuncionario = Long.valueOf(id);
		if (idFuncionario != null) {
			funcionario.setIdFuncionario(idFuncionario);
			this.funcionario = this.controllerFuncionario.search(this.funcionario);
			if ((this.funcionario != null) && (this.funcionario.getCidade() != null)) {
				this.cargoFuncionario.setIdCargo(this.funcionario.getCargo().getIdCargo());
				this.cargoFuncionario.setDescricao(this.funcionario.getCargo().getDescricao());
				this.usuarioFuncionario.setIdUsuario(this.funcionario.getUsuario().getIdUsuario());
				this.usuarioFuncionario.setLogin(this.funcionario.getUsuario().getLogin());
				this.usuarioFuncionario.setPerfilAcesso(this.funcionario.getUsuario().getPerfilAcesso());
				this.cidadeFuncionario.setIdCidade(this.funcionario.getCidade().getIdCidade());
				this.cidadeFuncionario.setNome(this.funcionario.getCidade().getNome());
				this.enderecoFuncionario.setLogradouro(this.funcionario.getEndereco().getLogradouro());
                this.enderecoFuncionario.setNumeroPredial(this.funcionario.getEndereco().getNumeroPredial());
                this.enderecoFuncionario.setBairro(this.funcionario.getEndereco().getBairro());
                this.enderecoFuncionario.setCep(this.funcionario.getEndereco().getCep());
                this.enderecoFuncionario.setComplemento(this.funcionario.getEndereco().getComplemento());
			}
			this.funcionarios = null;
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
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the funcionarioSearch
	 */
	public Funcionario getFuncionarioSearch() {
		return funcionarioSearch;
	}

	/**
	 * @param funcionarioSearch the funcionarioSearch to set
	 */
	public void setFuncionarioSearch(Funcionario funcionarioSearch) {
		this.funcionarioSearch = funcionarioSearch;
	}

	/**
	 * @return the funcionarioModal
	 */
	public Funcionario getFuncionarioModal() {
		return funcionarioModal;
	}

	/**
	 * @param funcionarioModal the funcionarioModal to set
	 */
	public void setFuncionarioModal(Funcionario funcionarioModal) {
		this.funcionarioModal = funcionarioModal;
	}

	/**
	 * @return the cidadeFuncionario
	 */
	public Cidade getCidadeFuncionario() {
		return cidadeFuncionario;
	}

	/**
	 * @param cidadeFuncionario the cidadeFuncionario to set
	 */
	public void setCidadeFuncionario(Cidade cidadeFuncionario) {
		this.cidadeFuncionario = cidadeFuncionario;
	}

	/**
	 * @return the funcionarios
	 */
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	/**
	 * @param funcionarios the funcionarios to set
	 */
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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
	 * @return the controllerFuncionario
	 */
	public ControllerFuncionario getControllerFuncionario() {
		return controllerFuncionario;
	}

	/**
	 * @param controllerFuncionario the controllerFuncionario to set
	 */
	public void setControllerFuncionario(ControllerFuncionario controllerFuncionario) {
		this.controllerFuncionario = controllerFuncionario;
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
	 * @return the funcionario
	 */
	public Funcionario getCliente() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setCliente(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the funcionarioSearch
	 */
	public Funcionario getClienteSearch() {
		return funcionarioSearch;
	}

	/**
	 * @param funcionarioSearch the funcionarioSearch to set
	 */
	public void setClienteSearch(Funcionario funcionarioSearch) {
		this.funcionarioSearch = funcionarioSearch;
	}

	/**
	 * @return the funcionarioModal
	 */
	public Funcionario getClienteModal() {
		return funcionarioModal;
	}

	/**
	 * @param funcionarioModal the funcionarioModal to set
	 */
	public void setClienteModal(Funcionario funcionarioModal) {
		this.funcionarioModal = funcionarioModal;
	}

	/**
	 * @return the cargoFuncionario
	 */
	public Cargo getCargoFuncionario() {
		return cargoFuncionario;
	}

	/**
	 * @param cargoFuncionario the cargoFuncionario to set
	 */
	public void setCargoFuncionario(Cargo cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}

	/**
	 * @return the usuarioFuncionario
	 */
	public Usuario getUsuarioFuncionario() {
		return usuarioFuncionario;
	}

	/**
	 * @param usuarioFuncionario the usuarioFuncionario to set
	 */
	public void setUsuarioFuncionario(Usuario usuarioFuncionario) {
		this.usuarioFuncionario = usuarioFuncionario;
	}

	/**
	 * @return the enderecoFuncionario
	 */
	public Endereco getEnderecoFuncionario() {
		return enderecoFuncionario;
	}

	/**
	 * @param enderecoFuncionario the enderecoFuncionario to set
	 */
	public void setEnderecoFuncionario(Endereco enderecoFuncionario) {
		this.enderecoFuncionario = enderecoFuncionario;
	}

}
