/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.Material;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerMaterial extends Controller<Material> {

    private Material material;

    /**
     * @constructor of the class.
     */
    public ControllerMaterial() {
    	// contructor of the superclasse
    	super(new Facade<Material>(Material.class));
        this.material = new Material();
    }

    /**
	 * @return the Object
	 */
    public Material getObject() {
        return this.material;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(Material u) {
        this.material = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(Material u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(Material u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(Material u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Material> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<Material> searchByParameter(Material u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public Material search(Material u) throws Exception {
        if ((u != null) && (u.getIdMaterial() > 0)) {
            return this.searchController(u.getIdMaterial());
        } else {
        	throw new Exception("Error in the method search at the class ControllerMaterial, wrong parameter !!!");
        }
    }

}
