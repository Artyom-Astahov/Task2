package solutionTask2;

import java.util.Optional;

public class UserService {

    private final UserDao userDao = new UserDao();
    public User user = null;

    public Object logIn(String login, String password) throws UserExistsException {
        try {
            user = userDao.logIn(login, password);
            return user;
        } catch (UserNotExistsException e) {
            throw new UserExistsException(e.getMessage());
        }
    }

    public String createUser(String name, String age, String email, String login, String password) throws UserExistsException {
        try {
            userDao.createUser(name, age, email, login, password);
            return "Пользователь успешно создан";
        } catch (UserExistsException e) {
            throw new UserExistsException(e.getMessage());
        }
    }

}
