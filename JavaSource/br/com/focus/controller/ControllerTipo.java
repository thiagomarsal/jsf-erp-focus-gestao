/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Tipo;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerTipo extends Controller<Tipo> {

    private Tipo tipo;

    /**
     * @constructor of the class.
     */
    public ControllerTipo() {
    	// contructor of the superclasse
    	super(new Facade<Tipo>(Tipo.class));
        this.tipo = new Tipo();
    }

    /**
	 * @return the Object
	 */
    public Tipo getObject() {
        return this.tipo;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Tipo u) {
        this.tipo = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Tipo u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Tipo u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Tipo u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Tipo> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Tipo> searchByParameter(Tipo u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Tipo search(Tipo u) throws Exception {
        if ((u != null) && (u.getIdTipo() > 0)) {
            return this.searchController(u.getIdTipo());
        } else {
        	throw new Exception("Error in the method search at the class ControllerTipo, wrong parameter !!!");
        }
    }

}
