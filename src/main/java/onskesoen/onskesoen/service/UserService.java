package onskesoen.onskesoen.service;

import onskesoen.onskesoen.model.User;
import onskesoen.onskesoen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.insertUser(user);
    }

    public boolean loginUser(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
