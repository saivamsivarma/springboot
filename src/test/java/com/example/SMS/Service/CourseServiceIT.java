package com.example.SMS.Service;

import com.example.SMS.Models.Courses;
import com.example.SMS.Models.studentsModel;
import com.example.SMS.Services.CoursesServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CourseServiceIT {
    @Autowired
    private CoursesServices coursesServices;
//    Set<studentsModel> students = new HashSet<>();

//    Courses course = new Courses(1,"cs23456","Programming with java","Shyam singh roy","Computer science");
//
//    @Test
//    public void testCreateCourse(){
//        assertThat(coursesServices.createCourse(course)).isEqualTo(course);
//    }
//
//    @Test
//    public void testGetCoursesById(){
//        assertThat(coursesServices.getCoursesById(1L)).isEqualTo(course);
//    }
//
//    @Test
//    public void testGetAllCourses(){
//        List<Courses> courses = new ArrayList<>();
//        courses.add(course);
//        assertThat(coursesServices.getAllCourses()).isEqualTo(courses);
//    }
//
//    @Test
//    public void testDeleteCourse(){
//        assertThat(coursesServices.deleteCourses(1L)).isEqualTo("Course deleted");
//    }
//
//    @Test
//    public void testUpdateCourse(){
//        Courses updatedCourse = new Courses(1,"cs23456","Advance Programming with java","Shyam singh roy","Computer science",students);
//        assertThat(coursesServices.updateCourses(1L,updatedCourse)).isEqualTo(updatedCourse);
//    }
}