/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.togi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jortiz
 */
@WebServlet(name = "mainServlet", urlPatterns = {"/mainServlet"})
public class mainServlet extends HttpServlet {

    Queue comments = new ConcurrentLinkedQueue();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("comment");
        comments.add(name);
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>GuestBookServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<ol>");
            Iterator commentIterator = comments.iterator();
            while (commentIterator.hasNext()) {
                out.print("<b>Comment: </b>" + commentIterator.next());
            }
            out.println("</o1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
