/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seuz.dao;

import com.seuz.database.JpaUtil;
import com.seuz.to.EmployeeTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author freet
 */
@Stateless(name = "controladorEmployee")
public class EmployeeDAO extends AbstractFacade<EmployeeTO> implements ProcesoDAO<EmployeeTO> {

    public EmployeeDAO() {
        super(EmployeeTO.class);
    }

    @Override
    public EmployeeTO find(String name, String lastname) {
        EntityManager em = null;
        try {
            System.out.println("ConsultarEmp: " + name + " | " + lastname);
            em = getEntityManager();
            Query q = em.createNamedQuery("EmployeeTO.findNameLastname");
            q.setParameter("name", name.trim().toUpperCase());
            q.setParameter("lastname", lastname.trim().toUpperCase());
            return (EmployeeTO) q.getSingleResult();
        } catch (Exception e) {
//            e.printStackTrace();
        } finally {
            JpaUtil.getInstance().closeEntityManager(em);
        }
        return null;
    }

}
