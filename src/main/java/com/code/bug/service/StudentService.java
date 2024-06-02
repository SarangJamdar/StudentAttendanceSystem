package com.code.bug.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.code.bug.model.Student;


public interface StudentService {
	List<Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);
    Page<Student> findPaginated(int pageNum, int pageSize,
                               String sortField,
                               String sortDirection);
}
