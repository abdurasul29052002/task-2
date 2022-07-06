package com.example.task2.mapper.template;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface GenericMapper<E, M> {

    M entityToModel(E entity);

    E modelToEntity(M model);

    List<E> modelsToEntities(List<M> models);

    List<M> entitiesToModels(List<E> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromModel(@MappingTarget E entity, M model);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromEntity(E entity,@MappingTarget M model);

}
