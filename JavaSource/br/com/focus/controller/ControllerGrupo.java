/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Grupo;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerGrupo extends Controller<Grupo> {

    private Grupo grupo;

    /**
     * @constructor of the class.
     */
    public ControllerGrupo() {
    	// contructor of the superclasse
    	super(new Facade<Grupo>(Grupo.class));
        this.grupo = new Grupo();
    }

    /**
	 * @return the Object
	 */
    public Grupo getObject() {
        return this.grupo;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Grupo u) {
        this.grupo = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Grupo u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Grupo u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Grupo u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Grupo> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Grupo> searchByParameter(Grupo u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Grupo search(Grupo u) throws Exception {
        if ((u != null) && (u.getIdGrupo() > 0)) {
            return this.searchController(u.getIdGrupo());
        } else {
        	throw new Exception("Error in the method search at the class ControllerGrupo, wrong parameter !!!");
        }
    }

}
