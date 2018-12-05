
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
   public static Integer pcounter = 0;
    public static Integer ccounter = 0;


    @Context
    private UriInfo context;
    @EJB
    private PhotographyService photoService;

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPhoto() {

        List<Photography> photo = photoService.selectItems();
        

        if (photo == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(photo).build();
    }
      @GET
    @Path("get2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPhoto2() {

       List<Photography> photo = photoService.selectItems();
        

        if (photo == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(photo).build();
    }
    
    
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createPhoto(Photography photo) {
     photo.setId(Long.MIN_VALUE + Long.MAX_VALUE / 2);
        Board b = new Board();
        photo.setCommentnum(b.getCommentnum());

        Date date = new Date();
        photo.setDate(date);
        photo.setBoard("Photography");
        pcounter++;
        photo.setPost(pcounter);
        ccounter++;
        photoService.persist(photo);
        return Response.ok(photo.getId()).build();
    }
     @POST
    @Path("post2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createPhoto2(Photography photo) {
        photo.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
        photo.setCommentnum(ccounter);
        ccounter++;
        photo.setPost(pcounter);
        Date date = new Date();
        photo.setDate(date);
        photo.setBoard("Photography");
     
      
      photoService.persist(photo);
        return Response.ok(photo.getId()).build();
    }
     
}
