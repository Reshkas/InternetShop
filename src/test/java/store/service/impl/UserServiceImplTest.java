package store.service.impl;

import org.junit.Test;
import store.dao.UserDao;
import store.dao.impl.UserDaoImpl;
import store.dto.LoginUserDto;
import store.dto.RoleUserDto;
import store.dto.UserDto;
import store.exception.UserException;
import store.model.Role;
import store.model.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @Test
    public void getAuthorization_Correct() throws Exception {
        //Given
        User user = new User(59, "login", "d56b699830e77ba53855679cb1d252da", Role.CUSTOMER);
        LoginUserDto loginUserDto = new LoginUserDto("login", "login");
        UserDao userDao = mock(UserDaoImpl.class);

        //When
        when(userDao.getUserByLogin("login")).thenReturn(user);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        User returnUser = userService.getAuthorization(loginUserDto);

        //Then
        assertEquals(user, returnUser);
        assertEquals(user.getPassword(), returnUser.getPassword());
    }

    @Test(expected = UserException.class)
    public void getAuthorization_Exception() throws Exception {
        //Given
        LoginUserDto loginUserDto = new LoginUserDto("login", "login");
        UserDao userDao = mock(UserDaoImpl.class);

        //When
        when(userDao.getUserByLogin("login")).thenReturn(null);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        userService.getAuthorization(loginUserDto);

        //Then
    }

    @Test(expected = UserException.class)
    public void getAuthorization_WrongPassword() throws Exception {
        //Given
        User user = new User(59, "login", "d56b699830e77ba53855679cb1d252da", Role.CUSTOMER);
        LoginUserDto loginUserDto = new LoginUserDto("login", "password");

        UserDao userDao = mock(UserDaoImpl.class);

        //When
        when(userDao.getUserByLogin("login")).thenReturn(user);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        userService.getAuthorization(loginUserDto);

        //Then
    }

    @Test
    public void changeUserRoleByLogin() throws Exception {
        //Given
        User user = new User(59, "login", "d56b699830e77ba53855679cb1d252da", Role.CUSTOMER);
        RoleUserDto roleUserDto = new RoleUserDto(Role.CUSTOMER, "login");
        UserDao userDao = mock(UserDaoImpl.class);

        //When
        when(userDao.changeUserRoleByLogin(roleUserDto)).thenReturn(true);
        when(userDao.getUserByLogin("login")).thenReturn(user);

        UserServiceImpl userServiceImpl = new UserServiceImpl(userDao);
        Boolean status = userServiceImpl.changeUserRoleByLogin(roleUserDto);

        //Then
        assertTrue(status);
    }

    @Test(expected = UserException.class)
    public void changeUserRoleByLogin_Exception() throws Exception {
        //Given
        RoleUserDto roleUserDto = new RoleUserDto(Role.CUSTOMER, "login");
        UserDao userDao = mock(UserDaoImpl.class);

        //When
        when(userDao.changeUserRoleByLogin(roleUserDto)).thenReturn(true);
        when(userDao.getUserByLogin("login")).thenReturn(null);

        UserServiceImpl userServiceImpl = new UserServiceImpl(userDao);
        userServiceImpl.changeUserRoleByLogin(roleUserDto);

        //Then
    }

    @Test
    public void deleteUserByLogin_Correct() throws Exception {
        //Given
        User user = new User(59, "login", "d56b699830e77ba53855679cb1d252da", Role.CUSTOMER);
        UserDao userDao = mock(UserDaoImpl.class);

        //When
        when(userDao.deleteUserByLogin("login")).thenReturn(true);
        when(userDao.getUserByLogin("login")).thenReturn(user);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        boolean status = userService.deleteUserByLogin("login");

        //Then
        assertTrue(status);
        assertEquals(user,userDao.getUserByLogin("login"));
    }

    @Test(expected = UserException.class)
    public void deleteUserByLogin_Exception() throws Exception {
        //Given
        UserDao userDao = mock(UserDaoImpl.class);

        //When
        when(userDao.deleteUserByLogin("login")).thenReturn(true);
        when(userDao.getUserByLogin("login")).thenReturn(null);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        userService.deleteUserByLogin("login");

        //Then
        assertEquals(null,userDao.getUserByLogin("login"));
    }

    @Test
    public void getAllUser_Correct() throws Exception {
        //Given
        UserDto userDto = new UserDto(59, "login", Role.CUSTOMER);
        UserDto userDto1 = new UserDto(57,	"l4",	Role.ADMIN);

        User user = new User(59, "login", "d56b699830e77ba53855679cb1d252da", Role.CUSTOMER);
        User user1 = new User(57,	"l4",	"bdc1fe47d872145348d3bc922de53172",	Role.ADMIN);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);

        UserDao userDao = mock(UserDaoImpl.class);

        //When
        when(userDao.getAllUser()).thenReturn(userList);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        List<UserDto> testUserList = userService.getAllUser();
        int testListSize = testUserList.size();

        //Then
        assertEquals(2,testListSize);
        assertEquals(userDto, testUserList.get(0));
        assertEquals(userDto1, testUserList.get(1));
    }

    @Test(expected = UserException.class)
    public void getAllUser_Exception() throws Exception {
        //Given
        List<User> userList = new ArrayList<>();

        UserDao userDao = mock(UserDaoImpl.class);

        //When
        when(userDao.getAllUser()).thenReturn(userList);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        userService.getAllUser();

        //Then
    }

    @Test
    public void getUserByLogin_Correct() throws Exception {
        //Given
        List<UserDto> userList = new ArrayList<>();
        User user = new User(59, "login", "d56b699830e77ba53855679cb1d252da", Role.CUSTOMER);
        UserDto userDto = new UserDto(59, "login", Role.CUSTOMER);
        userList.add(userDto);

        UserDao userDao = mock(UserDaoImpl.class);

        //When
        when(userDao.getUserByLogin("login")).thenReturn(user);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        List<UserDto> testUserList = userService.getUserByLogin("login");

        //Then
        assertNotNull(testUserList);
        assertNotNull(testUserList.get(0));
        assertEquals(1, testUserList.size());
        assertEquals(userDto, testUserList.get(0));
    }

    @Test(expected = UserException.class)
    public void getUserByLogin_Exception() throws Exception {
        //Given
        UserDao userDao = mock(UserDao.class);

        //When
        when(userDao.getUserByLogin("login")).thenReturn(null);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        userService.getUserByLogin("login");

        //Then
    }

    @Test
    public void addUser_Correct() throws Exception {
        //Given
        LoginUserDto loginUserDto = new LoginUserDto("login", "login");

        UserDao userDao = mock(UserDaoImpl.class);

        //When

        when(userDao.getUserByLogin(loginUserDto.getLogin())).thenReturn(null);
        when(userDao.addUser(loginUserDto)).thenReturn(true);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        boolean status = userService.addUser(loginUserDto);

        //Then
        assertTrue(status);
        verify(userDao, atLeastOnce()).addUser(loginUserDto);
        verify(userDao, times(1)).addUser(loginUserDto);
    }

    @Test(expected = UserException.class)
    public void addUser_Exception() throws Exception {
        //Given
        User user = new User(59, "login", "d56b699830e77ba53855679cb1d252da", Role.CUSTOMER);
        LoginUserDto loginUserDto = new LoginUserDto("login", "login");

        UserDao userDao = mock(UserDaoImpl.class);

        //When

        when(userDao.getUserByLogin(loginUserDto.getLogin())).thenReturn(user);
        when(userDao.addUser(loginUserDto)).thenReturn(true);

        UserServiceImpl userService = new UserServiceImpl(userDao);
        userService.addUser(loginUserDto);

        //Then
    }
}