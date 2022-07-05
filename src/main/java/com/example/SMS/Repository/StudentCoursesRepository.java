package com.example.SMS.Repository;

import com.example.SMS.Models.Students_courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentCoursesRepository extends JpaRepository<Students_courses,Long> {
    @Transactional
    @Modifying
    @Query("DELETE from Students_courses sc where sc.student_id=?1 and sc.course_id=?2")
    void disEnroll(long sid,long id);
}
