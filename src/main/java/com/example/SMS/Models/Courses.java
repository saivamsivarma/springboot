package com.example.SMS.Models;
import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name="CRN")
    private String crn;
    @Column(name="Course_Name")
    private String course_Name;
    @Column(name="semester")
    private String semester;
    @Column(name="Year")
    private String Year;
    @Column(name="capacity")
    private Integer capacity;
    @Column(name="department_name")
    private String department_name;
}
