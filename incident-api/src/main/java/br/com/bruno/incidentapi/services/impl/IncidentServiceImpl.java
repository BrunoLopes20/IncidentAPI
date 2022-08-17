package br.com.bruno.incidentapi.services.impl;

import br.com.bruno.incidentapi.domain.Incident;
import br.com.bruno.incidentapi.repositories.IncidentRepository;
import br.com.bruno.incidentapi.services.IncidentService;
import br.com.bruno.incidentapi.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@AllArgsConstructor
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository repository;


    @Override
    public Incident newIncident(Incident incident) {
        return repository.save(incident);
    }

    @Override
    public Incident updateIncident(Incident incident, Long id) {
        repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Not found"));
        return repository.save(incident);
    }

    @Override
    public Incident closeIncident(Long id) {
        Incident incident = repository.findById(id).map( data -> {
            data.setClosedAt(LocalDateTime.now());
            return data;
        }).orElseThrow(()-> new ObjectNotFoundException("Object not fund"));
        return repository.save(incident);
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
        Iterable<Incident> incidentIterable = repository.findAll(Sort.by(Sort.Direction.ASC, "idIncident"));
        return StreamSupport.stream(incidentIterable.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public List<Incident> getLast20Incident() {
        Page<Incident> incidentPage = repository.findAll(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "idIncident")));
        return incidentPage.getContent();
    }

    @Override
    public Boolean existIncidentByID(Long id) { return repository.existsById(id);}


}
