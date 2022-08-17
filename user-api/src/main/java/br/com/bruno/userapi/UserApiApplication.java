package br.com.bruno.userapi;

import br.com.bruno.userapi.domain.User;
import br.com.bruno.userapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.saveAll(List.of(
                new User(null, "NomeTeste", "EmailTeste", "123", 12.0),
                new User(null, "NomeTeste", "EmailTeste", "123", 12.0),
                new User(null, "NomeTeste", "EmailTeste", "123", 12.0)

        ));
    }
}
