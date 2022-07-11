package com.example.SMS.Controllers;

import com.example.SMS.Models.Courses;
import com.example.SMS.Models.studentsModel;
import com.example.SMS.Services.studentsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentController {
    private final studentsServices studentsServices;

    public studentController(studentsServices studentsServices) {
        this.studentsServices = studentsServices;
    }


    @GetMapping("/all")
    public ResponseEntity<List<studentsModel>> getStudents(){
        List<studentsModel> studentList = studentsServices.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody studentsModel student){
        String response= studentsServices.saveStudent(student);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<studentsModel> getStudent(@PathVariable long id){
        studentsModel student = studentsServices.getStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        String response =  studentsServices.deleteStudent(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<studentsModel> updateStudent(@PathVariable long id,@RequestBody studentsModel newStudent){
        studentsModel student = studentsServices.updateStudent(id,newStudent);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("/addCourse/{sid}/{id}")
    public ResponseEntity<String> addCourse(@PathVariable long sid,@PathVariable long id){
        String response = studentsServices.addCourse(sid,id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getCourses/{id}")
    public ResponseEntity<List<Courses>> getCourses(@PathVariable long id){
        List<Courses> enrolledCourses = studentsServices.enrolledCourses(id);
        return new ResponseEntity<>(enrolledCourses,HttpStatus.OK);
    }

    @DeleteMapping("/disEnroll/{sid}/{id}")
    public ResponseEntity<String> removeCourse(@PathVariable long sid,@PathVariable long id){
        String response = studentsServices.disEnroll(sid,id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("getDetails/{id}")
    public ResponseEntity<Object> getDetails(@PathVariable long id){
        Object response = studentsServices.getDetails(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
