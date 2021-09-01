/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Usuario;
import br.com.focus.facade.Facade;
import br.com.focus.util.HashMD5;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerUsuario extends Controller<Usuario> {

    private Usuario usuario;

    /**
     * @constructor of the class.
     */
    public ControllerUsuario() {
    	// contructor of the superclasse
    	super(new Facade<Usuario>(Usuario.class));
        this.usuario = new Usuario();
    }

    /**
	 * @return the Object
	 */
    public Usuario getObject() {
        return this.usuario;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Usuario u) {
        this.usuario = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Usuario u) throws Exception {
    	u.setSenha(HashMD5.md5(u.getSenha()));
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Usuario u) throws Exception {
    	u.setSenha(HashMD5.md5(u.getSenha()));
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Usuario u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method validateLogin
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean validateUser(Usuario u) throws Exception{
		u.setSenha(HashMD5.md5(u.getSenha()));
		Usuario userTry = this.search(u);
		if ((userTry != null) && (userTry.getSenha().equals(u.getSenha())) && (userTry.getLogin().equals(u.getLogin()))){
			return true;
		}
		return false;
	}

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Usuario> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Usuario> searchByParameter(Usuario u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Usuario search(Usuario u) throws Exception {
        if ((u != null) && (u.getIdUsuario() > 0)) {
            return this.searchController(u.getIdUsuario());
        } else {
        	throw new Exception("Error in the method search at the class ControllerUsuario, wrong parameter !!!");
        }
    }
    
    /**
	 * M�todo de busca por pk
	 * 
	 * @param Usuario
	 * @return Usuario
	 * @throws Exception
	 */
	public Usuario searchString(Usuario u) throws Exception {
		if ((u != null) && (!u.getLogin().trim().equals(""))){ 
			return this.searchController(u.getLogin());
		}else{
			throw new Exception("Erro no m�todo searchString do caso de uso Usu�rio, par�metro incorreto!");
		}
	}
}
