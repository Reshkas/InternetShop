package store.controller.servlets.admin;

import store.dto.UserDto;
import store.exception.UserException;
import store.service.UserService;
import store.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//@WebServlet(name = "GetAllUsers")
public class GetAllUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UserDto> userList = null;

        UserService getAllUsers = new UserServiceImpl();

        try {
            userList = getAllUsers.getAllUser();

            request.setAttribute("message", "Список всех зарегистрированных пользователей.");

        } catch (UserException e) {

            request.setAttribute("message", e.getMessage());
        }
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/adminPage").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
