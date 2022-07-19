package com.example.SMS.Service;

import com.example.SMS.Services.CoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CourseServiceIT {
    @Autowired
    private CoursesServices coursesServices;
//    Set<Student> students = new HashSet<>();

//    Course course = new Course(1,"cs23456","Programming with java","Shyam singh roy","Computer science");
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
//        List<Course> courses = new ArrayList<>();
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
//        Course updatedCourse = new Course(1,"cs23456","Advance Programming with java","Shyam singh roy","Computer science",students);
//        assertThat(coursesServices.updateCourses(1L,updatedCourse)).isEqualTo(updatedCourse);
//    }
}