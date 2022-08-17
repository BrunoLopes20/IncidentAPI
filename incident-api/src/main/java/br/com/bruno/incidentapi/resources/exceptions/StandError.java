package br.com.bruno.incidentapi.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class StandError {

    private LocalDateTime timestanp;

    private String error;

    private Integer status;

    private String path;

}
