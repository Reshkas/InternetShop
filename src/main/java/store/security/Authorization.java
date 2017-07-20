package store.security;

import store.util.DBConnector;
import store.model.Role;
import store.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Authorization {

    private int userId;
    private String userRole;
    private Role role;

    public int getUserId(User user) {

        DBConnector connectAuthorization = new DBConnector();

        connectAuthorization.init();

        ResultSet getUserId = connectAuthorization.query("SELECT id FROM users WHERE login ='" + user.getLogin() + "'");

        try {
            while (getUserId.next()) {

                userId = getUserId.getInt("id");

                System.out.println("UserId = " + userId);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            connectAuthorization.closeSqlConnect();
        }

        return userId;
    }

    public Role getUserRole(User user) {

        DBConnector connectAuthorization = new DBConnector();

        connectAuthorization.init();

        ResultSet getUserRole = connectAuthorization.query("SELECT role FROM users WHERE login ='" + user.getLogin() + "'");

        try {
            while (getUserRole.next()) {

                userRole = getUserRole.getString("role");

                System.out.println(userRole);

                if (userRole.equals("ADMIN")) {
                    role = Role.ADMIN;

                } else if (userRole.equals("CUSTOMER")) {
                    role = Role.CUSTOMER;

                } else if (userRole.equals("MANAGER")) {
                    role = Role.MANAGER;

                } else if (userRole.equals("GUEST")) {
                    role = Role.GUEST;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            connectAuthorization.closeSqlConnect();
        }

        return role;
    }


}
