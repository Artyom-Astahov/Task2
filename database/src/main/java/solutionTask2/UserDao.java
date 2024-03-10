package solutionTask2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class UserDao {
    private final List<User> listUsers = new ArrayList<>();


    public void createUser(String name, String age, String email, String login, String password) throws UserExistsException {
        if (identityVerification(login)) {
            listUsers.add(new User(name, age, email, login, password));

        } else {
            throw new UserExistsException("Пользователь сущетсвует");
        }

    }

    public User logIn(String login, String password) throws UserNotExistsException {
        for (solutionTask2.User User : listUsers) {
            if (User.getLogin().contains(login) && User.getPassword().contains(password)) {
                return User;
            }
        }
        throw new UserNotExistsException("Пользователь не найден");

    }

    private boolean identityVerification(String login) {
        AtomicBoolean retunrs = new AtomicBoolean(true);
        listUsers.forEach(User -> {
            if (User.getLogin().contains(login)) {
                retunrs.set(false);
            }
        });
        return retunrs.get();
    }


}
