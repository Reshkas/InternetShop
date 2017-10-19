package store.controller.servlets.admin;

import store.exception.UserException;
import store.service.UserService;
import store.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "DeleteUserService")
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");

        if (login != null) {
//            DeleteUserService deleteUserService = new DeleteUserService();

            UserService deleteUserService = new UserServiceImpl();
            try {
                deleteUserService.deleteUserByLogin(login);
            } catch (UserException e) {
                request.setAttribute("message", e.getMessage());
            }
        } else {
            request.getRequestDispatcher("/formDeleteUser").forward(request, response);
        }
        request.setAttribute("message", "Пользователь с логином: " + login + " удален.");
        request.getRequestDispatcher("/adminPage").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
