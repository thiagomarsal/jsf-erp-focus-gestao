/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.OrdemServico;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerOrdemServico extends Controller<OrdemServico> {

    private OrdemServico compra;

    /**
     * @constructor of the class.
     */
    public ControllerOrdemServico() {
    	// contructor of the superclasse
    	super(new Facade<OrdemServico>(OrdemServico.class));
        this.compra = new OrdemServico();
    }

    /**
	 * @return the Object
	 */
    public OrdemServico getObject() {
        return this.compra;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(OrdemServico u) {
        this.compra = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(OrdemServico u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(OrdemServico u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(OrdemServico u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<OrdemServico> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<OrdemServico> searchByParameter(OrdemServico u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public OrdemServico search(OrdemServico u) throws Exception {
        if ((u != null) && (u.getIdOrdemServico() > 0)) {
            return this.searchController(u.getIdOrdemServico());
        } else {
        	throw new Exception("Error in the method search at the class ControllerOrdemServico, wrong parameter !!!");
        }
    }

}
