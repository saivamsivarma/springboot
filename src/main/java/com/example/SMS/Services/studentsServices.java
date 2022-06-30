package com.example.SMS.Services;
import com.example.SMS.Models.studentsModel;
import com.example.SMS.Repository.studentsRepository;
import org.springframework.stereotype.Service;

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

    public String saveStudent(studentsModel student){
        if(student.getFirst_name().equals("")&&student.getLast_name().equals("")&&student.getEmail_id().equals("")&& student.getAddress().equals("")&&student.getCity().equals("")&&student.getState().equals("")&&student.getCountry().equals("")&&student.getZipcode().equals("")) return "Fill all the required Fields";
        else studentsRepository.save(student); return "Student Added";
    }

    public studentsModel getStudent (long id){
        return studentsRepository.findById(id);
    }

    public studentsModel updateStudent(studentsModel newStudent){
        long id = newStudent.getId();
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

    public String deleteStudent(long id) {
        studentsRepository.deleteById(id);
        return "Student is deleted";
    }
}
