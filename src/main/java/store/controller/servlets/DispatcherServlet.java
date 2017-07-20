package store.controller.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    protected void forward(String to, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(to);

        dispatcher.forward(req, resp);
    }
}
