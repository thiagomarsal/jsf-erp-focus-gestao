/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Modelo;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerModelo extends Controller<Modelo> {

    private Modelo modelo;

    /**
     * @constructor of the class.
     */
    public ControllerModelo() {
    	// contructor of the superclasse
    	super(new Facade<Modelo>(Modelo.class));
        this.modelo = new Modelo();
    }

    /**
	 * @return the Object
	 */
    public Modelo getObject() {
        return this.modelo;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Modelo u) {
        this.modelo = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Modelo u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Modelo u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Modelo u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Modelo> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Modelo> searchByParameter(Modelo u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Modelo search(Modelo u) throws Exception {
        if ((u != null) && (u.getIdModelo() > 0)) {
            return this.searchController(u.getIdModelo());
        } else {
        	throw new Exception("Error in the method search at the class ControllerModelo, wrong parameter !!!");
        }
    }

}
