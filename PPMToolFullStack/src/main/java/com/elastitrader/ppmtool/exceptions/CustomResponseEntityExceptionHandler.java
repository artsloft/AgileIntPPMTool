package com.elastitrader.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.jws.WebResult;

@ControllerAdvice
@Controller
public class CustomResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdException(ProjectIdException ex, WebRequest request){
        ProjectIdExceptionRespone exceptionRespone = new ProjectIdExceptionRespone(ex.getMessage());
        return new ResponseEntity(exceptionRespone, HttpStatus.BAD_REQUEST);
    }
}
