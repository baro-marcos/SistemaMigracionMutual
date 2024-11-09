package com.mutual.SistemaMigracionMutual.Utilidades;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
	
	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCIA";

	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {

		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}

		return factory;
	}

	public static void shutdown() {

		if (factory != null) {
			factory.close();
		}

	}

}
