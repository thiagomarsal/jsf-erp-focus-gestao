/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.PerfilAcesso;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerPerfilAcesso extends Controller<PerfilAcesso> {

    private PerfilAcesso perfilAcesso;

    /**
     * @constructor of the class.
     */
    public ControllerPerfilAcesso() {
    	// contructor of the superclasse
    	super(new Facade<PerfilAcesso>(PerfilAcesso.class));
        this.perfilAcesso = new PerfilAcesso();
    }

    /**
	 * @return the Object
	 */
    public PerfilAcesso getObject() {
        return this.perfilAcesso;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(PerfilAcesso u) {
        this.perfilAcesso = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(PerfilAcesso u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(PerfilAcesso u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(PerfilAcesso u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<PerfilAcesso> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<PerfilAcesso> searchByParameter(PerfilAcesso u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public PerfilAcesso search(PerfilAcesso u) throws Exception {
        if ((u != null) && (u.getIdPerfilAcesso() > 0)) {
            return this.searchController(u.getIdPerfilAcesso());
        } else {
        	throw new Exception("Error in the method search at the class ControllerPerfil, wrong parameter !!!");
        }
    }

}
