package com.mutual.SistemaMigracionMutual.Servicios;

import com.mutual.SistemaMigracionMutual.Entidades.AyudaPesos;
import com.mutual.SistemaMigracionMutual.Utilidades.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public class AyudaPesosMigracionService {
	
	EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

    public void limpiarTabla() throws PersistenceException {

        // Borrar todos los registros
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM AyudaPesos").executeUpdate();
        // Reiniciar el autoincremento
        entityManager.createNativeQuery("ALTER TABLE AYUDAS_PESOS AUTO_INCREMENT = 1").executeUpdate();
        entityManager.getTransaction().commit();

    }

    public void cargarRegistroEnTabla(AyudaPesos ayuda) throws PersistenceException {

        // Insertar registro
        entityManager.getTransaction().begin();
        entityManager.persist(ayuda);
        entityManager.getTransaction().commit();

    }

}
