package ru.miroshka.hw7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.miroshka.hw7.data.Student;

@Repository
public interface StudentDao extends JpaRepository<Student,Long>, JpaSpecificationExecutor<Student> {
}
