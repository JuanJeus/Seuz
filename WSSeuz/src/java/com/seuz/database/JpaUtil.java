/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seuz.database;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author freet
 */
public class JpaUtil {

    private JpaUtil() {
    }

    public static JpaUtil getInstance() {
        return JpaUtilHolder.INSTANCE;
    }

    private static class JpaUtilHolder {
        private static final JpaUtil INSTANCE = new JpaUtil();
    }

    public EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory("WSSeuzPU").createEntityManager();
    }

    public void closeEntityManager(EntityManager em) {
        if (em != null) {
            em.close();
        }
    }

    public void rollBackEntityManager(EntityManager em) {
        if (em != null) {
            em.getTransaction().rollback();
        }
    }
}
