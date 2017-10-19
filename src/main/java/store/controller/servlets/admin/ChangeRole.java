package store.controller.servlets.admin;

import store.dto.RoleUserDto;
import store.exception.UserException;
import store.model.Role;
import store.service.UserService;
import store.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "ChangeRole")
public class ChangeRole extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        Role role = Role.valueOf(request.getParameter("role").toUpperCase());

        if (login != null && role != null) {
            RoleUserDto roleUserDto = new RoleUserDto(role, login);

            UserService changeUserRoleService = new UserServiceImpl();

//            ChangeUserRoleService  = new ChangeUserRoleService();

            try {
                changeUserRoleService.changeUserRoleByLogin(roleUserDto);

            } catch (UserException e) {
                request.setAttribute("message", e.getMessage());
            }
            request.setAttribute("message", "Роль пользователя с логином: " + login + " изменена.");
            request.getRequestDispatcher("/adminPage").forward(request, response);
        } else {

            request.getRequestDispatcher("/formChangeUserRole").forward(request, response);
            request.setAttribute("message", "Пользователь найден.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
