package com.example.SMS.Controllers;

import com.example.SMS.Models.studentsModel;
import com.example.SMS.Repository.studentsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class studentController {
    private final studentsRepository studentsRepository;

    public studentController(studentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }


    @GetMapping("/all")
    public ResponseEntity<List<studentsModel>> getAllStudents(){
        return ResponseEntity.ok(studentsRepository.findAll());
    }

    @PostMapping("/create")
    public studentsModel createStudent(@RequestBody studentsModel student){
        return studentsRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<studentsModel>> deleteStudent(@PathVariable long id){
        studentsRepository.deleteById(id);
        return ResponseEntity.ok(studentsRepository.findAll());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<studentsModel> updateStudent(@PathVariable long id,@RequestBody studentsModel newStudents){
        studentsModel student = studentsRepository.findById(id);
        student.setFirst_name(newStudents.getFirst_name());
        student.setLast_name(newStudents.getLast_name());
        student.setEmail_id(newStudents.getEmail_id());
        student.setAddress(newStudents.getAddress());
        student.setCity(newStudents.getCity());
        student.setState(newStudents.getState());
        student.setZipcode(newStudents.getZipcode());
        student.setCountry(newStudents.getCountry());
        studentsRepository.save(student);
        return ResponseEntity.ok(student);
    }
}
