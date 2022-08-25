package com.revature.sessionExample;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        // cast the object from the session to a string:
        String dinosaur = (String) session.getAttribute("dino");

        PrintWriter out = resp.getWriter();
        if(dinosaur == null) {
            out.println("Dinosaur not found!");
        }else {
            out.println("Your dinosaur is " + dinosaur);
        }
    }
}
