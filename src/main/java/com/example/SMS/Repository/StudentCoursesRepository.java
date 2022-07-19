package com.example.SMS.Repository;

import com.example.SMS.Models.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCoursesRepository extends JpaRepository<StudentCourse,Long>,StudentCourseCustom {
}
