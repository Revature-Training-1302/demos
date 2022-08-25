package com.revature.sessionExample;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DinosaurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // create an HTTP Session
        HttpSession session = req.getSession();

        // pass in a dinosaur as the request parameter:
        String dinosaur = req.getParameter("dino");

        // set the attribute of the session (key-value pairs):
        session.setAttribute("dino", dinosaur);

        resp.sendRedirect("/display");
    }
}
