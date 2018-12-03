package com.mycompany.togi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BoardServlet", urlPatterns = {"/boardservlet"})
public class BoardServlet extends HttpServlet {

    ArrayList<testcomment> comments = new ArrayList<>();
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
                
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            comments.add(new testcomment("novemer", "test", 00000001));
            comments.add(new testcomment("novemer", "test", 00000002));
            comments.add(new testcomment("novemer", "test", 00000003));
            comments.add(new testcomment("novemer", "test", 00000004));
            comments.add(new testcomment("novemer", "test", 00000005));
            comments.add(new testcomment("novemer", "test", 00000006));
            comments.add(new testcomment("novemer", "test", 00000007));
            for(int i = 0; i < comments.size(); i++){
                out.print(comments.get(i).getId() + "-");
                System.out.println("HELLO");
            }
            
        }
        
    }
    


}









