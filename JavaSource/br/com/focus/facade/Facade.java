/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.facade;

import java.util.List;

import br.com.focus.dao.Dao;
import br.com.focus.util.HibernateTransaction;

/**
 * @author Thiago M. Farias
 * 
 */
public class Facade<T> {

	protected final HibernateTransaction factory;
	protected Dao<T> dao;

	/**
	 * Constructor of the FACADE class
	 */
	public Facade(Class<T> classe) {
		factory = HibernateTransaction.getInstance();
		dao = new Dao<T>(factory.getSession(), classe);
	}

	/**
	 * @method Save Facade.
	 * @return Boolean
	 * @throws Exception
	 */
	public Boolean saveFacade(T u) throws Exception {
		if (factory.hasTransaction()) {
			dao.saveDao(u);
			return true;
		} else {
			throw new Exception("There isn't transaction (facade.saveFacade)!!!");
		}
	}

	/**
	 * @method Delete Facade.
	 * @return Boolean
	 * @throws Exception
	 */
	public Boolean deleteFacade(T u) throws Exception {
		if (factory.hasTransaction()) {
			dao.deleteDao(u);
			return true;
		} else {
			throw new Exception("There isn't transaction (facade.deleteFacade)!!!");
		}
	}

	/**
	 * @method Update Facade.
	 * @return Boolean
	 * @throws Exception
	 */
	public Boolean updateFacade(T u) throws Exception {
		if (factory.hasTransaction()) {
			dao.updateDao(u);
			return true;
		} else {
			throw new Exception("There isn't transaction (facade.updateFacade)!!!");
		}
	}

	/**
	 * @method Save or Update Facade.
	 * @return Boolean
	 * @throws Exception
	 */
	public Boolean saveOrUpdateFacade(T u) throws Exception {
		if (factory.hasTransaction()) {
			dao.saveOrUpdateDao(u);
			return true;
		} else {
			throw new Exception("There isn't transaction (facade.saveOrUpdateFacade)!!!");
		}
	}

	/**
	 * @method List All Facade.
	 * @return List
	 * @throws Exception
	 */
	public List<T> listAllFacade() throws Exception {
		return dao.listAllDao();
	}

	/**
	 * @method Search Facade.
	 * @return Object
	 * @throws Exception
	 */
	public T searchFacade(Long id) throws Exception {
		return (T) dao.searchDao(id);
	}

	/**
	 * @method Search Facade.
	 * @return Object
	 * @throws Exception
	 */
	public T searchFacade(String id) throws Exception {
		factory.getSession().clear();
		return (T) dao.searchDao(id);
	}
	
	/**
	 * @method Search by Parameter Facade.
	 * @return List
	 * @throws Exception
	 */
	public List<T> searchByParameterFacade(T u) throws Exception {
		return dao.searchByParameterDao(u);
	}
}
