package com.example.SMS.Models;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="students")
public class studentsModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name = "email_id")
    private String email_id;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String State;
    @Column(name="zipcode")
    private int zipcode;
    @Column(name="country")
    private String country;
}
