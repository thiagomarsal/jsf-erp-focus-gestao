/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Linha;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerLinha extends Controller<Linha> {

    private Linha linha;

    /**
     * @constructor of the class.
     */
    public ControllerLinha() {
    	// contructor of the superclasse
    	super(new Facade<Linha>(Linha.class));
        this.linha = new Linha();
    }

    /**
	 * @return the Object
	 */
    public Linha getObject() {
        return this.linha;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Linha u) {
        this.linha = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Linha u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Linha u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Linha u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Linha> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Linha> searchByParameter(Linha u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Linha search(Linha u) throws Exception {
        if ((u != null) && (u.getIdLinha() > 0)) {
            return this.searchController(u.getIdLinha());
        } else {
        	throw new Exception("Error in the method search at the class ControllerLinha, wrong parameter !!!");
        }
    }

}
