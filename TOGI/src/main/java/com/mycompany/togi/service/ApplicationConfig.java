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
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycompany.togi.service.ArtFacadeREST.class);
        resources.add(com.mycompany.togi.service.GamesFacadeREST.class);
        resources.add(com.mycompany.togi.service.MathematicsFacadeREST.class);
        resources.add(com.mycompany.togi.service.MusicFacadeREST.class);
        resources.add(com.mycompany.togi.service.PhotographyFacadeREST.class);
        resources.add(com.mycompany.togi.service.PoliticsFacadeREST.class);
        resources.add(com.mycompany.togi.service.RandomFacadeREST.class);
        resources.add(com.mycompany.togi.service.TechnologyFacadeREST.class);
    }
    
}
