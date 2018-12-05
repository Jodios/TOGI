
package com.mycompany.togi;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("polcomments")
public class PoliticsWS {
    public static Integer counter=0;

    @Context
    private UriInfo context;
    @EJB
    private PoliticsService politicsService;

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPolitics() {

        List<Politics> pol = politicsService.selectItems();
        

        if (pol == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(pol).build();
    }
    
    @GET
    @Path("get2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPolitics2() {

        List<Politics> pol = politicsService.selectItems();
        

        if (pol == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(pol).build();
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createPolitics(Politics pol) {  
        
        pol.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
        Board board=new Board();
        pol.setCommentnum(board.getCommentnum());
        Integer i=board.getCommentnum()+1;
        board.setCommentnum(i);       
     
        Date date = new Date();
        pol.setDate(date);
        pol.setBoard("Politics");
        pol.setPost(counter);  

        counter++;
        politicsService.persist(pol);
        return Response.ok(pol.getId()).build();
    }
      @POST
    @Path("post2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createPolitics2(Politics pol) {  
        
        pol.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
        Board board=new Board();
        pol.setCommentnum(board.getCommentnum());
        Integer i=board.getCommentnum()+1;
        board.setCommentnum(i);       
     
        Date date = new Date();
        pol.setDate(date);
        pol.setBoard("Politics");
        pol.setPost(Politics.pcounter);
        politicsService.persist(pol);
        return Response.ok(pol.getId()).build();
    }

}
