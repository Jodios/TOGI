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

@Stateless
public class PostService {

    @PersistenceContext
    private EntityManager em;

    public List<Post> selectItems() {
        TypedQuery<Post> q = em.createQuery("select a from Post a", Post.class);
        return q.getResultList();
    }

    public void persist(Post post) {
        em.persist(post);
    }

    public Post selectById(Long id) {
        return em.find(Post.class, id);
    }
}
