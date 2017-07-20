package store.businesLogik.usersFactory;

import store.dao.impl.CustomerDaoImpl;
import store.model.User;
import store.model.UserModel;

public class CustomerFactory implements UsersFactory {
    public UserModel createUser(User user) {
        return new CustomerDaoImpl(user.getId(),user.getRole());
    }
}
