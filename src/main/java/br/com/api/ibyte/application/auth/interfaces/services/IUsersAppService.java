package br.com.api.ibyte.application.auth.interfaces.services;

import br.com.api.ibyte.application.auth.dtos.UsersDto;
import br.com.api.ibyte.application.base.interfaces.services.IAppServiceBase;
import br.com.api.ibyte.domain.auth.entities.AuthUsers;
/**
 *
 * @author marcos.oliveira
 */
public interface IUsersAppService extends IAppServiceBase<UsersDto, AuthUsers> {
    
}