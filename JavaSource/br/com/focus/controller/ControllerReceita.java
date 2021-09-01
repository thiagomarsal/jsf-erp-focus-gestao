/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Receita;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerReceita extends Controller<Receita> {

    private Receita lenteBloco;

    /**
     * @constructor of the class.
     */
    public ControllerReceita() {
    	// contructor of the superclasse
    	super(new Facade<Receita>(Receita.class));
        this.lenteBloco = new Receita();
    }

    /**
	 * @return the Object
	 */
    public Receita getObject() {
        return this.lenteBloco;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Receita u) {
        this.lenteBloco = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Receita u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Receita u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Receita u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Receita> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Receita> searchByParameter(Receita u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Receita search(Receita u) throws Exception {
        if ((u != null) && (u.getIdReceita() > 0)) {
            return this.searchController(u.getIdReceita());
        } else {
        	throw new Exception("Error in the method search at the class ControllerReceita, wrong parameter !!!");
        }
    }

}
