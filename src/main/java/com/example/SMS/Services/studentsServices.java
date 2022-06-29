package com.example.SMS.Services;

import com.example.SMS.Models.studentsModel;
import com.example.SMS.Repository.studentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class studentsServices {
    private final studentsRepository studentsRepository;

    public studentsServices(studentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<studentsModel> getAllStudents(){
      return  studentsRepository.findAll();
    }

    public studentsModel saveStudent(studentsModel student){
        return studentsRepository.save(student);
    }

    public studentsModel getStudent (long id){
        return studentsRepository.findById(id);
    }

    public studentsModel updateStudent(long id,studentsModel newStudent){
        studentsModel existingStudent = studentsRepository.findById(id);
        existingStudent.setFirst_name(newStudent.getFirst_name());
        existingStudent.setLast_name(newStudent.getLast_name());
        existingStudent.setEmail_id(newStudent.getEmail_id());
        existingStudent.setAddress(newStudent.getAddress());
        existingStudent.setCity(newStudent.getCity());
        existingStudent.setState(newStudent.getState());
        existingStudent.setZipcode(newStudent.getZipcode());
        existingStudent.setCountry(newStudent.getCountry());
        studentsRepository.save(existingStudent);
        return existingStudent;
    }

    public studentsModel deleteStudent(long id) {
        studentsModel student = studentsRepository.findById(id);
        studentsRepository.deleteById(id);
        return student;
    }
}
