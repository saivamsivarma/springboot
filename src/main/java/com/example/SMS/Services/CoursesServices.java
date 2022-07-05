package com.example.SMS.Services;

import com.example.SMS.Models.Courses;
import com.example.SMS.Repository.coursesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServices {
    private final coursesRepository coursesRepository;

    public CoursesServices(coursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    public Courses createCourse(Courses course){
        return coursesRepository.save(course);
    }

    public Courses getCoursesById(long id){
        return coursesRepository.findById(id);
    }

    public List<Courses> getAllCourses(){
        return coursesRepository.findAll();
    }

    public String deleteCourses(long id){
        coursesRepository.deleteById(id);
        return "Course deleted";
    }

    public Courses updateCourses(long id,Courses newCourse){
        Courses existingCourse = coursesRepository.findById(id);
        existingCourse.setCrn(newCourse.getCrn());
        existingCourse.setCourse_name(newCourse.getCourse_name());
        existingCourse.setDepartment_name(newCourse.getDepartment_name());
        existingCourse.setInstructor(newCourse.getInstructor());
        coursesRepository.save(existingCourse);
        return existingCourse;
    }


}
