package br.com.api.ibyte.domain.base.services;

import java.util.List;

import br.com.api.ibyte.domain.base.entities.EntityBase;
import br.com.api.ibyte.domain.base.interfaces.repository.IRepositoryBase;
import br.com.api.ibyte.domain.base.interfaces.services.IServiceBase;
import br.com.api.ibyte.domain.base.services.enums.ActionEntityTypeEnum;

/**
 *
 * @author marcos.oliveira
 */
public class ServiceBase<TEntity extends EntityBase<TIdentity>, TIdentity> implements IServiceBase<TEntity, TIdentity> {

    private final IRepositoryBase<TEntity,TIdentity> _repository;
    
    public ServiceBase(IRepositoryBase<TEntity, TIdentity> repository) {
        this._repository = repository;
    }

    protected TEntity saveEntity(TEntity entity, ActionEntityTypeEnum type){
        entity = this._repository.save(entity);
        return entity;
    }

    @Override
    public void commit() {
        this._repository.flush();
    }

    @Override
    public TEntity getById(TIdentity id) {
        var entity = this._repository.findById(id);
        return entity.orElse(null);
    }

    @Override
    public List<TEntity> getAll() {
        var entitys = this._repository.findAll();
        return entitys;
    }

    @Override
    public TEntity create(TEntity entity) {
        return saveEntity(entity, ActionEntityTypeEnum.INSERT);
    }

    @Override
    public TEntity update(TEntity entity) {
        return saveEntity(entity, ActionEntityTypeEnum.UPDATE);
    }

    @Override
    public int delete(TIdentity id) {
        try {
            this._repository.deleteById(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}