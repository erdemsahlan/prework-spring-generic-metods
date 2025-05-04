package com.preworkgenericmethods.services;

import com.preworkgenericmethods.repositories.GenericRepository;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    protected final GenericRepository<T, ID> repository;

    public GenericServiceImpl(GenericRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public List<T> saveAll(List<T> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}