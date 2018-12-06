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

@Path("threads")
public class PostWS {

    public static Integer pcounter = 0;
    public static Integer ccounter = 0;

    @Context
    private UriInfo context;
    @EJB
    private PostService postService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPost() {
        List<Post> post = postService.selectItems();

        if (post == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(post).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createPost(Post post) {
        post.setId(Long.MIN_VALUE + Long.MAX_VALUE / 2);
        Board b = new Board();
        post.setCommentnum(b.getCommentnum());
        Date date = new Date();
        post.setDate(date);
        post.setBoard(b.getCurrentboard());
        pcounter++;
        post.setPost(pcounter);
        ccounter++;
        postService.persist(post);
        return Response.ok(post.getId()).build();
    }
}
