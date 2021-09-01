/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.ContaPagar;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerContaPagar extends Controller<ContaPagar> {

    private ContaPagar contaPagar;

    /**
     * @constructor of the class.
     */
    public ControllerContaPagar() {
    	// contructor of the superclasse
    	super(new Facade<ContaPagar>(ContaPagar.class));
        this.contaPagar = new ContaPagar();
    }

    /**
	 * @return the Object
	 */
    public ContaPagar getObject() {
        return this.contaPagar;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(ContaPagar u) {
        this.contaPagar = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(ContaPagar u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(ContaPagar u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(ContaPagar u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<ContaPagar> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<ContaPagar> searchByParameter(ContaPagar u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public ContaPagar search(ContaPagar u) throws Exception {
        if ((u != null) && (u.getIdContaPagar() > 0)) {
            return this.searchController(u.getIdContaPagar());
        } else {
        	throw new Exception("Error in the method search at the class ControllerContasPagar, wrong parameter !!!");
        }
    }

}
