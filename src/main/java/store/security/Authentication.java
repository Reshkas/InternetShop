package store.security;

import store.util.DBConnector;
import store.model.Role;
import store.model.User;
import store.model.UserModel;
import org.apache.commons.codec.digest.DigestUtils;
import store.businesLogik.usersFactory.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {



    public void getAuthorization(User user) {

        DBConnector connectAuthentication = new DBConnector();

        String hashPassword = md5Apache(user.getPassword());

        connectAuthentication.init();

        ResultSet getCurrentPassword = connectAuthentication.query("SELECT password FROM users where login ='" + user.getLogin() + "'");

        System.out.println(getCurrentPassword);

        try {
            while (getCurrentPassword.next()) {

                String currentPassword = getCurrentPassword.getString("password");

                if (currentPassword.equals(hashPassword) & currentPassword != hashPassword) {

                    Authorization authorization = new Authorization();

                    user.setId(authorization.getUserId(user));

                    user.setRole(authorization.getUserRole(user));

                    UsersFactory usersFactory = createUsersByRole(user.getRole());
                    UserModel userA = usersFactory.createUser(user);

                    userA.writeHello();


                } else {

                    throw new RuntimeException("Неправильный пароль");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally{

            connectAuthentication.closeSqlConnect();
        }

    }

    static UsersFactory createUsersByRole(Role role){
        if(role == Role.ADMIN){
            return new AdministratorFactory();

        }else if(role == Role.MANAGER){
            return new ManagerFactory();

        }else if(role == Role.CUSTOMER){
            return new CustomerFactory();

        }else if(role == Role.GUEST){
            return new GuestFactory();

        }else{

            throw new RuntimeException("Недопустимая роль пользователя!");
        }

    }

    private static String md5Apache(String text) {
        return DigestUtils.md5Hex(text);
    }
}
