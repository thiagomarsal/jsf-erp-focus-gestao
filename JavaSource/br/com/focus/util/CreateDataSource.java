package br.com.focus.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateDataSource {
	public static void main(String[] args) {
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure();
		SchemaExport se = new SchemaExport(configuration);
		se.create(true, true);
	}
}