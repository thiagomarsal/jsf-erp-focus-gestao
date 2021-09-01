/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Cidade;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerCidade extends Controller<Cidade> {

    private Cidade cidade;

    /**
     * @constructor of the class.
     */
    public ControllerCidade() {
    	// contructor of the superclasse
    	super(new Facade<Cidade>(Cidade.class));
        this.cidade = new Cidade();
    }

    /**
	 * @return the Object
	 */
    public Cidade getObject() {
        return this.cidade;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Cidade u) {
        this.cidade = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Cidade u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Cidade u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Cidade u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Cidade> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Cidade> searchByParameter(Cidade u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Cidade search(Cidade u) throws Exception {
        if ((u != null) && (u.getIdCidade() > 0)) {
            return this.searchController(u.getIdCidade());
        } else {
        	throw new Exception("Error in the method search at the class ControllerCidade, wrong parameter !!!");
        }
    }

}
