
package com.mycompany.togi;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class PhotographyService {
@PersistenceContext
private EntityManager em;

public List<Photography> selectItems(){
    TypedQuery<Photography> q=em.createQuery("select p from Photography",Photography.class);
    return q.getResultList();
}
public void persist(Photography photograph){
    em.persist(photograph);
}


}
