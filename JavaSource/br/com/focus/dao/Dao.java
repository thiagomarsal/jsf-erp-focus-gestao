/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;

/**
 * @author Thiago M. Farias
 * 
 */
public class Dao<T> {
	private final Session session;
	@SuppressWarnings("unchecked")
	private final Class classe;

	/**
	 * Constructor of DAO Class
	 */
	@SuppressWarnings("unchecked")
	public Dao(Session session, Class classe) {
		this.session = session;
		this.classe = classe;
	}
	
	/**
	 * @method Save or Update DAO.
	 */
	public void saveOrUpdateDao(T u) throws Exception
	{
		this.session.saveOrUpdate(u);
	}
	
	/**
	 * @method Save retornando o ID DAO.
	 * @return Boolean
	 */
	public T saveReturningIdDao(T u) throws Exception
	{
		this.session.persist(u);
		return u;
	}
	
	/**
	 * @method Delete DAO.
	 */
	public void deleteDao(T u) throws Exception{
		this.session.delete(u);
	}
	
	/**
	 * @method Update DAO.
	 */
	public void updateDao(T u) throws Exception{
		this.session.merge(u);
		this.session.flush();
		this.session.evict(u);
	}
	
	/**
	 * @method Save DAO.
	 */
	public void saveDao(T u) throws Exception {
		this.session.save(u);
	}
	
	/**
	 * @method List All DAO.
	 * @return List
	 */
	@SuppressWarnings("unchecked") 
	public List<T> listAllDao() throws Exception{
		return this.session.createCriteria(this.classe).list();
	}
	
	/**
	 * @method Search by ID DAO.
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public T searchDao(Long id) throws Exception{
		return (T) session.load(this.classe, id);
	}
	
	/**
	 * @method Search by ID DAO.
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public T searchDao(String id) throws Exception{
		return (T) session.load(this.classe, id);
	}
	
	/**
	 * @method Search by ID with Like DAO.
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<T> searchByParameterDao(T u) throws Exception{
//              //perform case insensitive string comparisons
		Example example = Example.create(u)
		    .excludeZeroes()           //exclude zero valued properties
		    .ignoreCase()
		    .enableLike();             //use like for string comparisons
		List<T> results = session.createCriteria(this.classe)
	    .add(example)
	    .list();
		return results;
	}
}
