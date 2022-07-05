package com.example.SMS.Controllers;

import com.example.SMS.Models.Courses;
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
    public ResponseEntity<Courses> createCourse(@RequestBody Courses course){
        Courses newCourse = coursesServices.createCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Courses>> getAllCourses(){
        List<Courses> courseList = coursesServices.getAllCourses();
        return new ResponseEntity<>(courseList,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Courses> getCourse(@PathVariable long id){
        Courses course = coursesServices.getCoursesById(id);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id){
        String response = coursesServices.deleteCourses(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Courses> updateCourse(@PathVariable long id, @RequestBody Courses course){
        Courses updatedCourse = coursesServices.updateCourses(id,course);
        return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
    }
}
