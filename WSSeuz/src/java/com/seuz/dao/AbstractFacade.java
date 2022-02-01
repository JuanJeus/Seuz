/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seuz.dao;

import com.seuz.database.JpaUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author freet
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;

    private final EntityManagerFactory emf = JpaUtil.getInstance().createEntityManager().getEntityManagerFactory();

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(T t) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            JpaUtil.getInstance().rollBackEntityManager(em);
            e.printStackTrace();
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public boolean edit(T t) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public boolean destroy(T t) {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
            em.getTransaction().begin();
            T k = em.merge(t);
            em.merge(k);
            em.remove(k);
            em.remove(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            JpaUtil.getInstance().rollBackEntityManager(em);
            return false;
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
    }

    public T find(Integer id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findEntities() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
