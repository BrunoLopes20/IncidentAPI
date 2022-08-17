package br.com.bruno.incidentapi;

import br.com.bruno.incidentapi.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IncidentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(IncidentApiApplication.class, args);
    }

}
