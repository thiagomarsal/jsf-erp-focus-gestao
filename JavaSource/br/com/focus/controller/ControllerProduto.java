/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Produto;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerProduto extends Controller<Produto> {

    private Produto produto;

    /**
     * @constructor of the class.
     */
    public ControllerProduto() {
    	// contructor of the superclasse
    	super(new Facade<Produto>(Produto.class));
        this.produto = new Produto();
    }

    /**
	 * @return the Object
	 */
    public Produto getObject() {
        return this.produto;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Produto u) {
        this.produto = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Produto u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Produto u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Produto u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Produto> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Produto> searchByParameter(Produto u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Produto search(Produto u) throws Exception {
        if ((u != null) && (u.getIdProduto() > 0)) {
            return this.searchController(u.getIdProduto());
        } else {
        	throw new Exception("Error in the method search at the class ControllerProduto, wrong parameter !!!");
        }
    }

}
