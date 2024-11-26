package com.mutual.SistemaMigracionMutual.Servicios;

import com.mutual.SistemaMigracionMutual.Entidades.CobroCuotaAyudaPesos;
import com.mutual.SistemaMigracionMutual.Utilidades.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public class CobroCuotaAyudaPesosMigracionService {
	
	EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

    public void limpiarTabla() throws PersistenceException {

        // Borrar todos los registros
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM CobroCuotaAyudaPesos").executeUpdate();
        // Reiniciar el autoincremento
        entityManager.createNativeQuery("ALTER TABLE COBROS_CUOTAS_AYUDAS_PESOS AUTO_INCREMENT = 1").executeUpdate();
        entityManager.getTransaction().commit();

    }

    public void cargarRegistroEnTabla(CobroCuotaAyudaPesos cobro) throws PersistenceException {

        // Insertar registro
        entityManager.getTransaction().begin();
        entityManager.persist(cobro);
        entityManager.getTransaction().commit();

    }

}
