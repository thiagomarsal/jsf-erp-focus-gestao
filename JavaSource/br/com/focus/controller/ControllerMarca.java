/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Marca;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerMarca extends Controller<Marca> {

    private Marca marca;

    /**
     * @constructor of the class.
     */
    public ControllerMarca() {
    	// contructor of the superclasse
    	super(new Facade<Marca>(Marca.class));
        this.marca = new Marca();
    }

    /**
	 * @return the Object
	 */
    public Marca getObject() {
        return this.marca;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Marca u) {
        this.marca = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Marca u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Marca u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Marca u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Marca> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Marca> searchByParameter(Marca u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Marca search(Marca u) throws Exception {
        if ((u != null) && (u.getIdMarca() > 0)) {
            return this.searchController(u.getIdMarca());
        } else {
        	throw new Exception("Error in the method search at the class ControllerMarca, wrong parameter !!!");
        }
    }

}
