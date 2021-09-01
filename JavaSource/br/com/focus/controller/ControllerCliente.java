/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Cliente;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerCliente extends Controller<Cliente> {

    private Cliente cliente;

    /**
     * @constructor of the class.
     */
    public ControllerCliente() {
    	// contructor of the superclasse
    	super(new Facade<Cliente>(Cliente.class));
        this.cliente = new Cliente();
    }

    /**
	 * @return the Object
	 */
    public Cliente getObject() {
        return this.cliente;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Cliente u) {
        this.cliente = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Cliente u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Cliente u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Cliente u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Cliente> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Cliente> searchByParameter(Cliente u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Cliente search(Cliente u) throws Exception {
        if ((u != null) && (u.getIdCliente() > 0)) {
            return this.searchController(u.getIdCliente());
        } else {
        	throw new Exception("Error in the method search at the class ControllerCliente, wrong parameter !!!");
        }
    }

}
