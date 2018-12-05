/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.togi.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author NolanPC
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

 
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.togi.ArtWS.class);
        resources.add(com.mycompany.togi.GamesWS.class);
        resources.add(com.mycompany.togi.MathematicsWS.class);
        resources.add(com.mycompany.togi.MusicWS.class);
        resources.add(com.mycompany.togi.PoliticsWS.class);
        resources.add(service.PhotographyFacadeREST.class);
        resources.add(service.RandomFacadeREST.class);
        resources.add(service.TechnologyFacadeREST.class);
    }
    
}
