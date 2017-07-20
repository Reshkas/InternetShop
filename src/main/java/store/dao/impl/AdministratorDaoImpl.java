package store.dao.impl;


import store.model.Administrator;
import store.model.Role;

public class AdministratorDaoImpl extends Administrator {

    public AdministratorDaoImpl(int id, Role role) {
        super(id, role);
    }

    public void writeHello(){
        System.out.println("Привет я новый администратор !!!");
    }

}
