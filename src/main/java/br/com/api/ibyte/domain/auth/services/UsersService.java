package br.com.api.ibyte.domain.auth.services;

import org.springframework.stereotype.Service;

import br.com.api.ibyte.domain.auth.entities.AuthUsers;
import br.com.api.ibyte.domain.auth.interfaces.repository.IUsersRepository;
import br.com.api.ibyte.domain.auth.interfaces.services.IUsersService;
import br.com.api.ibyte.domain.base.services.ServiceBase;
/**
 *
 * @author marcos.oliveira
 */
@Service
public class UsersService extends ServiceBase<AuthUsers, String> implements IUsersService {

    private IUsersRepository _usersRepository;

    public UsersService(IUsersRepository repository) {
        super(repository);
        this._usersRepository = repository;
    }

}