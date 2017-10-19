package store.dto;

public class LoginUserDto {

    private String login;
    private String password;

    public LoginUserDto(String login, String password) {

        this.login = login;
        this.password = password;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
