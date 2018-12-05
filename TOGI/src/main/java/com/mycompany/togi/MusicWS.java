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

@Path("mucomments")
public class MusicWS {

    public static Integer pcounter = 0;
    public static Integer ccounter = 0;

    @Context
    private UriInfo context;
    @EJB
    private MusicService musicService;

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readMusic() {

        List<Music> music = musicService.selectItems();

        if (music == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(music).build();
    }

    @GET
    @Path("get2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readMusic2() {

        List<Music> music = musicService.selectItems();

        if (music == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(music).build();
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createMusic(Music music) {
        Board b = new Board();
        music.setCommentnum(b.getCommentnum());

        Date date = new Date();
        music.setDate(date);
        music.setBoard("Music");
        pcounter++;
        music.setPost(pcounter);
        ccounter++;
        musicService.persist(music);
        return Response.ok(music.getId()).build();
    }

    @POST
    @Path("post2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createMusic2(Music music) {
        music.setId(Long.MIN_VALUE + Long.MAX_VALUE / 2);
        music.setCommentnum(ccounter);
        ccounter++;
        music.setPost(pcounter);
        Date date = new Date();
        music.setDate(date);
        music.setBoard("Music");

        musicService.persist(music);
        return Response.ok(music.getId()).build();
    }

}
