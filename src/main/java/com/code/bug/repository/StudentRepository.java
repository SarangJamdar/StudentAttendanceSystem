package com.code.bug.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.bug.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}