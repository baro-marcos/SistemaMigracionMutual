package com.mutual.SistemaMigracionMutual.Servicios;

import com.mutual.SistemaMigracionMutual.Entidades.Cuota;
import com.mutual.SistemaMigracionMutual.Utilidades.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public class CuotaMigracionService {
	
	EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

    public void limpiarTabla() throws PersistenceException {

        // Borrar todos los registros
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Cuota").executeUpdate();
        // Reiniciar el autoincremento
        entityManager.createNativeQuery("ALTER TABLE CUOTAS AUTO_INCREMENT = 1").executeUpdate();
        entityManager.getTransaction().commit();

    }

    public void cargarRegistroEnTabla(Cuota cuota) throws PersistenceException {

        // Insertar registro
        entityManager.getTransaction().begin();
        entityManager.persist(cuota);
        entityManager.getTransaction().commit();

    }

}
