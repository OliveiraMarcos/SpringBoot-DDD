package br.com.api.ibyte.service.api.auth;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.ibyte.application.auth.dtos.UsersDto;
import br.com.api.ibyte.application.auth.interfaces.services.IUsersAppService;
import br.com.api.ibyte.service.api.base.controllers.ApiController;
import br.com.api.ibyte.service.api.base.response.Result;

/**
 *
 * @author marcos.oliveira
 */
@RestController
@RequestMapping("/api/users")
public class UserController extends ApiController {
    @Autowired
    private IUsersAppService _usersAppService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Result<List<UsersDto>>> get() {
        try{
            List<UsersDto> list = _usersAppService.getAll();
            return ResponseSuccess(list, HttpStatus.OK);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Result<UsersDto>> getById(@PathVariable(value = "id") String id) {
        try{
            UsersDto entity = _usersAppService.getById(id);
            return ResponseSuccess(entity, HttpStatus.OK);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
    }
    
    @RequestMapping(method =  RequestMethod.POST)
    public ResponseEntity<Result<UsersDto>> post(@Valid @RequestBody UsersDto users)
    {
        try{
            UsersDto entity = _usersAppService.create(users);
            return ResponseSuccess(entity, HttpStatus.CREATED);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
    }   
    
    @RequestMapping(method =  RequestMethod.PUT)
    public ResponseEntity<Result<UsersDto>> put(@Valid @RequestBody UsersDto users)
    {
        try{
            UsersDto entity = _usersAppService.update(users);
            return ResponseSuccess(entity, HttpStatus.OK);
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Result<UsersDto>> delete(@PathVariable(value = "id") String id)
    {
        UsersDto entity = this._usersAppService.getById(id);
        try{
            int ok = _usersAppService.delete(id);
            if (ok > 0) {
                return ResponseSuccess(entity, HttpStatus.OK);
            }else{
                return ResponseErro(HttpStatus.NOT_FOUND, null, entity);
            }
        }catch(Exception ex){
            return ResponseErro(HttpStatus.BAD_REQUEST, ex, entity);
        }
    }
}