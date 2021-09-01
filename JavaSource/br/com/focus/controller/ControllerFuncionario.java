/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Funcionario;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerFuncionario extends Controller<Funcionario> {

    private Funcionario funcionario;

    /**
     * @constructor of the class.
     */
    public ControllerFuncionario() {
    	// contructor of the superclasse
    	super(new Facade<Funcionario>(Funcionario.class));
        this.funcionario = new Funcionario();
    }

    /**
	 * @return the Object
	 */
    public Funcionario getObject() {
        return this.funcionario;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Funcionario u) {
        this.funcionario = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Funcionario u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Funcionario u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Funcionario u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Funcionario> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Funcionario> searchByParameter(Funcionario u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Funcionario search(Funcionario u) throws Exception {
        if ((u != null) && (u.getIdFuncionario() > 0)) {
            return this.searchController(u.getIdFuncionario());
        } else {
        	throw new Exception("Error in the method search at the class ControllerFuncionario, wrong parameter !!!");
        }
    }

}
