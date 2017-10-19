package store.controller.servlets;

import store.dto.LoginUserDto;
import store.dto.RoleUserDto;
import store.exception.UserException;
import store.model.User;
import store.service.UserService;
import store.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

//@WebServlet(name = "login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login != null && password != null) {

            LoginUserDto loginUserDto = new LoginUserDto(login, password);

            UserService UserService = new UserServiceImpl();
            try {
                User user = UserService.getAuthorization(loginUserDto);

                RoleUserDto roleUserDto = new RoleUserDto(user.getRole(), user.getLogin());

                HttpSession session = req.getSession(true);
                session.setAttribute("login", login);
                session.setAttribute("role", String.valueOf(roleUserDto.getRole()));

                Cookie cookie = new Cookie("login", login);
                resp.addCookie(cookie);

                redirectByRole(roleUserDto, req, resp);

            } catch (UserException e) {

                req.getRequestDispatcher("/WEB-INF/views/authorization.jsp").forward(req, resp);
            }

        } else {
            req.getRequestDispatcher("/WEB-INF/views/authorization.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private void redirectByRole(RoleUserDto roleUserDto, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        switch (roleUserDto.getRole()) {
            case ADMIN: {

                req.getRequestDispatcher("/WEB-INF/views/admin/administrator_page.jsp").forward(req, resp);
                break;
            }
            case CUSTOMER: {
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
                break;
            }
            case MANAGER: {

                break;
            }
            default: {
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
            }
        }
    }
}
