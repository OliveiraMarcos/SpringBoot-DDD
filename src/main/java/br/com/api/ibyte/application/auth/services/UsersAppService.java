package br.com.api.ibyte.application.auth.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.api.ibyte.application.auth.dtos.UsersDto;
import br.com.api.ibyte.application.auth.interfaces.services.IUsersAppService;
import br.com.api.ibyte.application.base.services.AppServiceBase;
import br.com.api.ibyte.domain.auth.entities.AuthUsers;
import br.com.api.ibyte.domain.auth.interfaces.services.IUsersService;
/**
 *
 * @author marcos.oliveira
 */
@Service
public class UsersAppService extends AppServiceBase<UsersDto, AuthUsers> implements IUsersAppService {

    public UsersAppService(ModelMapper mapper, IUsersService serviceBase) {
        super(mapper, serviceBase);
    }
    
}
