/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


public class GamesWS {

    @Context
    private UriInfo context;
    @EJB
    private GamesService gamesservice;

    @GET
   
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readArt() {

        List<Games> games = gamesservice.selectItems();
        

        if (games == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(games).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createGames(Games game) {  
       
        Board b=new Board();
        game.setCommentnum(b.getCommentnum());
        Integer postnum=game.getCommentnum();

        Date date = new Date();
        game.setDate(date);
        game.setBoard("Games");
        game.setPost(postnum);  
        gamesservice.persist(game);
        return Response.ok(game.getId()).build();
    }
}
