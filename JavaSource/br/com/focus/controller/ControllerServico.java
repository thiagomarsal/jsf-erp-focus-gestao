/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Servico;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerServico extends Controller<Servico> {

    private Servico servico;

    /**
     * @constructor of the class.
     */
    public ControllerServico() {
    	// contructor of the superclasse
    	super(new Facade<Servico>(Servico.class));
        this.servico = new Servico();
    }

    /**
	 * @return the Object
	 */
    public Servico getObject() {
        return this.servico;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Servico u) {
        this.servico = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Servico u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Servico u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Servico u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Servico> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Servico> searchByParameter(Servico u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Servico search(Servico u) throws Exception {
        if ((u != null) && (u.getIdServico() > 0)) {
            return this.searchController(u.getIdServico());
        } else {
        	throw new Exception("Error in the method search at the class ControllerServico, wrong parameter !!!");
        }
    }

}
