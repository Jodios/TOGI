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
public class MusicService {

   @PersistenceContext
private EntityManager em;

public List<Music> selectItems(){
    TypedQuery<Music> q=em.createQuery("select m from Music m",Music.class);
    return q.getResultList();
}
public void persist(Art art){
    em.persist(art);
}
}
