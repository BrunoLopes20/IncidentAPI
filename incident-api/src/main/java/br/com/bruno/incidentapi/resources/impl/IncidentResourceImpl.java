package br.com.bruno.incidentapi.resources.impl;

import br.com.bruno.incidentapi.domain.Incident;
import br.com.bruno.incidentapi.resources.IncidentResource;
import br.com.bruno.incidentapi.services.IncidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/incident")
public class IncidentResourceImpl implements IncidentResource {

    private final IncidentService service;

    @Override
    public ResponseEntity<Incident> findIncidentById(Long id) {
        Incident incident = service.getIncidentById(id);
        return ResponseEntity.ok(incident);
    }

    @Override
    public ResponseEntity<List<Incident>> getAllIncident() {
        List<Incident> incidents = service.getAllIncident();
        return ResponseEntity.ok(incidents);
    }

    @Override
    public ResponseEntity<List<Incident>> getLast20Incident() {
        List<Incident> incidents = service.getLast20Incident();
        return ResponseEntity.ok(incidents);
    }

    @Override
    public ResponseEntity<Incident> newIncident(Incident incident) {
        Incident newIncident = service.newIncident(incident);
        return ResponseEntity.ok(newIncident);
    }

    @Override
    public ResponseEntity<Incident> updateIncident(Incident incident, Long id) {
        if(service.existIncidentByID(id)){
            Incident newIncident = service.updateIncident(incident, id);
            return ResponseEntity.ok(newIncident);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Incident> closeIncident(Long id) {
        if(service.existIncidentByID(id)){
            Incident newIncident = service.closeIncident(id);
            return ResponseEntity.ok(newIncident);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteIncident(Long id) {
        if(service.existIncidentByID(id)){
            service.deleteIncident(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
