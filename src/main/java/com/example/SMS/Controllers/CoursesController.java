package com.example.SMS.Controllers;

import com.example.SMS.Models.Course;
import com.example.SMS.Services.CoursesServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Courses")
public class CoursesController {
    private final CoursesServices coursesServices;

    public CoursesController(CoursesServices coursesServices) {
        this.coursesServices = coursesServices;
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course newCourse = coursesServices.createCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courseList = coursesServices.getAllCourses();
        return new ResponseEntity<>(courseList,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable long id){
        Course course = coursesServices.getCoursesById(id);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id){
        String response = coursesServices.deleteCourses(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable long id, @RequestBody Course course){
        Course updatedCourse = coursesServices.updateCourses(id,course);
        return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
    }
}
