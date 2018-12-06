///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.togi;
//
//import java.util.List;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//
///**
// *
// * @author NolanPC
// */
//@Stateless
//public class PoliticsService {
//
//   @PersistenceContext
//private EntityManager em;
//
//public List<Politics> selectItems(){
//    TypedQuery<Politics> q=em.createQuery("select p from Politics p",Politics.class);
//    return q.getResultList();
//}
//public void persist(Politics politic){
//    em.persist(politic);
//}
// public Politics selecttitle(String title) {
//        return em.find(Politics.class,title);
//    }
//}
