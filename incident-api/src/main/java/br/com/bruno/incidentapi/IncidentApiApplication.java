package br.com.bruno.incidentapi;

import br.com.bruno.incidentapi.domain.Incident;
import br.com.bruno.incidentapi.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class IncidentApiApplication {

    //implements CommandLineRunner

    @Autowired
    private IncidentRepository incidentRepository;

    public static void main(String[] args) {
        SpringApplication.run(IncidentApiApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        incidentRepository.saveAll(List.of(
//                new Incident(null, "IncidentTest", "DescriptionTest", LocalDateTime.now(), null,null )
//        ));
//    }
}
