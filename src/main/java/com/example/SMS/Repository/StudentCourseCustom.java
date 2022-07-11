package com.example.SMS.Repository;

import com.example.SMS.Models.Students_courses;


public interface StudentCourseCustom {

    Students_courses getAllRecords(long sid,long id);

//    studentsModel getDetails(long id);
    Object getDetails(long id);
}
