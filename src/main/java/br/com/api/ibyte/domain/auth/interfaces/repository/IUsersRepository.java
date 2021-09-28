package br.com.api.ibyte.domain.auth.interfaces.repository;

import org.springframework.stereotype.Repository;

import br.com.api.ibyte.domain.auth.entities.AuthUsers;
import br.com.api.ibyte.domain.base.interfaces.repository.IRepositoryBase;

/**
 *
 * @author marcos.oliveira
 */
@Repository
public interface IUsersRepository extends IRepositoryBase<AuthUsers, String> {
    
}