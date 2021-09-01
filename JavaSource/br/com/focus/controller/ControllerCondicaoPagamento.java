/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.CondicaoPagamento;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerCondicaoPagamento extends Controller<CondicaoPagamento> {

    private CondicaoPagamento condicaoPagamento;

    /**
     * @constructor of the class.
     */
    public ControllerCondicaoPagamento() {
    	// contructor of the superclasse
    	super(new Facade<CondicaoPagamento>(CondicaoPagamento.class));
        this.condicaoPagamento = new CondicaoPagamento();
    }

    /**
	 * @return the Object
	 */
    public CondicaoPagamento getObject() {
        return this.condicaoPagamento;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(CondicaoPagamento u) {
        this.condicaoPagamento = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(CondicaoPagamento u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(CondicaoPagamento u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(CondicaoPagamento u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<CondicaoPagamento> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<CondicaoPagamento> searchByParameter(CondicaoPagamento u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public CondicaoPagamento search(CondicaoPagamento u) throws Exception {
        if ((u != null) && (u.getIdCondicaoPagamento() > 0)) {
            return this.searchController(u.getIdCondicaoPagamento());
        } else {
        	throw new Exception("Error in the method search at the class ControllerCondicaoPagamento, wrong parameter !!!");
        }
    }

}
