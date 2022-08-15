package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// for JPA, we create an interface that extends JpaRepository of the table entity and the id type - <Student, Long>

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    @Query("SELECT s FROM  Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
    //Student findStudentByEmail(String email);
}
