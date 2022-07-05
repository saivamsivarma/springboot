package com.example.SMS.Service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.SMS.Models.Courses;
import com.example.SMS.Models.studentsModel;
import com.example.SMS.Services.studentsServices;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class StudentServiceIT {
    @Autowired
    private studentsServices studentsServices;

//    studentsModel student = new studentsModel(1,"John","Williams","johnwilliams@gmail.com","1578 W Ramsey Drive","Mountain House","California",95315,"USA");
//   @Transactional
//    @Test
//    @Order(1)
//    public void testSaveStudent(){
//        assertThat(studentsServices.saveStudent(student)).isEqualTo("Student Added");
//    }
//
//    @Test
//    @Order(4)
//    public void testGetStudentById(){
//        assertThat(studentsServices.getStudent(1L)).isEqualTo(student);
//    }
//
//    @Test
//    @Order(2)
//    public void testGetStudents(){
//        List<studentsModel> studentsList = new ArrayList<>();
//        studentsList.add(student);
//        assertThat(studentsServices.getAllStudents()).isEqualTo(studentsList);
//    }
//
//    @Test
//    @Order(3)
//    public void testUpdateStudent(){
//        studentsModel student = new studentsModel();
//        student.setId(2);
//        student.setFirst_name("John");
//        student.setLast_name("Williams");
//        student.setEmail_id("johnwilliams@gmail.com");
//        student.setAddress("1578 W Ramsey Drive");
//        student.setCity("Mountain House");
//        student.setState("California");
//        student.setZipcode(95315);
//        student.setCountry("USA");
//        assertThat(studentsServices.updateStudent(student)).isEqualTo(student);
//    }
//
//    @Test
//    @Order(5)
//    public void testDeleteStudent(){
//        assertThat(studentsServices.deleteStudent(1)).isEqualTo("Student is deleted");
//    }
}
