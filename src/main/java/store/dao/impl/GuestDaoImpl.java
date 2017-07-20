package store.dao.impl;

import store.dao.IGuestDao;
import store.model.Role;
import store.model.UserModel;

public class GuestDaoImpl extends UserModel implements IGuestDao {

    public GuestDaoImpl(int id, Role role) {
        super(id, role);
    }

    public void getInfoProduct() {

    }

    public void getAllProductName() {

    }

    public void writeHello(){
        System.out.println("Привет я новый гость !!!");
    }
}
