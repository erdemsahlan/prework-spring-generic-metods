package com.preworkgenericmethods.repositories;

import com.preworkgenericmethods.models.Student;
import com.preworkgenericmethods.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(
//        path = "students",
//        collectionResourceRel = "students",
//        itemResourceRel = "student"
//)
//@Repository
//public interface StudentRepository extends JpaRepository<Student, Long> {
//}
@Repository
public interface StudentRepository extends GenericRepository<Student, Long> {
}
