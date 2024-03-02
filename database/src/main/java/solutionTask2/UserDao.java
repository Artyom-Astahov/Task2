package solutionTask2;

import java.util.Optional;

public class UserDao {

    public Optional<User> findById(Long id){
        User user = new User();
        user.setName("Artem");
        return Optional.of(user);
    }
}
