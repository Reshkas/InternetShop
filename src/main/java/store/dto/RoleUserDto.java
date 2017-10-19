package store.dto;

import store.model.Role;

public class RoleUserDto {

    private String login;
    private Role role;

    public RoleUserDto(Role role, String login) {
        this.role = role;
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}