/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Venda;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerVenda extends Controller<Venda> {

    private Venda compra;

    /**
     * @constructor of the class.
     */
    public ControllerVenda() {
    	// contructor of the superclasse
    	super(new Facade<Venda>(Venda.class));
        this.compra = new Venda();
    }

    /**
	 * @return the Object
	 */
    public Venda getObject() {
        return this.compra;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Venda u) {
        this.compra = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Venda u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Venda u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Venda u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Venda> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Venda> searchByParameter(Venda u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Venda search(Venda u) throws Exception {
        if ((u != null) && (u.getIdVenda() > 0)) {
            return this.searchController(u.getIdVenda());
        } else {
        	throw new Exception("Error in the method search at the class ControllerVenda, wrong parameter !!!");
        }
    }

}
