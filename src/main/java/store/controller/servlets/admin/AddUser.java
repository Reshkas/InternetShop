package store.controller.servlets.admin;

import store.dto.LoginUserDto;
import store.exception.UserException;
import store.service.UserService;
import store.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "AddUser")
public class AddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (password.equals(confirmPassword)) {

            LoginUserDto loginUserDto = new LoginUserDto(login, password);

            UserService registrationUser = new UserServiceImpl();

            try {
                registrationUser.addUser(loginUserDto);

            } catch (UserException e) {
                request.setAttribute("message", e.getMessage());
            }

        } else {

            request.getRequestDispatcher("/registration").forward(request, response);
        }
        if (request.getSession(false).getAttribute("role") == "ADMIN") {

            request.setAttribute("message", "Пользователь с логином: " + login + " добавлен.");
            request.getRequestDispatcher("/adminPage").forward(request, response);

        } else {
            request.getRequestDispatcher("/authorization").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
