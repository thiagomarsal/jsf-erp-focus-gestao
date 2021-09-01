/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.bean.ProdutosSelecionados;
import br.com.focus.facade.Facade;


/**
 * @author Thiago M. Farias
 * 
 */
public class ControllerProdutosSelecionados extends Controller<ProdutosSelecionados> {

    private ProdutosSelecionados produtosCompra;

    /**
     * @constructor of the class.
     */
    public ControllerProdutosSelecionados() {
    	// contructor of the superclasse
    	super(new Facade<ProdutosSelecionados>(ProdutosSelecionados.class));
        this.produtosCompra = new ProdutosSelecionados();
    }

    /**
	 * @return the Object
	 */
    public ProdutosSelecionados getObject() {
        return this.produtosCompra;
    }

    /**
	 * @param Object
	 *            the Object to set
	 */
    public void setObject(ProdutosSelecionados u) {
        this.produtosCompra = u;
    }

    /**
     * @method Save
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean saveOrUpdate(ProdutosSelecionados u) throws Exception {
        return this.executeController(Controller.SAVEORUPDATE, u);
    }

    /**
     * @method Update
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean update(ProdutosSelecionados u) throws Exception {
        return this.executeController(Controller.UPDATE, u);
    }

    /**
     * @method Delete
     * @param Object
     * @return Boolean
     * @throws Exception
     */
    public Boolean delete(ProdutosSelecionados u) throws Exception {
        return this.executeController(Controller.DELETE, u);
    }

    /**
     * @method List All
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<ProdutosSelecionados> listAll() throws Exception {
        return this.listAllController();
    }

    /**
     * @method Search by Parameter with Like
     * @param Object
     * @return List
     * @throws Exception
     */
    public List<ProdutosSelecionados> searchByParameter(ProdutosSelecionados u) throws Exception {
        return this.searchByParameterController(u);
    }

    /**
     * @method Search by ID
     * @param Object
     * @return Object
     * @throws Exception
     */
    public ProdutosSelecionados search(ProdutosSelecionados u) throws Exception {
        if ((u != null) && (u.getIdProdutosSelecionados() > 0)) {
            return this.searchController(u.getIdProdutosSelecionados());
        } else {
        	throw new Exception("Error in the method search at the class ControllerProdutosCompra, wrong parameter !!!");
        }
    }

}
