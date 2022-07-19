package com.example.SMS.Repository;

import com.example.SMS.Models.Student;
import com.example.SMS.Models.StudentCourse;


public interface StudentCourseCustom {

    StudentCourse getAllRecords(long sid, long id);

//    Student getDetails(long id);
    Student getDetails(long id);
}
