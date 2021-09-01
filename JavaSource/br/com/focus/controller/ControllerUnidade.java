/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Unidade;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerUnidade extends Controller<Unidade> {

    private Unidade unidade;

    /**
     * @constructor of the class.
     */
    public ControllerUnidade() {
    	// contructor of the superclasse
    	super(new Facade<Unidade>(Unidade.class));
        this.unidade = new Unidade();
    }

    /**
	 * @return the Object
	 */
    public Unidade getObject() {
        return this.unidade;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Unidade u) {
        this.unidade = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Unidade u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Unidade u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Unidade u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Unidade> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Unidade> searchByParameter(Unidade u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Unidade search(Unidade u) throws Exception {
        if ((u != null) && (u.getIdUnidade() > 0)) {
            return this.searchController(u.getIdUnidade());
        } else {
        	throw new Exception("Error in the method search at the class ControllerUnidade, wrong parameter !!!");
        }
    }

}
