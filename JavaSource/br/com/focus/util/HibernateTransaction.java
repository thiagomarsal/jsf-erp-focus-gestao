/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Thiago M. Farias
 * 
 */
public class HibernateTransaction {
	private static HibernateTransaction daoFactory = null;

	private final Session session;
	private Transaction transaction;

	private HibernateTransaction() {
		session = HibernateUtil.getSession();
	}

	public Session getSession() {
		return this.session;
	}

	public static HibernateTransaction getInstance() {
		if (daoFactory == null) {
			daoFactory = new HibernateTransaction();
		}
		return daoFactory;
	}

	public void beginTransaction() {
		if(this.session.isConnected())
			this.transaction = this.session.beginTransaction();
		else{
			
		}
	}

	public void commit() {
		this.transaction.commit();
		session.clear();
		this.transaction = null;
	}

	public boolean hasTransaction() {
		return this.transaction != null;
	}

	public void rollback() {
		this.transaction.rollback();
		session.clear();
		this.transaction = null;
	}

	public void close() {
		this.session.close();
	}

}
