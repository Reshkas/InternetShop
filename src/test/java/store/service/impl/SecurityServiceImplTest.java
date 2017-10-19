package store.service.impl;

import org.junit.Test;
import store.service.SecurityService;

import static org.junit.Assert.*;

public class SecurityServiceImplTest {

    @Test
    public void accessCheck_Case_1() throws Exception {
        //Given
        String roleTrue = "null";
        String roleFalse = "ADMIN";
        String path = "/store/";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_2() throws Exception {
        //Given
        String roleTrue = "null";
        String roleFalse = "ADMIN";
        String path = "/store/login";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_3() throws Exception {
        //Given
        String roleTrue = "ADMIN";
        String roleFalse = "CUSTOMER";
        String path = "/store/logout";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_4() throws Exception {
        //Given
        String roleTrue = "null";
        String roleFalse = "ADMIN";
        String path = "/store/authorization";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_5() throws Exception {
        //Given
        String roleTrue = "null";
        String roleFalse = "ADMIN";
        String path = "/store/registration";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_6() throws Exception {
        //Given
        String roleTrue = "null";
        String roleFalse = "ADMIN";
        String path = "/store/home";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_7() throws Exception {
        //Given
        String roleTrue = "ADMIN";
        String roleFalse = "CUSTOMER";
        String path = "/store/adminPage";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);


        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_8() throws Exception {
        //Given
        String roleTrue = "ADMIN";
        String roleFalse = "CUSTOMER";
        String path = "/store/findUser";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_9() throws Exception {
        //Given
        String roleAdmin = "ADMIN";
        String roleNull = "null";
        String roleCustomer = "CUSTOMER";
        String path = "/store/addUser";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testRoleAdmin = securityService.accessCheck(path, roleAdmin);
        boolean testRoleNull = securityService.accessCheck(path, roleNull);
        boolean testSecurityService = securityService.accessCheck(path, roleCustomer);

        //Then
        assertTrue(testRoleAdmin);
        assertTrue(testRoleNull);
        assertFalse(testSecurityService);
    }

    @Test
    public void accessCheck_Case_10() throws Exception {
        //Given
        String roleTrue = "ADMIN";
        String roleFalse = "CUSTOMER";
        String path = "/store/deleteUser";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_11() throws Exception {
        //Given
        String roleTrue = "ADMIN";
        String roleFalse = "CUSTOMER";
        String path = "/store/changeRole";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_12() throws Exception {
        //Given
        String roleTrue = "ADMIN";
        String roleFalse = "CUSTOMER";
        String path = "/store/getAllUsers";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_13() throws Exception {
        //Given
        String roleTrue = "ADMIN";
        String roleFalse = "CUSTOMER";
        String path = "/store/formAddUser";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_14() throws Exception {
        //Given
        String roleTrue = "ADMIN";
        String roleFalse = "CUSTOMER";
        String path = "/store/formChangeUserRole";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_15() throws Exception {
        //Given
        String roleTrue = "ADMIN";
        String roleFalse = "CUSTOMER";
        String path = "/store/formDeleteUser";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_16() throws Exception {
        //Given
        String roleTrue = "ADMIN";
        String roleFalse = "CUSTOMER";
        String path = "/store/formFindUser";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(path, roleTrue);
        boolean testFalse = securityService.accessCheck(path, roleFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }

    @Test
    public void accessCheck_Case_default() throws Exception {
        //Given
        String fileTrue = "jpg";
        String fileFalse = "png";
        String pathTrue = "img/login.jpg";
        String pathFalse = "img/login.png";

        //When
        SecurityServiceImpl securityService = new SecurityServiceImpl();
        boolean testTrue = securityService.accessCheck(pathTrue, fileTrue);
        boolean testFalse = securityService.accessCheck(pathFalse, fileFalse);

        //Then
        assertTrue(testTrue);
        assertFalse(testFalse);
    }
}