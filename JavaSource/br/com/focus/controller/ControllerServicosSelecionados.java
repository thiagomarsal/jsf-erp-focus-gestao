/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.ServicosSelecionados;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerServicosSelecionados extends Controller<ServicosSelecionados> {

    private ServicosSelecionados servicosSelecionados;

    /**
     * @constructor of the class.
     */
    public ControllerServicosSelecionados() {
    	// contructor of the superclasse
    	super(new Facade<ServicosSelecionados>(ServicosSelecionados.class));
        this.servicosSelecionados = new ServicosSelecionados();
    }

    /**
	 * @return the Object
	 */
    public ServicosSelecionados getObject() {
        return this.servicosSelecionados;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(ServicosSelecionados u) {
        this.servicosSelecionados = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(ServicosSelecionados u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(ServicosSelecionados u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(ServicosSelecionados u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<ServicosSelecionados> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<ServicosSelecionados> searchByParameter(ServicosSelecionados u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public ServicosSelecionados search(ServicosSelecionados u) throws Exception {
        if ((u != null) && (u.getIdServicosSelecionados() > 0)) {
            return this.searchController(u.getIdServicosSelecionados());
        } else {
        	throw new Exception("Error in the method search at the class ControllerServicosSelecionados, wrong parameter !!!");
        }
    }

}
