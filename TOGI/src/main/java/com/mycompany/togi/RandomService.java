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
public class RandomService {

@PersistenceContext
private EntityManager em;

public List<Random> selectItems(){
    TypedQuery<Random> q=em.createQuery("select r from Random",Random.class);
    return q.getResultList();
}
public void persist(Random random){
    em.persist(random);
}
}

