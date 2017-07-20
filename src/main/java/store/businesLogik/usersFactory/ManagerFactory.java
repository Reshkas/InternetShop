package store.businesLogik.usersFactory;

import store.dao.impl.ManagerDaoImpl;
import store.model.User;
import store.model.UserModel;

public class ManagerFactory implements UsersFactory {
    public UserModel createUser(User user) {
        return new ManagerDaoImpl(user.getId(),user.getRole());
    }
}
