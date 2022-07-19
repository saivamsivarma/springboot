package com.example.SMS.Repository;

import com.example.SMS.Models.*;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class StudentCourseCustomImpl implements StudentCourseCustom{
    @PersistenceContext
    EntityManager em;
    public static QStudents_courses qStudents_courses = QStudents_courses.students_courses;
    public static QstudentsModel qstudentsModel = QstudentsModel.studentsModel;
    public static QCourses qCourses = QCourses.courses;
    @Override
    public StudentCourse getAllRecords(long sid, long id) {
        JPAQuery<StudentCourse> jpaQuery = new JPAQuery<>(em);
        return  jpaQuery.from(qStudents_courses).where(qStudents_courses.student_id.eq(sid),qStudents_courses.course_id.eq(id)).fetchFirst();
    }

    @Override
    public Student getDetails(long id) {
        JPAQuery<Student> jpaQuery = new JPAQuery<>(em);

        return jpaQuery
                .from(qstudentsModel)
                .join(qStudents_courses).on(qstudentsModel.Id.eq(qStudents_courses.student_id)).fetchJoin()
                .join(qCourses).on(qStudents_courses.course_id.eq(qCourses.id)).fetchJoin()
                .where(qstudentsModel.Id.eq(id)).fetchFirst();
    }
}