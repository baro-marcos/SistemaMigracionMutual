package com.mutual.SistemaMigracionMutual.Servicios;

import com.mutual.SistemaMigracionMutual.Entidades.Saldo;
import com.mutual.SistemaMigracionMutual.Utilidades.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public class SaldoMigracionService {
	
	EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

    public void limpiarTabla() throws PersistenceException {

        // Borrar todos los registros
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Saldo").executeUpdate();
        // Reiniciar el autoincremento
        entityManager.createNativeQuery("ALTER TABLE SALDOS AUTO_INCREMENT = 1").executeUpdate();
        entityManager.getTransaction().commit();

    }

    public void cargarRegistroEnTabla(Saldo saldo) throws PersistenceException {

        // Insertar registro
        entityManager.getTransaction().begin();
        entityManager.persist(saldo);
        entityManager.getTransaction().commit();

    }

}
