package com.example.SMS.Repository;

import com.example.SMS.Models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;


public interface coursesRepository extends JpaRepository<Courses,Long> {
    Courses findById(long id);
}
