package com.example.SMS.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "courses")
    @JsonIgnore
    private Set<studentsModel> students = new HashSet<>();
}