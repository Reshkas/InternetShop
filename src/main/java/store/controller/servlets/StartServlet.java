package store.controller.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("servlet2")
public class StartServlet extends DispatcherServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        if (req.getParameter("enter") != null) {
            super.forward("/login", req, resp);
        }
        else if (req.getParameter("register") != null) {
            super.forward("/registration", req, resp);
        }
        else if (req.getParameter("home") != null) {
            super.forward("/index.jsp", req, resp);
        }
    }
}
