package com.example.SMS.Controllers;

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

    public studentController( com.example.SMS.Services.studentsServices studentsServices) {
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

    @PatchMapping("/")
    public ResponseEntity<studentsModel> updateStudent(@RequestBody studentsModel newStudent){
        studentsModel student = studentsServices.updateStudent(newStudent);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
}
