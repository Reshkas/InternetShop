package store.dao.impl;

import store.dao.IGuestDao;
import store.dao.ICustomerDao;
import store.dao.IManagerDao;
import store.model.Role;
import store.model.UserModel;

public class ManagerDaoImpl extends UserModel implements IGuestDao, ICustomerDao, IManagerDao {


    public ManagerDaoImpl(int id, Role role) {
        super(id, role);
    }

    public void getInfoProduct() {

    }

    public void getAllProductName() {

    }

    public void addProduct() {

    }

    public void delProduct() {

    }

    public void updNameProduct() {

    }

    public void updAmountProduct() {

    }

    public void updPriceProduct() {

    }

    public void getAllInfoProduct() {

    }

    public void updDescription() {

    }

    public void writeHello(){
        System.out.println("Привет я новый менеджер !!!");
    }
}
