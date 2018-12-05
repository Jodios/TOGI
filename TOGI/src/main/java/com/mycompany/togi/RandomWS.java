
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

@Path("randcomments")
public class RandomWS {
  public static Integer pcounter = 0;
    public static Integer ccounter = 0;


    @Context
    private UriInfo context;
    @EJB
    private RandomService randomService;

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readRandom() {

        List<Random> random = randomService.selectItems();
        

        if (random == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(random).build();
    }
      @GET
    @Path("get2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readRandom2() {

        List<Random> rand = randomService.selectItems();
        

        if (rand == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(rand).build();
    }
    
    
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createRandom(Random rand) {
      rand.setId(Long.MIN_VALUE + Long.MAX_VALUE / 2);
        Board b = new Board();
        rand.setCommentnum(b.getCommentnum());

        Date date = new Date();
        rand.setDate(date);
        rand.setBoard("Random");
        pcounter++;
        rand.setPost(pcounter);
        ccounter++;
        randomService.persist(rand);
        return Response.ok(rand.getId()).build();
    }
     @POST
    @Path("post2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createTechnology2(Random rand) {
        rand.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
        rand.setCommentnum(ccounter);
        ccounter++;
        rand.setPost(pcounter);
        Date date = new Date();
        rand.setDate(date);
        rand.setBoard("Random");
     
      
      randomService.persist(rand);
        return Response.ok(rand.getId()).build();
    }
     





}
