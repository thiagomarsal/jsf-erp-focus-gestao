/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Pais;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerPais extends Controller<Pais> {

    private Pais pais;

    /**
     * @constructor of the class.
     */
    public ControllerPais() {
    	// contructor of the superclasse
    	super(new Facade<Pais>(Pais.class));
        this.pais = new Pais();
    }

    /**
	 * @return the Object
	 */
    public Pais getObject() {
        return this.pais;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Pais u) {
        this.pais = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Pais u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Pais u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Pais u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Pais> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Pais> searchByParameter(Pais u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Pais search(Pais u) throws Exception {
        if ((u != null) && (u.getIdPais() > 0)) {
            return this.searchController(u.getIdPais());
        } else {
        	throw new Exception("Error in the method search at the class ControllerPais, wrong parameter !!!");
        }
    }

}
