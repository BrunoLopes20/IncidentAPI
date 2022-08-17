package br.com.bruno.userapi.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
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
