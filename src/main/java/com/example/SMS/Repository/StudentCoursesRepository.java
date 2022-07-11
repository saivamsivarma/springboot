package com.example.SMS.Repository;

import com.example.SMS.Models.Students_courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCoursesRepository extends JpaRepository<Students_courses,Long>,StudentCourseCustom {
}
