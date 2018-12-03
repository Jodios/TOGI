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

@Path("comments")
public class ArtWS {

    @Context
    private UriInfo context;
    @EJB
    private ArtService artService;

    @GET
    @Path("post/{TOGI}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readArt(@PathParam("TOGI") Long id) {

        Art art = artService.selectById(id);
        
//        art.setComment(art.getComment());
        if (art == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(art).build();
    }

    @POST
    //@Path("comments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createArt(Art art) {
       
        art.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
//        art.setComment(art.getComment());
//        art.setImg(art.getImg());
        art.setCommentnum(0);
        Date date = new Date();
        art.setDate(date);
        art.setBoard("Art");
        art.setPost(0);  
        artService.persist(art);
        return Response.ok(art.getId()).build();
    }
}
