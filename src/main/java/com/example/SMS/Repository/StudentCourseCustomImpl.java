package com.example.SMS.Repository;

import com.example.SMS.Models.Students_courses;
import com.example.SMS.Models.QStudents_courses;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class StudentCourseCustomImpl implements StudentCourseCustom{
    @PersistenceContext
    EntityManager em;
    public static QStudents_courses qStudents_courses = QStudents_courses.students_courses;
    @Override
    public Students_courses getAllRecords(long sid,long id) {
        JPAQuery<Students_courses> jpaQuery = new JPAQuery<>(em);
        return  jpaQuery.from(qStudents_courses).where(qStudents_courses.student_id.eq(sid),qStudents_courses.course_id.eq(id)).fetchFirst();
    }
}
