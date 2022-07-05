package com.example.SMS.Models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="crn")
    private String crn;
    @Column(name="course_name")
    private String course_name;
    @Column(name="instructor")
    private String instructor;
    @Column(name="department_name")
    private String department_name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "Students_courses",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<studentsModel> students = new ArrayList<>();
}