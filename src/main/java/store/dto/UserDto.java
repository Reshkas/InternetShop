package store.dto;

import store.model.Role;

public class UserDto {

    private int id;
    private String login;
    private Role role;

    public UserDto(int id, String login, Role role) {

        this.id = id;
        this.login = login;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {

        UserDto other = (UserDto) obj;

        return this == obj || this.getClass() == obj.getClass() && this.id == other.id
                && this.login == other.login && this.role == other.role;
    }
}
