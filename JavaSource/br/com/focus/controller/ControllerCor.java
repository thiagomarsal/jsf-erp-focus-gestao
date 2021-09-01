/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Cor;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerCor extends Controller<Cor> {

    private Cor cor;

    /**
     * @constructor of the class.
     */
    public ControllerCor() {
    	// contructor of the superclasse
    	super(new Facade<Cor>(Cor.class));
        this.cor = new Cor();
    }

    /**
	 * @return the Object
	 */
    public Cor getObject() {
        return this.cor;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Cor u) {
        this.cor = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Cor u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Cor u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Cor u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Cor> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Cor> searchByParameter(Cor u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Cor search(Cor u) throws Exception {
        if ((u != null) && (u.getIdCor() > 0)) {
            return this.searchController(u.getIdCor());
        } else {
        	throw new Exception("Error in the method search at the class ControllerCor, wrong parameter !!!");
        }
    }

}
