package com.example.SMS.Repository;

import com.example.SMS.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentsRepository extends JpaRepository<Student,Long> {
    Student findById(long id);
}
