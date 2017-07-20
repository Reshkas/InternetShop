package store.dao.impl;

import store.dao.ICustomerDao;
import store.model.Role;

public class CustomerDaoImpl extends GuestDaoImpl implements ICustomerDao {


    public CustomerDaoImpl(int id, Role role) {
        super(id, role);
    }

    public void getAllInfoProduct() {

    }

    public void writeHello(){
        System.out.println("Привет я новый Клиент !!!");
    }
}
