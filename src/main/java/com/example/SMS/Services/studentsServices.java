package com.example.SMS.Services;
import com.example.SMS.Exceptions.SMSExceptions;
import com.example.SMS.Models.Courses;
import com.example.SMS.Models.Students_courses;
import com.example.SMS.Models.studentsModel;
import com.example.SMS.Repository.StudentCoursesRepository;
import com.example.SMS.Repository.coursesRepository;
import com.example.SMS.Repository.studentsRepository;
import com.example.SMS.utils.ErrorMessages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentsServices {
    private final studentsRepository studentsRepository;
    private final StudentCoursesRepository studentCoursesRepository;


    private final coursesRepository coursesRepository;
    public studentsServices(studentsRepository studentsRepository, StudentCoursesRepository studentCoursesRepository, coursesRepository coursesRepository) {
        this.studentsRepository = studentsRepository;
        this.studentCoursesRepository = studentCoursesRepository;
        this.coursesRepository = coursesRepository;
    }

    public List<studentsModel> getAllStudents(){
        List<studentsModel> studentsList;
        try{
            studentsList = studentsRepository.findAll();
            if(studentsList.isEmpty()) throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
            return  studentsList;
        }catch(RuntimeException e) {
            throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
        }
    }

    public String saveStudent(studentsModel student){
        try{
            if(!student.getFirst_name().isEmpty() && !student.getLast_name().isEmpty() && !student.getEmail_id().isEmpty()
                    && !student.getAddress().isEmpty() && !student.getCity().isEmpty() && !student.getCountry().isEmpty() && !student.getZipcode().equals("")){
                studentsRepository.save(student);
            }
            return "Student Added";
        }catch (RuntimeException e){
            throw new SMSExceptions(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
        }
    }

    public studentsModel getStudent (long id){
        studentsModel student;
        try{
            student = studentsRepository.findById(id);
            return student;
        }catch (NullPointerException e){
            throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
        }
    }

    public studentsModel updateStudent(long id, studentsModel newStudent){
            try{
            studentsModel existingStudent = studentsRepository.findById(id);
            if(existingStudent ==null) throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
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
            }catch(RuntimeException e){
                throw  new SMSExceptions(ErrorMessages.COUlD_NOT_UPDATE_RECORD.getErrorMessage());
            }
    }

    public String deleteStudent(long id) {
        try{
            studentsModel student = studentsRepository.findById(id);
            if(student ==null) throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
            studentsRepository.deleteById(id);
            return "Student is deleted";
        }catch (RuntimeException e){
            throw new SMSExceptions(ErrorMessages.COULD_NOT_DELETE_RECORD.getErrorMessage());
        }
    }

    public String addCourse(long sid,long id) {
        try{
            studentsModel student =studentsRepository.findById(sid);
            Courses course = coursesRepository.findById(id);
            if(course == null && student ==null) throw new SMSExceptions(ErrorMessages.INTERNAL_SERVER_ERROR.getErrorMessage());
            String course_name = course.getCourse_name();
            if(student.getCourses().contains(course)) throw new SMSExceptions(ErrorMessages.COURSE_ALREADY_ENROLLED.getErrorMessage());
            student.getCourses().add(course);
            studentsRepository.save(student);
            return "Student successfully enrolled into "+course_name;
        }catch (RuntimeException e){
            throw new SMSExceptions(ErrorMessages.COURSE_ADDED_FAILED.getErrorMessage());
        }
    }

    public List<Courses> enrolledCourses(long id){
        List<Courses> coursesList;
        try{
            studentsModel student = studentsRepository.findById(id);
            coursesList =  student.getCourses();
            return coursesList;
        }catch (RuntimeException e){
            throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
        }
    }

    public String disEnroll(long sid,long id){
        try{
            Students_courses enrolledRecord  = studentCoursesRepository.getAllRecords(sid,id);
            studentCoursesRepository.delete(enrolledRecord);
            return "student disEnrolled";
        }catch (RuntimeException e){
            throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
        }
    }

    public Object getDetails(long id) {
        Object result;
        try{
            result = studentCoursesRepository.getDetails(id);
            return result;
        }catch(RuntimeException e){
            throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
        }
    }
}