package com.revature.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // getting a writer from the response, so whenever we write to this response, we're writing to the browser/postman
        PrintWriter out = resp.getWriter();

        // get our username and password
        // to keep it simple, we'll just get them from request parameters
        // in practice, this is bad form because you don't want the sensitive data to be displayed on the address
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // hard-code in the credentials for testing:
        if(username.equals("admin") && password.equals("123")) {
            out.println("<h1>Login Successful!</h1>");
            out.println("<h2>username: " + username + "</h2>");
            out.println("<h2>password: " + password + "</h2>");

            // Work with cookies:
            // Create a cookie with a name and the value:
            Cookie cookie = new Cookie("username", username);


            // add cookie to the response:
            resp.addCookie(cookie);

            // now that the data is stored as a cookie, we can redirect to index page (/):
            RequestDispatcher rd = req.getRequestDispatcher("/welcome");
            // if we include, we are going to pass along the current resources
//            rd.include(req, resp);
            // forward doesn't include the current resources
            rd.forward(req, resp);
        }
        else {
            out.print("<h1>Login Unsuccessful!</h1>");
        }





    }
}
