package com.example.SMS.Repository;

import com.example.SMS.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface coursesRepository extends JpaRepository<Course,Long> {
    Course findById(long id);
}
