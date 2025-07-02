package com.preworkgenericmethods.services;

import com.preworkgenericmethods.config.Mapper;
import com.preworkgenericmethods.repositories.GenericRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public abstract class GenericServiceImpl<T, ID extends Serializable, DTO>
        implements GenericService<T, ID, DTO> {

    protected final GenericRepository<T, ID> repository;

    // 1. Tekrar eden saveWithRelations metodu kaldırıldı
    // 2. handleRelations abstract metodu tanımlandı
    public abstract void handleRelations(T entity, DTO dto);

    // 3. getEntityClass implementasyonu alt sınıflara bırakıldı
    @Override
    public abstract Class<T> getEntityClass();

    @Override
    public T saveWithRelations(T entity, DTO dto) {
        if (dto != null) {
            handleRelations(entity, dto);
        }
        return repository.save(entity);
    }

    @Override
    public T updateWithRelations(T existingEntity, DTO dto) {
        // 4. Null kontrolü eklendi
        if (dto != null) {
            Mapper.map(dto, existingEntity);
            handleRelations(existingEntity, dto);
        }
        return repository.save(existingEntity);
    }

    // CRUD metotları
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