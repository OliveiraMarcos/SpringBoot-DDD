package br.com.api.ibyte.domain.base.uow;

import br.com.api.ibyte.domain.base.entities.EntityBase;
/**
 *
 * @author marcos.oliveira
 */
public interface IUnitOfWork<TEntity extends EntityBase> {
    Boolean commit();
}