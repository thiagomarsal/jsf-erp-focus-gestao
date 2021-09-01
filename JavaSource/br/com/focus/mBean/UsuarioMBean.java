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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.focus.bean.PerfilAcesso;
import br.com.focus.bean.Usuario;
import br.com.focus.controller.ControllerUsuario;
import br.com.focus.util.HashMD5;

/**
 * @author Thiago M. Farias
 * 
 */
public class UsuarioMBean {

	private Usuario usuario = new Usuario();
	private Usuario usuarioSearch = new Usuario();
	private Usuario usuarioModal = new Usuario();
	private Usuario usuarioLogin = new Usuario();
	private PerfilAcesso perfilAcessoUsuario = new PerfilAcesso();
	private List<Usuario> usuarios = null;
	private boolean inEditing = false;
	private boolean showButton = false;
	private ControllerUsuario controllerUsuario = new ControllerUsuario();
	private int scrollerPage;

	/**
	 * Constructor of the class
	 * 
	 * @throws Exception
	 */
	public UsuarioMBean() throws Exception {
		this.listAll();
	}

	/**
	 * @method Save MBean Usuario
	 * @return String
	 * @throws Exception
	 */
	public String save() throws Exception {
		this.usuario.setPerfilAcesso(this.perfilAcessoUsuario);
		this.controllerUsuario.saveOrUpdate(this.usuario);
		return "success";
	}

	/**
	 * @method Delete MBean Usuario
	 * @param Object
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.controllerUsuario.delete(this.usuario);
	}

	/**
	 * @method Update MBean Usuario
	 * @param Object
	 * @throws Exception
	 */
	public void update() throws Exception {
		this.usuario.setPerfilAcesso(this.perfilAcessoUsuario);
		this.controllerUsuario.update(this.usuario);
	}

	/**
	 * @method Search by ID MBean Usuario
	 * @param Object
	 * @throws Exception
	 */
	public void search() throws Exception {
		this.usuario = this.controllerUsuario.search(this.usuario);
	}

	/**
	 * @method List All MBean Usuario
	 * @return String
	 * @throws Exception
	 */
	public String listAll() throws Exception {
		this.usuarios = this.controllerUsuario.listAll();
		return "success";
	}
	
	/**
	 * @method Search by Parameter with Like MBean Usuario
	 * @return String
	 * @throws Exception
	 */
	public String searchByParameter() throws Exception {
		if ((this.usuarioSearch != null)
				&& (!this.usuarioSearch.getLogin().trim().equals(""))) {
			this.usuarios = null;
			System.out.println(this.usuarioSearch.getLogin());
			this.usuarios = this.controllerUsuario
					.searchByParameter(this.usuarioSearch);
		} else {
			this.usuarios = this.controllerUsuario.listAll();
		}
		return null;
	}

	/**
	 * @method Listener Search by Parameter MBean Usuario
	 */
	public void listenerSearchByParameter(ActionEvent actionEvent) {
		if ((this.usuarioSearch != null)
				&& (!this.usuarioSearch.getLogin().trim().equals(""))) {
			UIParameter component = (UIParameter) actionEvent.getComponent()
					.findComponent("paramSearch");
			Usuario usuarioAux = new Usuario();
			if (component.getValue() != null) {
				usuarioAux.setLogin("%" + component.getValue() + "%");
			} else {
				usuarioAux.setLogin("%" + usuarioSearch.getLogin() + "%");
			}
			this.usuarioSearch = new Usuario();
			this.usuarioSearch.setLogin(usuarioAux.getLogin());
		}
	}

	/**
	 * @method Listener Delete Screen MBean Usuario
	 */
	public void listenerScreenDelete(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramDelete");
		Long id = (Long) component.getValue();
		Long idUsuario = Long.valueOf(id);
		if (idUsuario != null) {
			usuario.setIdUsuario(idUsuario);
			this.usuario = this.controllerUsuario.search(this.usuario);
			if ((this.usuario != null) && (this.usuario.getPerfilAcesso() != null)) {
				this.perfilAcessoUsuario.setIdPerfilAcesso(this.usuario.getPerfilAcesso().getIdPerfilAcesso());
				this.perfilAcessoUsuario.setDescricao(this.usuario.getPerfilAcesso().getDescricao());
			}
		}
		this.setDeleting();
	}

	/**
	 * @method Listener Save Screen MBean Usuario
	 */
	public void listenerScreenSave(ActionEvent actionEvent) {
		this.usuario = new Usuario();
		this.perfilAcessoUsuario = new PerfilAcesso();
		this.setEditing();

	}

