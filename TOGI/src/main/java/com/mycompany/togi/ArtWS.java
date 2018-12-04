
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
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readArt() {

        List<Art> art = artService.selectItems();
        

        if (art == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(art).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createArt(Art art) {  
        art.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
        Board b=new Board();
         art.setCommentnum(b.getCommentnum());
        Integer i=b.getCommentnum()+1;
         b.setCommentnum(i);
       
        
        
       
        Date date = new Date();
        art.setDate(date);
        art.setBoard("Art");
        art.setPost(1);  
        artService.persist(art);
        return Response.ok(art.getId()).build();
    }

}
