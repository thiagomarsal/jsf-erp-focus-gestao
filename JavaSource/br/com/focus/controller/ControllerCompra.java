/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Compra;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerCompra extends Controller<Compra> {

    private Compra compra;

    /**
     * @constructor of the class.
     */
    public ControllerCompra() {
    	// contructor of the superclasse
    	super(new Facade<Compra>(Compra.class));
        this.compra = new Compra();
    }

    /**
	 * @return the Object
	 */
    public Compra getObject() {
        return this.compra;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Compra u) {
        this.compra = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Compra u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Compra u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Compra u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Compra> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Compra> searchByParameter(Compra u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Compra search(Compra u) throws Exception {
        if ((u != null) && (u.getIdCompra() > 0)) {
            return this.searchController(u.getIdCompra());
        } else {
        	throw new Exception("Error in the method search at the class ControllerCompra, wrong parameter !!!");
        }
    }

}
