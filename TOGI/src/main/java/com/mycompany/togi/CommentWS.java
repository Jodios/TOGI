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

@Path("comments")
public class CommentWS {

    public static Integer ccounter = 0;

    @Context
    private UriInfo context;
    @EJB
    private CommentService commentService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readComment() {

        List<Comment> comment = commentService.selectItems();

        if (comment == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(comment).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createComment(Comment comment) {
        comment.setId(Long.MIN_VALUE + Long.MAX_VALUE / 2);
    
        PostWS.ccounter++;
        comment.setCommentnum(PostWS.ccounter);
        Date date = new Date();
        comment.setDate(date);

        
        commentService.persist(comment);
        return Response.ok(comment.getId()).build();
    }
}
