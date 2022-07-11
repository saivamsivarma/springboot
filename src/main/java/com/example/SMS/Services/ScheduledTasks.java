package com.example.SMS.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private final studentsServices studentsServices;
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    public ScheduledTasks(studentsServices studentsServices) {
        this.studentsServices = studentsServices;
    }
    public static final SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(initialDelay = 60000,fixedDelay = 120000)
    public void reportNumberOfStudents(){
       int numberOfStudents =  studentsServices.getAllStudents().size();
       String jobTime = numberOfStudents+" --Task completed at-- "+time.format(new Date());
       log.info("Number of Students present {}",jobTime);
    }

}
