/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.togi;

import com.mycompany.togi.Board;
import com.mycompany.togi.Games;
import com.mycompany.togi.GamesService;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("gcomments")
public class GamesWS {

    @Context
    private UriInfo context;
    @EJB
    private GamesService gamesservice;

    @GET
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readgames() {

        List<Games> games = gamesservice.selectItems();

        if (games == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(games).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createGames(Games games) {
        games.setId(Long.MIN_VALUE + Long.MAX_VALUE / 2);
        Board b = new Board();
        games.setCommentnum(b.getCommentnum());
        Integer postnum = games.getCommentnum();

        Date date = new Date();
        games.setDate(date);
        games.setBoard("Games");
        games.setPost(postnum);
        gamesservice.persist(games);
        return Response.ok(games.getId()).build();
    }

}
