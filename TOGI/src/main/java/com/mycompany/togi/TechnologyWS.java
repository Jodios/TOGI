
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

@Path("techcomments")
public class TechnologyWS {
    public static int counter=0;

    @Context
    private UriInfo context;
    @EJB
    private TechnologyService techService;

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTechnology() {

        List<Technology> tech = techService.selectItems();
        

        if (tech == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(tech).build();
    }
    
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createTechnology(Technology tech) {  
        tech.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
        Board b=new Board();
        tech.setCommentnum(b.getCommentnum());
       
       
        Date date = new Date();
        tech.setDate(date);
        tech.setBoard("Photography");
        tech.setPost(1);  
        techService.persist(tech);
        return Response.ok(tech.getId()).build();
    }
      public Response readtechnology() {

        List<Technology> tech = techService.selectItems();

        if (tech == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(tech).build();
    }



}
