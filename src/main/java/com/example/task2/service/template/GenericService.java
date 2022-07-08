package com.example.task2.service.template;

import com.example.task2.exception.NotFoundException;
import com.example.task2.exception.PSQLException;
import com.example.task2.mapper.template.GenericMapper;
import com.example.task2.payload.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public abstract class GenericService<E, M, R extends JpaRepository<E, Long>, MAPPER extends GenericMapper<E, M>> {
    protected final R repository;
    protected final MAPPER mapper;

    @SneakyThrows
    public M save(M model) {
        try {
            E entity = mapper.modelToEntity(model);
            E savedEntity = repository.save(entity);
            return mapper.entityToModel(savedEntity);
        }catch (Exception e){
            throw new PSQLException();
        }
    }

    @SneakyThrows
    public E findById(Long id) {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<M> findAll(Integer page, Integer size) {
        List<E> list = repository.findAll(PageRequest.of(page, size)).getContent();
        return mapper.entitiesToModels(list);
    }

    public M update(M model, Long id) {
        E entity = findById(id);
        mapper.updateEntityFromModel(entity, model);
        E savedEntity = repository.save(entity);
        return mapper.entityToModel(savedEntity);
    }

    public ApiResponse deleteById(Long id) {
        try {
            repository.deleteById(id);
            return new ApiResponse("Deleted", true);
        } catch (Exception e) {
            return new ApiResponse("Error", false);
        }
    }

}
