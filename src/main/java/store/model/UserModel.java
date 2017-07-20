package store.model;


public abstract class UserModel {

    private int id;
    private Role role;

    public UserModel(int id, Role role) {
        this.id = id;
        this.role = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void writeHello(){

    }
}
