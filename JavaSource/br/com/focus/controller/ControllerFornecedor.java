/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Fornecedor;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerFornecedor extends Controller<Fornecedor> {

    private Fornecedor fornecedor;

    /**
     * @constructor of the class.
     */
    public ControllerFornecedor() {
    	// contructor of the superclasse
    	super(new Facade<Fornecedor>(Fornecedor.class));
        this.fornecedor = new Fornecedor();
    }

    /**
	 * @return the Object
	 */
    public Fornecedor getObject() {
        return this.fornecedor;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Fornecedor u) {
        this.fornecedor = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Fornecedor u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Fornecedor u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Fornecedor u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Fornecedor> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Fornecedor> searchByParameter(Fornecedor u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Fornecedor search(Fornecedor u) throws Exception {
        if ((u != null) && (u.getIdFornecedor() > 0)) {
            return this.searchController(u.getIdFornecedor());
        } else {
        	throw new Exception("Error in the method search at the class ControllerFornecedor, wrong parameter !!!");
        }
    }

}
