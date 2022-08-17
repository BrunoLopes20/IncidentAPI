package br.com.bruno.incidentapi.resources.impl;

import br.com.bruno.incidentapi.domain.Incident;
import br.com.bruno.incidentapi.resources.GenericResource;
import br.com.bruno.incidentapi.services.IncidentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Incident", description = "Incident API")
@RequestMapping(value = "/incident")
public class IncidentResourceImpl implements GenericResource<Incident> {

    private final IncidentService service;

    @Operation(summary = "Find incident by id", description = "Find incident by id", tags = { "Incident" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return an incident",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incident.class)))) })
    @Override
    public ResponseEntity<Incident> findIncidentById(Long id) {
        Incident incident = service.getIncidentById(id);
        return ResponseEntity.ok(incident);
    }

    @Operation(summary = "Find all incidents", description = "Find all incidents", tags = { "Incident" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a list of all incidents",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incident.class)))) })
    @Override
    public ResponseEntity<List<Incident>> getAllIncident() {
        List<Incident> incidents = service.getAllIncident();
        return ResponseEntity.ok(incidents);
    }

    @Operation(summary = "Find the last twenty incidents", description = "Find the last twenty incidents", tags = { "Incident" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a list of the last twenty incidents",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incident.class)))) })
    @Override
    public ResponseEntity<List<Incident>> getLast20Incident() {
        List<Incident> incidents = service.getLast20Incident();
        return ResponseEntity.ok(incidents);
    }

    @Operation(summary = "Create a new incident", description = "Create a new incident", tags = { "Incident" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Incident created successfully",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incident.class)))) })
    @Override
    public ResponseEntity<Incident> newIncident(Incident incident) {
        Incident newIncident = service.newIncident(incident);
        return ResponseEntity.ok(newIncident);
    }

    @Operation(summary = "Update an incident", description = "Update an incident", tags = { "Incident" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Incident changed successfully",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incident.class)))) })
    @Override
    public ResponseEntity<Incident> updateIncident(Incident incident, Long id) {
        if(service.existIncidentByID(id)){
            Incident newIncident = service.updateIncident(incident, id);
            return ResponseEntity.ok(newIncident);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Close an incident", description = "Close an incident", tags = { "Incident" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Incident closed successfully",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incident.class)))) })
    @Override
    public ResponseEntity<Incident> closeIncident(Long id) {
        if(service.existIncidentByID(id)){
            Incident newIncident = service.closeIncident(id);
            return ResponseEntity.ok(newIncident);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete an incident by Id", description = "Delete an incident by Id", tags = { "Incident" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Incident successfully deleted",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Incident.class)))) })
    @Override
    public ResponseEntity<Void> deleteIncident(Long id) {
        if(service.existIncidentByID(id)){
            service.deleteIncident(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
