/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.FormaPagamento;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerFormaPagamento extends Controller<FormaPagamento> {

    private FormaPagamento formaPagamento;

    /**
     * @constructor of the class.
     */
    public ControllerFormaPagamento() {
    	// contructor of the superclasse
    	super(new Facade<FormaPagamento>(FormaPagamento.class));
        this.formaPagamento = new FormaPagamento();
    }

    /**
	 * @return the Object
	 */
    public FormaPagamento getObject() {
        return this.formaPagamento;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(FormaPagamento u) {
        this.formaPagamento = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(FormaPagamento u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(FormaPagamento u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(FormaPagamento u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<FormaPagamento> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<FormaPagamento> searchByParameter(FormaPagamento u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public FormaPagamento search(FormaPagamento u) throws Exception {
        if ((u != null) && (u.getIdFormaPagamento() > 0)) {
            return this.searchController(u.getIdFormaPagamento());
        } else {
        	throw new Exception("Error in the method search at the class ControllerFormaPagamento, wrong parameter !!!");
        }
    }

}
