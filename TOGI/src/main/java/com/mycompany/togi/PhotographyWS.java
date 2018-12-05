
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

@Path("pcomments")
public class PhotographyWS {
    public static int counter=0;

    @Context
    private UriInfo context;
    @EJB
    private PhotographyService photogService;

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPhotography() {

        List<Photography> photog = photogService.selectItems();
        

        if (photog == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(photog).build();
    }
    
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createPhotography(Photography photog) {  
        photog.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
        Board b=new Board();
        photog.setCommentnum(b.getCommentnum());
       
       
        Date date = new Date();
        photog.setDate(date);
        photog.setBoard("Photography");
        photog.setPost(1);  
        photogService.persist(photog);
        return Response.ok(photog.getId()).build();
    }
      public Response readphotography() {

        List<Photography> photog = photogService.selectItems();

        if (photog == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(photog).build();
    }



}
