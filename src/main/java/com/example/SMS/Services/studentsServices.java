package com.example.SMS.Services;
import com.example.SMS.Models.Courses;
import com.example.SMS.Models.Students_courses;
import com.example.SMS.Models.studentsModel;
import com.example.SMS.Repository.StudentCoursesRepository;
import com.example.SMS.Repository.coursesRepository;
import com.example.SMS.Repository.studentsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class studentsServices {
    private final studentsRepository studentsRepository;
    private final StudentCoursesRepository studentCoursesRepository;

    private final coursesRepository coursesRepository;
    public studentsServices(studentsRepository studentsRepository, StudentCoursesRepository studentCoursesRepository, com.example.SMS.Repository.coursesRepository coursesRepository) {
        this.studentsRepository = studentsRepository;
        this.studentCoursesRepository = studentCoursesRepository;
        this.coursesRepository = coursesRepository;
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

    public String addCourse(long sid,long id) {
        Courses course = coursesRepository.findById(id);
        String course_name = course.getCourse_name();
        studentsModel student =studentsRepository.findById(sid);
        student.getCourses().add(course);
        studentsRepository.save(student);
        return "Student successfully enrolled into "+course_name;
    }

    public List<Courses> enrolledCourses(long id){
        List<Courses> enrolled = new ArrayList<>();
        studentsModel student = studentsRepository.findById(id);
        if(!student.getCourses().isEmpty()){
            enrolled =  student.getCourses();
        }
        return enrolled;
    }

    public String disEnroll(long sid,long id){
            studentCoursesRepository.disEnroll(sid,id);
            return "student disEnrolled";
    }

}