/**
 *  Copyright (c) 2008 Thiago M. Farias
 *	All Rights Reserved
 *
 *	This product is protected by copyright and distributed under
 *  licenses restricting copying, distribution, and decompilation.
 */
package br.com.focus.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * @author Thiago M. Farias
 * 
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}