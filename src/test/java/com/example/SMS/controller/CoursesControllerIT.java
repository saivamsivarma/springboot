package com.example.SMS.controller;

import com.example.SMS.Services.CoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class CoursesControllerIT {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CoursesServices coursesServices;

//    Set<Student> students = new HashSet<>();
//    Course course = new Course(1, "cs23456", "C# programming", "Shyam singh roy", "Computer science");
//
//    @Test
//    public void testCreateStudent() throws Exception {
//        String convertedData = covertToJson(course);
//        String URL = "/Course/create";
//        Mockito.when(coursesServices.createCourse(Mockito.any(Course.class))).thenReturn(course);
//        //sending request
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).content(convertedData).contentType(MediaType.APPLICATION_JSON);
//        //getting result
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        //getting response
//        MockHttpServletResponse response = result.getResponse();
//        String output = response.getContentAsString();
//        assertThat(output).isEqualTo(convertedData);
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//    }
//
//
//    @Test
//    public void testGetStudentById() throws Exception {
//        Mockito.when(coursesServices.getCoursesById(Mockito.anyLong())).thenReturn(course);
//
//        String URI = "/Course/get/1";
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        String convertedData = this.covertToJson(course);
//        String output = result.getResponse().getContentAsString();
//        assertThat(output).isEqualTo(convertedData);
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//    }
//
//    @Test
//    public void testGetAllStudents() throws Exception {
//        List<Course> courses = new ArrayList<>();
//        courses.add(course);
//        Mockito.when(coursesServices.getAllCourses()).thenReturn(courses);
//        String URL = "/Course/getAll";
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        String expectedJson = this.covertToJson(courses);
//        String output = result.getResponse().getContentAsString();
//        MockHttpServletResponse response = result.getResponse();
//        assertThat(output).isEqualTo(expectedJson);
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//    }
//
//   @Test
//    public void testUpdateStudent() throws Exception {
//       Course updatedCourse = new Course(1, "cs23456", "C# programming", "Shyam singh", "Computer science");
//
//        String convertedData = this.covertToJson(updatedCourse);
//        Mockito.when(coursesServices.updateCourses(1L,updatedCourse)).thenReturn(updatedCourse);
//        String URL = "/Course/update/1";
//        //sending request
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.patch(URL).content(convertedData).contentType(MediaType.APPLICATION_JSON);
//        //getting result
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        //getting response
//        MockHttpServletResponse response = result.getResponse();
//        String output = response.getContentAsString();
//        assertThat(output).isEqualTo(convertedData);
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//    }
//
//     @Test
//    public void testDeleteStudent() throws Exception{
//        Mockito.when(coursesServices.deleteCourses(Mockito.anyLong())).thenReturn("Course deleted");
//        String  URL = "/Course/delete/1";
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(URL).contentType(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        System.out.println(result.getResponse().getContentAsString());
//        String output = result.getResponse().getContentAsString();
//        System.out.println(output);
//        MockHttpServletResponse response = result.getResponse();
//        assertThat(output).isEqualTo("Course deleted");
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//    }
//
//    private String covertToJson(Object object) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(object);
//    }
}