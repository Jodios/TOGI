
package com.mycompany.togi;

import static com.mycompany.togi.PoliticsWS.ccounter;
import static com.mycompany.togi.PoliticsWS.pcounter;
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

@Path("gcomments")
public class GamesWS {
     public static Integer pcounter=0;
     public static Integer ccounter=0;

    @Context
    private UriInfo context;
    @EJB
    private GamesService gamesService;
    
    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readGames() {

        List<Games> games = gamesService.selectItems();
        

        if (games == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(games).build();
    }
     @GET
    @Path("get2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readGames2() {

        List<Games> games = gamesService.selectItems();
        

        if (games == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(games).build();
    }
    
    
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createGames(Games games) {  
             games.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
       
        pcounter++;
        games.setPost(pcounter);
      
        Date date = new Date();
        games.setDate(date);
        games.setBoard("Games");
        games.setCommentnum(ccounter);
        ccounter++;


       gamesService.persist(games);
        return Response.ok(games.getId()).build();
    }
      @POST
    @Path("post2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createGames2(Games games) {  
    games.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
        games.setCommentnum(ccounter);
        ccounter++;
        games.setPost(pcounter);
        Date date = new Date();
        games.setDate(date);
        games.setBoard("Games");
   
      
        gamesService.persist(games);
        return Response.ok(games.getId()).build();
    }
    



}
