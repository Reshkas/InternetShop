package store.businesLogik.usersFactory;

import store.dao.impl.AdministratorDaoImpl;
import store.model.User;
import store.model.UserModel;

public class AdministratorFactory implements UsersFactory {
    public UserModel createUser(User user) {
        return new AdministratorDaoImpl(user.getId(),user.getRole());
    }
}
