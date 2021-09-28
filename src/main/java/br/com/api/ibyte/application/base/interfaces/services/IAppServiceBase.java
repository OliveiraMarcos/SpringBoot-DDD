package br.com.api.ibyte.application.base.interfaces.services;

import java.io.Serializable;
import java.util.List;

import br.com.api.ibyte.application.base.dtos.IdentityDto;
import br.com.api.ibyte.domain.base.entities.EntityBase;
/**
 *
 * @author marcos.oliveira
 */
public interface IAppServiceBase<TDto,TEntity> {
    TDto getById(Object id);
    List<TDto> getAll();
    TDto create(TDto dto);
    TDto update(TDto dto);
    int delete(Object id);
    void commit();
}