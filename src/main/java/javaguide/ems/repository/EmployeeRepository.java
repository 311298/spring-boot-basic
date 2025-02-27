package javaguide.ems.repository;

import javaguide.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /*
    to make the repository interface which performs the crud
    operation on the database
    we need to extend JpaRepository < with_entity_class_name,
    primary_id_type>

    The @Repository annotation in Spring Boot indicates that a class is
    a repository component. Repositories manage data storage,
    retrieval, and other operations in a database

    implementated with @Transactional -> which means annotated class or
    method will perform operation which will be reflected in the database

    SimpleJpaRepository class is implemented with
    JpaRepositoryImplementation
    */
}
