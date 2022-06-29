package com.example.SMS.Service;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.SMS.Models.studentsModel;
import com.example.SMS.Services.studentsServices;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentServiceT {
    @Autowired
    private studentsServices studentsServices;

    @Test
    @Order(1)
    public void testSaveStudent(){
        studentsModel student = new studentsModel();
        student.setId(1);
        student.setFirst_name("John");
        student.setLast_name("Williams");
        student.setEmail_id("johnwilliams@gmail.com");
        student.setAddress("1578 W Ramsey Drive");
        student.setCity("Mountain House");
        student.setState("California");
        student.setZipcode(95315);
        student.setCountry("USA");
        assertThat(studentsServices.saveStudent(student)).isEqualTo(student);
    }

    @Test
    @Order(4)
    public void testGetStudentById(){
        studentsModel student = new studentsModel();
        student.setId(1);
        student.setFirst_name("John");
        student.setLast_name("Williams");
        student.setEmail_id("johnwilliams@gmail.com");
        student.setAddress("1578 W Ramsey Drive");
        student.setCity("Mountain House");
        student.setState("California");
        student.setZipcode(95315);
        student.setCountry("USA");
        assertThat(studentsServices.getStudent(1L)).isEqualTo(student);
    }

    @Test
    @Order(2)
    public void testGetStudents(){
        studentsModel student = new studentsModel();
        student.setId(1);
        student.setFirst_name("John");
        student.setLast_name("Williams");
        student.setEmail_id("johnwilliamse@gmail.com");
        student.setAddress("1578 W Ramsey Drive");
        student.setCity("Mountain House");
        student.setState("California");
        student.setZipcode(95315);
        student.setCountry("USA");
        List<studentsModel> studentsList = new ArrayList<>();
        studentsList.add(student);
        assertThat(studentsServices.getAllStudents()).isEqualTo(studentsList);
    }

    @Test
    @Order(3)
    public void testUpdateStudent(){
        studentsModel student = new studentsModel();
        student.setId(1);
        student.setFirst_name("John");
        student.setLast_name("Williams");
        student.setEmail_id("johnwilliams234@gmail.com");
        student.setAddress("1578 W Ramsey Drive");
        student.setCity("Mountain House");
        student.setState("California");
        student.setZipcode(95315);
        student.setCountry("USA");
        assertThat(studentsServices.updateStudent(1,student)).isEqualTo(student);
    }

    @Test
    @Order(5)
    public void testDeleteStudent(){
        studentsModel student = new studentsModel();
        student.setId(1);
        student.setFirst_name("John");
        student.setLast_name("Williams");
        student.setEmail_id("johnwilliams234@gmail.com");
        student.setAddress("1578 W Ramsey Drive");
        student.setCity("Mountain House");
        student.setState("California");
        student.setZipcode(95315);
        student.setCountry("USA");
        assertThat(studentsServices.deleteStudent(1)).isEqualTo(student);
    }

}
