package store.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import store.dao.UserDao;
import store.dao.impl.UserDaoImpl;
import store.dto.LoginUserDto;
import store.dto.RoleUserDto;
import store.dto.UserDto;
import store.exception.UserException;
import store.model.User;
import store.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = UserDaoImpl.getInstance();
    }

    UserServiceImpl(UserDao userDao) {

        this.userDao = userDao;
    }

    public User getAuthorization(LoginUserDto loginUserDto) throws UserException {

        User user;

        String hashPassword = md5Apache(loginUserDto.getPassword());

        User userByLogin = userDao.getUserByLogin(loginUserDto.getLogin());

        if (userByLogin != null) {

            String currentPassword = userByLogin.getPassword();

            if (currentPassword.equals(hashPassword)) {

                user = userByLogin;

            } else {
                throw new UserException("Неправильный пароль");
            }
        } else {
            throw new UserException("Пользователя с таким логином не сушествует");
        }
        return user;
    }

    public boolean changeUserRoleByLogin(RoleUserDto roleUserDto) throws UserException {

        if (checkUser(roleUserDto.getLogin())) {

            return userDao.changeUserRoleByLogin(roleUserDto);
        } else {
            throw new UserException("Пользователь с таким логином не найден");
        }
    }

    public boolean deleteUserByLogin(String login) throws UserException {

        if (checkUser(login)) {

            return (userDao.deleteUserByLogin(login));
        } else {
            throw new UserException("Пользователь с таким логином не найден");
        }
    }

    public List<UserDto> getAllUser() throws UserException {

        List<UserDto> usersDtoList = new ArrayList<>();
        List<User> usersList;

        usersList = userDao.getAllUser();

        if (usersList.size() != 0) {
            for (User user : usersList) {
                UserDto userDto = new UserDto(user.getId(), user.getLogin(), user.getRole());
                usersDtoList.add(userDto);
            }
            return usersDtoList;
        } else {
            throw new UserException("Нет зарегистрированных пользователей.");
        }
    }

    public List<UserDto> getUserByLogin(String login) throws UserException {

        List<UserDto> usersList = new ArrayList<>();

        User user = userDao.getUserByLogin(login);

        if (user != null) {

            UserDto userDto = new UserDto(user.getId(), user.getLogin(), user.getRole());

            usersList.add(userDto);
        } else {
            throw new UserException("Пользователя с таким логином не существует.");
        }
        return usersList;
    }

    public boolean addUser(LoginUserDto loginUserDto) throws UserException {

        if (checkUser(loginUserDto.getLogin())) {

            throw new UserException("Пользователь с таким логином уже существует.");
        } else {
            String password = md5Apache(loginUserDto.getPassword());
            loginUserDto.setPassword(password);

            return userDao.addUser(loginUserDto);
        }
    }

    private boolean checkUser(String login) {

        return (userDao.getUserByLogin(login) != null);
    }

    private static String md5Apache(String text) {
        return DigestUtils.md5Hex(text);
    }
}
