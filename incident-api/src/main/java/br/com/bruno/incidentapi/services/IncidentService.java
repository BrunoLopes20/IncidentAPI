package br.com.bruno.incidentapi.services;


import br.com.bruno.incidentapi.domain.Incident;

import java.util.List;

public interface IncidentService {


    Incident newIncident(Incident incident);

    Incident updateIncident(Incident incident, Long id);

    Incident closeIncident(Long id);

    void deleteIncident(Long id);

    Incident getIncidentById(Long id);

    List<Incident> getAllIncident();

    List<Incident> getLast20Incident();

    Boolean existIncidentByID(Long id);

}
