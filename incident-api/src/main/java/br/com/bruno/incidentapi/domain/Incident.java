package br.com.bruno.incidentapi.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_INCIDENT")
public class Incident {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long idIncident;

    private String name;

    private String description;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime closedAt;

    public void setCreatedAt() {
        this.createdAt =  LocalDateTime.now();
    }
}
