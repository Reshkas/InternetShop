package store.controller.filter;

import store.service.SecurityService;
import store.service.impl.SecurityServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "RoleFilter")
public class RoleFilter implements Filter {

    private boolean status;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.status = Boolean.parseBoolean(filterConfig.getInitParameter("status"));
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;

        String role = "null";

        if (status) {

            String path = request.getRequestURI();

            HttpSession session = request.getSession(false);

            if (session != null) {

                role = String.valueOf(session.getAttribute("role"));
            }

            SecurityService checkAccess = new SecurityServiceImpl();

            if (!checkAccess.accessCheck(path, role)) {

                switch (role) {

                    case "null":
                        req.getRequestDispatcher("/authorization").forward(req, resp);
                        break;

                    case "ADMIN":
                        req.getRequestDispatcher("/adminPage").forward(req, resp);
                }
            }
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
        this.status = false;
    }
}
