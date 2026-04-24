package Gestione.Eventi.U5_W3_D5;

import Gestione.Eventi.U5_W3_D5.entities.Role;
import Gestione.Eventi.U5_W3_D5.entities.User;
import Gestione.Eventi.U5_W3_D5.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class U5W3D5Application {

	public static void main(String[] args) {
		SpringApplication.run(U5W3D5Application.class, args);
	}
    @Component
    public class DataInitializer implements CommandLineRunner {
        @Autowired
        private AuthService authService;

        @Override
        public void run(String... args) throws Exception {
            User testUser = new User();
            testUser.setUsername("testuser");
            testUser.setEmail("test@test.com");
            testUser.setPassword("test123");
            testUser.setRole(Role.USER);

            authService.registerUser(testUser);
            System.out.println("UTENTE REGISTRATO E PASS CRIPTATA");
        }
    }

}
