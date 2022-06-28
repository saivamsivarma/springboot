package com.example.SMS.Repository;

import com.example.SMS.Models.studentsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentsRepository extends JpaRepository<studentsModel,Long> {
    studentsModel findById(long id);
}
