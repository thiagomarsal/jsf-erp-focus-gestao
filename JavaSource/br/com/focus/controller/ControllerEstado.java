/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Estado;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerEstado extends Controller<Estado> {

    private Estado estado;

    /**
     * @constructor of the class.
     */
    public ControllerEstado() {
    	// contructor of the superclasse
    	super(new Facade<Estado>(Estado.class));
        this.estado = new Estado();
    }

    /**
	 * @return the Object
	 */
    public Estado getObject() {
        return this.estado;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Estado u) {
        this.estado = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Estado u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Estado u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Estado u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Estado> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Estado> searchByParameter(Estado u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Estado search(Estado u) throws Exception {
        if ((u != null) && (u.getIdEstado() > 0)) {
            return this.searchController(u.getIdEstado());
        } else {
        	throw new Exception("Error in the method search at the class ControllerEstado, wrong parameter !!!");
        }
    }

}
