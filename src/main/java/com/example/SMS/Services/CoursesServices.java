package com.example.SMS.Services;

import com.example.SMS.Exceptions.SMSExceptions;
import com.example.SMS.Models.Course;
import com.example.SMS.Repository.coursesRepository;
import com.example.SMS.utils.ErrorMessages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServices {
    private final coursesRepository coursesRepository;

    public CoursesServices(coursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public Course createCourse(Course course){
        try{
            if(!course.getCrn().isEmpty() && !course.getCourse_name().isEmpty()
                    && !course.getDepartment_name().isEmpty() && !course.getInstructor().isEmpty()) coursesRepository.save(course);
            return course;
        }catch(RuntimeException e){
         throw new SMSExceptions(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
        }
    }

    public Course getCoursesById(long id){
        Course course = coursesRepository.findById(id);
        try{
            if(course ==null) throw new SMSExceptions(ErrorMessages.INTERNAL_SERVER_ERROR.getErrorMessage());
            return course;
        }catch (RuntimeException e){
            throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
        }
    }

    public List<Course> getAllCourses(){
        return coursesRepository.findAll();
    }

    public String deleteCourses(long id){
        try{
            Course courses = coursesRepository.findById(id);
            if(courses ==null) throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
            coursesRepository.deleteById(id);
            return "Course deleted";
        }catch (RuntimeException e){
            throw new SMSExceptions(ErrorMessages.COULD_NOT_DELETE_RECORD.getErrorMessage());
        }
    }

    public Course updateCourses(long id, Course newCourse){
        try{
            Course existingCourse = coursesRepository.findById(id);
            if(existingCourse==null) throw new SMSExceptions(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
            existingCourse.setCrn(newCourse.getCrn());
            existingCourse.setCourse_name(newCourse.getCourse_name());
            existingCourse.setDepartment_name(newCourse.getDepartment_name());
            existingCourse.setInstructor(newCourse.getInstructor());
            coursesRepository.save(existingCourse);
            return newCourse;
        }catch(RuntimeException e){
            throw new SMSExceptions(ErrorMessages.COUlD_NOT_UPDATE_RECORD.getErrorMessage());
        }


    }


}
