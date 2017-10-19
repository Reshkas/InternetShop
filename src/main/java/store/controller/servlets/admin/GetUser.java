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

//@WebServlet(name = "GetUser")
public class GetUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");

        UserService findUser = new UserServiceImpl();

        try {
            List<UserDto> userList = findUser.getUserByLogin(login);
            for (UserDto user : userList) {

                UserDto userDto = new UserDto(user.getId(), user.getLogin(), user.getRole());

                request.setAttribute("userByLogin", userDto);
                request.setAttribute("userList", userList);
                request.setAttribute("message", "Пользователь найден.");
            }
        } catch (UserException e) {

            request.setAttribute("message", e.getMessage());
        } finally {

            request.getRequestDispatcher("/adminPage").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
}
