package store.businesLogik.usersFactory;

import store.dao.impl.GuestDaoImpl;
import store.model.User;
import store.model.UserModel;

public class GuestFactory implements UsersFactory{
    public UserModel createUser(User user) {
        return new GuestDaoImpl(user.getId(),user.getRole());
    }
}
