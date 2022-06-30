package com.example.SMS.controller;

import com.example.SMS.Models.studentsModel;
import com.example.SMS.Services.studentsServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentsControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private studentsServices studentsServices;

    studentsModel student = new studentsModel(2,"Rick","Williams","rickWilliams@gmail.com","2044 W 138th ter","Leawood","Kansas City",66223,"USA");

    @Test
    public void testSaveStudentSuccess() throws Exception {
        String convertStudent = this.covertToJson(student);
        String URL = "/students/create";
        Mockito.when(studentsServices.saveStudent(Mockito.any(studentsModel.class))).thenReturn("Student Added");
        //sending request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).content(convertStudent).contentType(MediaType.APPLICATION_JSON);
        //getting result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //getting response
        MockHttpServletResponse response = result.getResponse();
        String output = response.getContentAsString();
        assertThat(output).isEqualTo("Student Added");
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    @Test
    public void testGetStudentById() throws Exception {
        Mockito.when(studentsServices.getStudent(Mockito.anyLong())).thenReturn(student);

        String URI = "/students/2";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String convertStudent = this.covertToJson(student);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(convertStudent);
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testGetAllStudents() throws Exception {
        List<studentsModel> studentsList = new ArrayList<>();
        studentsList.add(student);
        Mockito.when(studentsServices.getAllStudents()).thenReturn(studentsList);
        String URI = "/students/all";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.covertToJson(studentsList);
        String outputInJson = result.getResponse().getContentAsString();
        MockHttpServletResponse response = result.getResponse();
        assertThat(outputInJson).isEqualTo(expectedJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testUpdateStudent() throws Exception {
        studentsModel student = new studentsModel();
        student.setId(2);
        student.setFirst_name("Rick");
        student.setLast_name("Williams");
        student.setEmail_id("rickWilliams123@gmail.com");
        student.setAddress("2044 W 138th ter");
        student.setCity("Leawood");
        student.setState("Kansas City");
        student.setZipcode(66223);
        student.setCountry("USA");
        String convertData = this.covertToJson(student);
        Mockito.when(studentsServices.updateStudent(Mockito.any(studentsModel.class))).thenReturn(student);
        String URL = "/students/";
        //sending request
        RequestBuilder requestBuilder = MockMvcRequestBuilders.patch(URL).content(convertData).contentType(MediaType.APPLICATION_JSON);
        //getting result
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        //getting response
        MockHttpServletResponse response = result.getResponse();
        String output = response.getContentAsString();
        assertThat(output).isEqualTo(convertData);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testDeleteStudent() throws Exception{
        Mockito.when(studentsServices.deleteStudent(Mockito.anyLong())).thenReturn("Student is deleted");
        String  URL = "/students/2";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(URL).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        String output = result.getResponse().getContentAsString();
        System.out.println(output);
        MockHttpServletResponse response = result.getResponse();
        assertThat(output).isEqualTo("Student is deleted");
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    private String covertToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
