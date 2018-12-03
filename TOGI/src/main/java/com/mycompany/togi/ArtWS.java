/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.togi;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


public class ArtWS {

    @Context
    private UriInfo context;
    @EJB
    private ArtService artservice;
   
    @GET
    @Path("post/{TOGI}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readOrder(@PathParam("TOGI") Long id) {
        
        Art art = artservice.selectById(id);
        if (art == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(art).build();
    }

    @POST
    @Path("comments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createArt(Art art) {
        
       
      art.setId(Long.MIN_VALUE);
        art.setComment("test");
        art.setCommentnum(0);
        Date date=new Date();
        art.setDate(date);
        art.setBoard("Art");
        art.setPost(0);
        artservice.persist(art);
       

        return Response.ok(art.getId()).build();
    }
}