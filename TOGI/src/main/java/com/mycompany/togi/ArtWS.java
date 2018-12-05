package com.mycompany.togi;

import static com.mycompany.togi.PoliticsWS.ccounter;
import static com.mycompany.togi.PoliticsWS.pcounter;
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

@Path("comments")
public class ArtWS {

    public static Integer pcounter = 0;
    public static Integer ccounter = 0;

    @Context
    private UriInfo context;
    @EJB
    private ArtService artService;

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized Response readArt() {

        List<Art> art = artService.selectItems();

        if (art == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(art).build();
    }
    
    @GET
    @Path("get2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized Response readArt2() {

        List<Art> art = artService.selectItems();

        if (art == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(art).build();
    }
    

    

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public synchronized Response createArt(Art art) {
        art.setId(Long.MIN_VALUE + Long.MAX_VALUE / 2);
        Board b = new Board();
        art.setCommentnum(b.getCommentnum());

        Date date = new Date();
        art.setDate(date);
        art.setBoard("Art");
        pcounter++;
        art.setPost(pcounter);
        ccounter++;
        artService.persist(art);
        return Response.ok(art.getId()).build();
    }
    @POST
    @Path("post2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public synchronized Response createArt2(Art art) {
         art.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
        art.setCommentnum(ccounter);
        ccounter++;
        art.setPost(pcounter);
        Date date = new Date();
        art.setDate(date);
        art.setBoard("Mathematics");
     
      
       artService.persist(art);
        return Response.ok(art.getId()).build();
    }
}
