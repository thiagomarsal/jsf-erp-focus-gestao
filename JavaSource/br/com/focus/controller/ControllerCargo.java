/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Cargo;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerCargo extends Controller<Cargo> {

    private Cargo cargo;

    /**
     * @constructor of the class.
     */
    public ControllerCargo() {
    	// contructor of the superclasse
    	super(new Facade<Cargo>(Cargo.class));
        this.cargo = new Cargo();
    }

    /**
	 * @return the Object
	 */
    public Cargo getObject() {
        return this.cargo;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Cargo u) {
        this.cargo = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Cargo u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Cargo u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Cargo u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Cargo> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Cargo> searchByParameter(Cargo u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Cargo search(Cargo u) throws Exception {
        if ((u != null) && (u.getIdCargo() > 0)) {
            return this.searchController(u.getIdCargo());
        } else {
        	throw new Exception("Error in the method search at the class ControllerCargo, wrong parameter !!!");
        }
    }

}
