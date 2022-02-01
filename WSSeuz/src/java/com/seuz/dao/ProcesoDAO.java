/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seuz.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author freet
 */
@Local
public interface ProcesoDAO<T> {

    public boolean create(T entity);

    public boolean edit(T entity);

    public T find(Integer id);

    public T find(String a, String b);

    public List<T> findEntities();
}
