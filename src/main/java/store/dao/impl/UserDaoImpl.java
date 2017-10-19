package store.dao.impl;

import store.dao.UserDao;
import store.dto.LoginUserDto;
import store.dto.RoleUserDto;
import store.model.Role;
import store.model.User;
import store.util.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl instance;

    private UserDaoImpl() {

    }

    public static UserDaoImpl getInstance() {

        if (instance == null) {

            instance = new UserDaoImpl();
        }
        return instance;
    }

    private DBConnector connectDB = DBConnector.init();

    @Override
    public User getUserByLogin(String login) {

        int userId;
        String userLogin;
        String userPassword;
        Role userRole;

        try (PreparedStatement preparedStatement = connectDB.getSqlConnect().prepareStatement(
                "SELECT * FROM users WHERE login = ?")) {
            preparedStatement.setString(1, login);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    userId = resultSet.getInt("id");
                    userLogin = resultSet.getString("login");
                    userPassword = resultSet.getString("password");
                    userRole = Role.valueOf(resultSet.getString("role"));

                    return new User(userId, userLogin, userPassword, userRole);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser(LoginUserDto loginUserDto) {

        try (PreparedStatement preparedStatement = connectDB.getSqlConnect().prepareStatement(
                "INSERT INTO users VALUES (DEFAULT ,?,?,'CUSTOMER')")) {

            preparedStatement.setString(1, loginUserDto.getLogin());
            preparedStatement.setString(2, loginUserDto.getPassword());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUserByLogin(String login) {

        try (PreparedStatement preparedStatement = connectDB.getSqlConnect().prepareStatement(
                "DELETE FROM users WHERE login = ? ")) {
            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean changeUserRoleByLogin(RoleUserDto roleUserDto) {

        try (PreparedStatement preparedStatement = connectDB.getSqlConnect().prepareStatement(
                "UPDATE users SET role = ? WHERE login = ?")) {
            preparedStatement.setString(1, String.valueOf(roleUserDto.getRole()));
            preparedStatement.setString(2, roleUserDto.getLogin());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {

        int userId;
        String userLogin;
        String userPassword;
        Role userRole;

        List<User> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = connectDB.getSqlConnect().prepareStatement(
                "SELECT * FROM users")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    userId = resultSet.getInt("id");
                    userLogin = resultSet.getString("login");
                    userPassword = resultSet.getString("password");
                    userRole = Role.valueOf(resultSet.getString("role"));

                    User user = new User(userId, userLogin, userPassword, userRole);

                    list.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
