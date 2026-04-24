package Gestione.Eventi.U5_W3_D5.repositories;

import Gestione.Eventi.U5_W3_D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // utente tramite email/username al login
    Optional<User> findByEmail(String email);
}
