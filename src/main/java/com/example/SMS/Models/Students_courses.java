package com.example.SMS.Models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="students_courses")
public class Students_courses implements Serializable {

    @Id
    @Column(name = "student_id")
    private long student_id;

    @Column(name = "course_id")
    private long course_id;

    @CreatedDate
    @Column(name = "registerAt")
    private Date registerAt;
}
