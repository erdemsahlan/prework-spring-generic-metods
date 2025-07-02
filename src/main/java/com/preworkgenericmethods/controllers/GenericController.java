package com.preworkgenericmethods.controllers;

import com.preworkgenericmethods.config.Mapper;
import com.preworkgenericmethods.services.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<T, ID, DTO> {
    private final Class<T> entityClass;  // Yeni alan
    protected final GenericService<T, ID, DTO> service;
    private final Class<DTO> dtoClass;

    public GenericController(GenericService<T, ID, DTO> service,
                             Class<T> entityClass,
                             Class<DTO> dtoClass) {
        this.service = service;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @GetMapping
    public ResponseEntity<List<DTO>> getAll() {
        List<T> entities = service.findAll();
        List<DTO> dtos = Mapper.mapAll(entities, dtoClass);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getById(@PathVariable ID id) {
        return service.findById(id)
                .map(entity -> {
                    DTO dto = Mapper.map(entity, dtoClass);
                    return new ResponseEntity<>(dto, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {
        T entity = Mapper.map(dto, entityClass);
        T savedEntity = service.saveWithRelations(entity, dto);
        DTO responseDto = Mapper.map(savedEntity, dtoClass);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody DTO dto) {
        return service.findById(id)
                .map(existingEntity -> {
                    T updatedEntity = service.updateWithRelations(existingEntity, dto);
                    DTO responseDto = Mapper.map(updatedEntity, dtoClass);
                    return new ResponseEntity<>(responseDto, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (service.existsById(id)) {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
