
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

@Path("mathcomments")
public class MathematicsWS {
    public static int counter=0;

    @Context
    private UriInfo context;
    @EJB
    private MathematicsService mathService;

    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response readMathematics() {

        List<Mathematics> math = mathService.selectItems();
        

        if (math == null) {
            return Response.status(Status.NO_CONTENT).build();
        }
        return Response.ok(math).build();
    }
    
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createMathematics(Mathematics math) {  
        math.setId(Long.MIN_VALUE+Long.MAX_VALUE/2);
        Board b=new Board();
        math.setCommentnum(b.getCommentnum());
       
       
        Date date = new Date();
        math.setDate(date);
        math.setBoard("Mathematics");
        math.setPost(1);  
        mathService.persist(math);
        return Response.ok(math.getId()).build();
    }



}
