package br.com.bruno.incidentapi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface GenericResource<T> {

    @GetMapping(value = "/{id}")
    ResponseEntity<T> findIncidentById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<T>> getAllIncident();

    @GetMapping(value = "/last20")
    ResponseEntity<List<T>> getLast20Incident();

    @PostMapping
    ResponseEntity<T> newIncident(@RequestBody T incident);

    @PutMapping(value = "/{id}")
    ResponseEntity<T> updateIncident(@RequestBody T incident, @PathVariable Long id);

    @PutMapping(value = "/close/{id}")
    ResponseEntity<T> closeIncident(@PathVariable Long id);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteIncident(@PathVariable Long id);



}

