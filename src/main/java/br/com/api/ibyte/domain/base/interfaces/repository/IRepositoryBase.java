package br.com.api.ibyte.domain.base.interfaces.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.ibyte.domain.base.entities.EntityBase;
/**
 * @author marcos.oliveira
 * @param <TEntity>
 */
public interface IRepositoryBase<TEntity extends EntityBase<TIdentity>, TIdentity> extends JpaRepository<TEntity,TIdentity> {
    
}