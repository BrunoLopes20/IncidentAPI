package br.com.bruno.incidentapi.services.impl;

import br.com.bruno.incidentapi.domain.Incident;
import br.com.bruno.incidentapi.repositories.IncidentRepository;
import br.com.bruno.incidentapi.services.IncidentService;
import br.com.bruno.incidentapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class IncidentServiceImpl implements IncidentService {


    private final IncidentRepository repository;


    @Override
    public Incident newIncident(Incident incident) {
        incident.setCreatedAt();
        return repository.save(incident);
    }

    @Override
    public Incident updateIncident(Incident incident, Long id) {
        return repository.findById(id)
                .map( data -> {
                    data.setName(incident.getName());
                    data.setDescription(incident.getDescription());
                    data.setUpdatedAt(LocalDateTime.now());
                    return repository.save(incident);
                }).orElseGet(() -> {
                    incident.setName(incident.getName());
                    incident.setDescription(incident.getDescription());
                    incident.setCreatedAt();
                    return repository.save(incident);
                });
    }

    @Override
    public Incident closeIncident(Long id) {
        return repository.findById(id)
                .map( data -> {
                    data.setClosedAt(LocalDateTime.now());
                    return data;
                }).orElseThrow(()-> new ObjectNotFoundException("Object not fund"));
    }

    @Override
    public void deleteIncident(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Incident getIncidentById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Object not fund"));
    }

    @Override
    public List<Incident> getAllIncident() {
        return repository.findAll();
    }

    @Override
    public List<Incident> getLast20Incident() {
        return null;
    }

    @Override
    public Boolean existIncidentByID(Long id) { return repository.existsById(id);}


}
