package br.com.bruno.incidentapi.resources;

import br.com.bruno.incidentapi.domain.Incident;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IncidentResource {

    @GetMapping(value = "/{id}")
    ResponseEntity<Incident> findIncidentById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<Incident>> getAllIncident();

    @GetMapping(value = "/last20")
    ResponseEntity<List<Incident>> getLast20Incident();

    @PostMapping
    ResponseEntity<Incident> newIncident(@RequestBody Incident incident);

    @PutMapping(value = "/{id}")
    ResponseEntity<Incident> updateIncident(@RequestBody Incident incident, @PathVariable Long id);

    @PutMapping(value = "/close/{id}")
    ResponseEntity<Incident> closeIncident(@PathVariable Long id);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteIncident(@PathVariable Long id);



}

