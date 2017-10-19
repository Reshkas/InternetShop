package store.dao;

import store.dto.RoleUserDto;
import store.dto.UserDto;
import store.dto.LoginUserDto;
import store.model.User;

import java.util.List;


public interface UserDao {

    User getUserByLogin(String login);

    boolean addUser(LoginUserDto loginUserDto);

    boolean deleteUserByLogin(String login);

    boolean changeUserRoleByLogin(RoleUserDto roleUserDto);

    List<User> getAllUser ();
}
