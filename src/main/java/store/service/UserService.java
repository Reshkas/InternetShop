package store.service;

import store.dto.LoginUserDto;
import store.dto.RoleUserDto;
import store.dto.UserDto;
import store.exception.UserException;
import store.model.User;

import java.util.List;

public interface UserService {

    boolean changeUserRoleByLogin(RoleUserDto roleUserDto) throws UserException;

    boolean deleteUserByLogin(String login) throws UserException;

    List<UserDto> getAllUser() throws UserException;

    List<UserDto> getUserByLogin(String login) throws UserException;

    boolean addUser(LoginUserDto loginUserDto) throws UserException;

    User getAuthorization(LoginUserDto loginUserDto)throws UserException;
}
