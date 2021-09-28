package br.com.api.ibyte.domain.base.interfaces.services;

import java.util.List;

/**
 *
 * @author marcos.oliveira
 */
public interface IServiceBase<TEntity, TIdentity> {
    TEntity getById(TIdentity id);
    List<TEntity> getAll();
    TEntity create(TEntity entity);
    TEntity update(TEntity entity);
    int delete(TIdentity id);
    void commit();
}
