package com.preworkgenericmethods.repositories;

import com.preworkgenericmethods.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path = "students",
        collectionResourceRel = "students",
        itemResourceRel = "student"
)
public interface StudentRepository extends JpaRepository<Student, Long> {
}
