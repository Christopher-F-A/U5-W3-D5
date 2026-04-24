package Gestione.Eventi.U5_W3_D5.service;

import Gestione.Eventi.U5_W3_D5.entities.User;
import Gestione.Eventi.U5_W3_D5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash della pass
    userRepository.save(user);
}
}
