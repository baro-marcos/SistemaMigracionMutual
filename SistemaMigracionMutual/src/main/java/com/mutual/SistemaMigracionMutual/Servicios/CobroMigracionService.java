package com.mutual.SistemaMigracionMutual.Servicios;

import com.mutual.SistemaMigracionMutual.Entidades.Cobro;
import com.mutual.SistemaMigracionMutual.Utilidades.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public class CobroMigracionService {
	
	EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

    public void limpiarTabla() throws PersistenceException {

        // Borrar todos los registros
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Cobro").executeUpdate();
        // Reiniciar el autoincremento
        entityManager.createNativeQuery("ALTER TABLE COBROS AUTO_INCREMENT = 1").executeUpdate();
        entityManager.getTransaction().commit();

    }

    public void cargarRegistroEnTabla(Cobro cobro) throws PersistenceException {

        // Insertar registro
        entityManager.getTransaction().begin();
        entityManager.persist(cobro);
        entityManager.getTransaction().commit();

    }

}