	/**
	 * @method Listener Select Screen MBean Usuario
	 */
	public void listenerScreenSelect(ActionEvent actionEvent) throws Exception {
		this.listAll();
	}

	/**
	 * @method Listener Modal Screen MBean Usuario
	 */
	public void listenerScreenModal(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramModal");
		Usuario param = (Usuario) component.getValue();
		if (param != null) {
			this.usuarioModal = this.controllerUsuario.search(param);
			this.usuarios = null;
		}
	}

	/**
	 * @method Listener Save MBean Usuario
	 */
	public void listenerSave(ActionEvent actionEvent) throws Exception {
		this.usuario.setPerfilAcesso(null);
		this.save();
		this.usuario = new Usuario();
		this.perfilAcessoUsuario = new PerfilAcesso();
		this.setEditing();
	}

	/**
	 * @method Listener Delete MBean Usuario
	 */
	public void listenerDelete(ActionEvent actionEvent) throws Exception {
		try{
		this.delete();
		this.usuario = new Usuario();
		this.perfilAcessoUsuario = new PerfilAcesso();
		this.usuarioSearch = new Usuario();
		this.usuarios = null;
		}catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage(e.getMessage());
			FacesContext.getCurrentInstance().addMessage("idUsuario", facesMessage);
		}
	}

	/**
	 * @method Listener Update MBean Usuario
	 */
	public void listenerUpdate(ActionEvent actionEvent) throws Exception {
		UIParameter component = (UIParameter) actionEvent.getComponent().findComponent("paramUpdate");
		Usuario param = (Usuario) component.getValue();
		if (param != null) {
			this.usuario = this.controllerUsuario.search(param);
			if ((this.usuario != null) && (this.usuario.getPerfilAcesso() != null)) {
				this.perfilAcessoUsuario.setIdPerfilAcesso(this.usuario.getPerfilAcesso().getIdPerfilAcesso());
				this.perfilAcessoUsuario.setDescricao(this.usuario.getPerfilAcesso().getDescricao());
			}
			this.usuarios = null;
		}
		this.setEditing();
	}

	/**
	 * login
	 * @throws Exception 
	 * @throws Exception 
	 */
	public String doLogin() throws Exception{
		boolean validated = false;
		try{
			if((!usuarioLogin.getLogin().trim().equals("")) && 
					(!usuarioLogin.getSenha().trim().equals(""))){
				for (Usuario u : usuarios){
					if ((u.getLogin().equals(usuarioLogin.getLogin())) && (u.getSenha().equals(HashMD5.md5(usuarioLogin.getSenha())))){
					validated = controllerUsuario.validateUser(u);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLoged", validated);
					}
				}
			}
			if(validated){
				return "welcome";
			}else{
				return "home";
			}
		}catch(Exception e){
			return "home";
		}
		
	}
	
	/**
	 * Logout
	 * @return String
	 * @throws Exception
	 */
	public String logout() throws Exception{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		
		boolean logado = session.getAttribute("userLoged") != null;
		
		if(logado){
			session.removeAttribute("userLoged");
			rp.sendRedirect("http://localhost:8080/FocusGestao/");
			return "success";
		}
		return "failure";
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
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the usuarioSearch
	 */
	public Usuario getUsuarioSearch() {
		return usuarioSearch;
	}

	/**
	 * @param usuarioSearch the usuarioSearch to set
	 */
	public void setUsuarioSearch(Usuario usuarioSearch) {
		this.usuarioSearch = usuarioSearch;
	}

	/**
	 * @return the usuarioModal
	 */
	public Usuario getUsuarioModal() {
		return usuarioModal;
	}

	/**
	 * @param usuarioModal the usuarioModal to set
	 */
	public void setUsuarioModal(Usuario usuarioModal) {
		this.usuarioModal = usuarioModal;
	}

	/**
	 * @return the perfilAcessoUsuario
	 */
	public PerfilAcesso getPerfilAcessoUsuario() {
		return perfilAcessoUsuario;
	}

	/**
	 * @param perfilAcessoUsuario the perfilAcessoUsuario to set
	 */
	public void setPerfilAcessoUsuario(PerfilAcesso perfilAcessoUsuario) {
		this.perfilAcessoUsuario = perfilAcessoUsuario;
	}

	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
	 * @return the controllerUsuario
	 */
	public ControllerUsuario getControllerUsuario() {
		return controllerUsuario;
	}

	/**
	 * @param controllerUsuario the controllerUsuario to set
	 */
	public void setControllerUsuario(ControllerUsuario controllerUsuario) {
		this.controllerUsuario = controllerUsuario;
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
	 * @return the usuarioLogin
	 */
	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}

	/**
	 * @param usuarioLogin the usuarioLogin to set
	 */
	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

}
