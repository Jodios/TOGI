/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.togi;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author NolanPC
 */
@Stateless
public class MathematicsService {
@PersistenceContext
private EntityManager em;

public List<Mathematics> selectItems(){
    TypedQuery<Mathematics> q=em.createQuery("select m from Mathematics m",Mathematics.class);
    return q.getResultList();
}
public void persist(Mathematics math){
    em.persist(math);
}
 public Mathematics selectById(Long id) {
        return em.find(Mathematics.class, id);
    }
}

