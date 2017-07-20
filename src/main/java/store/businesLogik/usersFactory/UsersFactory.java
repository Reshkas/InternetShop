package store.businesLogik.usersFactory;

import store.model.User;
import store.model.UserModel;

public interface UsersFactory {

    UserModel createUser(User user);

}
