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

@WebServlet(name = "Comment List", urlPatterns = {"/commentList"})
public class mainServlet extends HttpServlet {

    Queue comments = new ConcurrentLinkedQueue();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String image = req.getParameter("image");

        String comment = req.getParameter("comment");
        String info = image;
        info = info + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + comment;
        synchronized (comments) {
            while (comments.size() > 9) {
                comments.remove();
            }
        }
        comments.add(info);
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter pout = resp.getWriter()) {
            pout.println("<!DOCTYPE html>");
            pout.println("<html>");
            pout.println("<head>");
            pout.println("<title>Guest List</title>");
            pout.println("</head>");
            pout.println("<body>");
            pout.println("<h1>Most recent guests.</h1>");
            pout.println("<ol>");
            for (Object item : comments) {
                pout.println("<li>" + item + "</li>");
            }
            pout.println("</ol>");
            pout.println("</body>");
            pout.println("</html>");
        }
    }
}
