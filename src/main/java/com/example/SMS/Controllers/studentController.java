package com.example.SMS.Controllers;

import com.example.SMS.Models.studentsModel;
import com.example.SMS.Repository.studentsRepository;
import com.example.SMS.Services.studentsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentController {
    private final studentsRepository studentsRepository;
    private final studentsServices studentsServices;

    public studentController(studentsRepository studentsRepository, com.example.SMS.Services.studentsServices studentsServices) {
        this.studentsRepository = studentsRepository;
        this.studentsServices = studentsServices;
    }


    @GetMapping("/all")
    public ResponseEntity<List<studentsModel>> getStudents(){
        List<studentsModel> studentList = studentsServices.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<studentsModel> createStudent(@RequestBody studentsModel student){
        studentsModel newStudent = studentsServices.saveStudent(student);
        return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<studentsModel> getStudent(@PathVariable long id){
        studentsModel student = studentsServices.getStudent(id);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<studentsModel> deleteStudent(@PathVariable long id){
        studentsModel deleteStudent =  studentsServices.deleteStudent(id);
        return new ResponseEntity<>(deleteStudent,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<studentsModel> updateStudent(@PathVariable long id,@RequestBody studentsModel newStudent){
        studentsModel student = studentsServices.updateStudent(id,newStudent);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
}
