package br.com.api.ibyte.service.api.base.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.api.ibyte.service.api.base.response.Result;

public abstract class ApiController {
    public <T extends Object> ResponseEntity<Result<T>> ResponseErro(HttpStatus code, Exception ex){
        return ResponseErro(code, ex, null);
    }
    public <T extends Object> ResponseEntity<Result<T>> ResponseErro(HttpStatus code, Exception ex, T entity){
        Result<T> result = new Result<T>();
        result.setCode(code)
              .setMessage("Error!")
              .setObjectResponse(entity)
              .addError(ex.getMessage());
        return new ResponseEntity<Result<T>>(
        result, code
        );
    }
    
    public <T extends Object> ResponseEntity<Result<T>> ResponseSuccess(T entity, HttpStatus code){
        Result<T> result = new Result<T>();
        result.setCode(code)
              .setMessage("Success!")
              .setObjectResponse(entity);
        return new ResponseEntity<Result<T>>(
        result, code
        );
    }
}