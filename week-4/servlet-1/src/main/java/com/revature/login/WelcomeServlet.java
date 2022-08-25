package com.revature.login;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            // Access cookies, now that we have cookies stored, let's try to access them:
            // first, we get the cookies from the request:
            Cookie[] cookies = req.getCookies();
            out.println("<h1>Welcome, " + cookies[0].getValue() + "</h1>");
        } catch(Exception e) {
            out.println("Please login first");
        }
    }
}
