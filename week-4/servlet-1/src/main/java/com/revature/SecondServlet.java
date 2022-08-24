package com.revature;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

// The generic servlet is an abstract class, so it already implements the init, destroy, servlet info, and servlet config methods
// which means we only have to implement the service method
public class SecondServlet extends GenericServlet {
    // Because service is the only abstract method in GenericServlet, we only have to implement that:
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("This is the service method.");
    }
}
