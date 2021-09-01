/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.ContaReceber;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerContaReceber extends Controller<ContaReceber> {

    private ContaReceber contaReceber;

    /**
     * @constructor of the class.
     */
    public ControllerContaReceber() {
    	// contructor of the superclasse
    	super(new Facade<ContaReceber>(ContaReceber.class));
        this.contaReceber = new ContaReceber();
    }

    /**
	 * @return the Object
	 */
    public ContaReceber getObject() {
        return this.contaReceber;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(ContaReceber u) {
        this.contaReceber = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(ContaReceber u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(ContaReceber u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(ContaReceber u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<ContaReceber> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<ContaReceber> searchByParameter(ContaReceber u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public ContaReceber search(ContaReceber u) throws Exception {
        if ((u != null) && (u.getIdContaReceber() > 0)) {
            return this.searchController(u.getIdContaReceber());
        } else {
        	throw new Exception("Error in the method search at the class ControllerContasReceber, wrong parameter !!!");
        }
    }

}
