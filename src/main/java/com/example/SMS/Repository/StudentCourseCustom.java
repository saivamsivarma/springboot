package com.example.SMS.Repository;

import com.example.SMS.Models.Students_courses;

import java.util.List;

public interface StudentCourseCustom {

    Students_courses getAllRecords(long sid,long id);
}
