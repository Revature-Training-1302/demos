package com.revature;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// Since we are extending the HTTP Servlet, we can fill out the GET, POST, PUT, and DELETE methods:
public class ThirdServlet extends HttpServlet {

    // get methods are usually made to get some information
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        // get parameters from the request:
        String name = request.getParameter("name");
        System.out.println(name);

        System.out.println("GET request was called!");
        // we use the response to return data/info from this request
        response.setContentType("text/html"); // this is saying that we're expecting some html code in response
        // get the writer from the response (in other words, whatever we write using this writer, will be displayed as the response
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello from Servlet 3</h1>");
        out.println(new Date());
    }

    // post methods usually let us insert or add new data to the database
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("POST method was called");
    }
}
