/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.controller;

import java.util.List;

import br.com.focus.facade.Facade;
import br.com.focus.util.HibernateTransaction;

/**
 * @author Thiago M. Farias
 * 
 */
public class Controller<T> {
	private Facade<T> facade;
	public static final Integer SAVE = 0;
	public static final Integer DELETE = 1;
	public static final Integer UPDATE = 2;
	public static final Integer SAVEORUPDATE = 3;

	
	/**
	 * @constructor of the CONTROLLER class
	 */
	public Controller(Facade<T> fac) {
		this.facade = fac;
	}
	
	/**
	 * @method Save Controller.
	 * @return Boolean
	 * @throws Exception
	 */
	private Boolean saveController(T u) throws Exception {
		return this.facade.saveFacade(u);
	}

	/**
	 * @method List All Controller.
	 * @return List
	 * @throws Exception
	 */
	public List<T> listAllController() throws Exception {
		return this.facade.listAllFacade();
	}

	/**
	 * @method Search Controller.
	 * @return Object
	 * @throws Exception
	 */
	public T searchController(Long id) throws Exception {
		return this.facade.searchFacade(id);
	}

	/**
	 * @method Search Controller.
	 * @return Object
	 * @throws Exception
	 */
	public T searchController(String id) throws Exception {
		return this.facade.searchFacade(id);
	}
	
	/**
	 * @method Search by Parameter Controller.
	 * @return List
	 * @throws Exception
	 */
	public List<T> searchByParameterController(T u) throws Exception {
		return this.facade.searchByParameterFacade(u);
	}

	/**
	 * @method Delete Controller.
	 * @return Boolean
	 * @throws Exception
	 */
	private Boolean deleteController(T u) throws Exception {
		return this.facade.deleteFacade(u);
	}

	/**
	 * @method Update Controller.
	 * @return Boolean
	 * @throws Exception
	 */
	private Boolean updateController(T u) throws Exception {
		return this.facade.updateFacade(u);
	}

	/**
	 * @method Save or Update Controller.
	 * @return Boolean
	 * @throws Exception
	 */
	private Boolean saveOrUpdateController(T u) throws Exception {
		return this.facade.saveOrUpdateFacade(u);
	}

	/**
	 * @method Execute Controller.
	 * @return Boolean
	 * @throws Exception
	 */
	public Boolean executeController(Integer acao, T u) throws Exception {
		switch (acao) {
		case 0:
			try {
				HibernateTransaction.getInstance().beginTransaction();
				this.saveController(u);
				HibernateTransaction.getInstance().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				HibernateTransaction.getInstance().rollback();
				throw new Exception("### Error in the method saveController at the Controller. ###");
			}
		case 1:
			try {
				HibernateTransaction.getInstance().beginTransaction();
				this.deleteController(u);
				HibernateTransaction.getInstance().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				HibernateTransaction.getInstance().rollback();
				throw new Exception("Dependência existente, impossivel excluir o item selecionado!");
			}
		case 2:
			try {
				HibernateTransaction.getInstance().beginTransaction();
				this.updateController(u);
				HibernateTransaction.getInstance().commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				HibernateTransaction.getInstance().rollback();
				throw new Exception("### Error in the method updateController at the Controller.###");
			}
		case 3:
			try {
				HibernateTransaction.getInstance().beginTransaction();
				this.saveOrUpdateController(u);
				HibernateTransaction.getInstance().commit();
			} catch (Exception e) {
				e.printStackTrace();
				HibernateTransaction.getInstance().rollback();
				throw new Exception("### Error in the method saveOrUpdateController at the Controller. ###");
			}
		default:
			return false;
		}
	}
}