package com.example.SMS.Models;

import lombok.*;


import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="students_courses")
public class Students_courses {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "student_id")
    private long student_id;

    @Column(name = "course_id")
    private long course_id;
}
