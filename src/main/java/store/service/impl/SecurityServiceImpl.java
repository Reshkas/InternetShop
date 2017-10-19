package store.service.impl;

import store.service.SecurityService;

public class SecurityServiceImpl implements SecurityService {

    public boolean accessCheck(String path, String role) {

        boolean access = false;

        switch (pathToServletName(path)) {

            case "store":
                if (role.equals("null")) {
                    access = true;
                }
                break;
            case "login":
                if (role.equals("null")) {
                    access = true;
                }
                break;
            case "logout":
                if (role.equals("ADMIN")) {
                    access = true;
                }
                break;
            case "authorization":
                if (role.equals("null")) {
                    access = true;
                }
                break;
            case "registration":
                if (role.equals("null")) {
                    access = true;
                }
                break;
            case "home":
                if (role.equals("null")) {
                    access = true;
                }
                break;
            case "adminPage":
                if (role.equals("ADMIN")) {
                    access = true;
                }
                break;
            case "findUser":
                if (role.equals("ADMIN")) {
                    access = true;
                }
                break;
            case "addUser":
                if (role.equals("null") || role.equals("ADMIN")) {
                    access = true;
                }
                break;
            case "deleteUser":
                if (role.equals("ADMIN")) {
                    access = true;
                }
                break;
            case "changeRole":
                if (role.equals("ADMIN")) {
                    access = true;
                }
                break;
            case "getAllUsers":
                if (role.equals("ADMIN")) {
                    access = true;
                }
                break;
            case "formAddUser":
                if (role.equals("ADMIN")) {
                    access = true;
                }
                break;
            case "formChangeUserRole":
                if (role.equals("ADMIN")) {
                    access = true;
                }
                break;
            case "formDeleteUser":
                if (role.equals("ADMIN")) {
                    access = true;
                }
                break;
            case "formFindUser":
                if (role.equals("ADMIN")) {
                    access = true;
                }
                break;
            default:
                if (separatePath(path).equals("jpg")) {
                    access = true;
                }
        }
        return access;
    }

    private String separatePath(String path) {

        int lastElement;
        String[] subStr;

        String delimiter = "\\."; // Разделитель

        subStr = path.split(delimiter); // Разделения строки str с помощью метода split()

        lastElement = subStr.length;

        return subStr[lastElement - 1];
    }

    private String pathToServletName(String path) {

        int lastElement;
        String[] subString;

        subString = path.split("/");

        lastElement = subString.length;

        return subString[lastElement - 1];
    }
}
