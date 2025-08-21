package org.example;

import jdk.nio.mapmode.ExtendedMapMode;
import org.example.Repository.CoursRepository;
import org.example.Repository.ExamRepository;
import org.example.Repository.StudentRepository;
import org.example.entity.Adress;
import org.example.entity.Cours;
import org.example.entity.Exam;
import org.example.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = entityManagerFactory.createEntityManager();

        StudentRepository studentRepository = new StudentRepository(em);
        ExamRepository examRepository = new ExamRepository(em);
        CoursRepository coursRepository = new CoursRepository(em);

//        Student student = Student.builder()
//                .firstname("toto")
//                .lastname("titi")
//                .classe("classe1")
//                .adress(new Adress("128","street","city","59000"))
//                .build();
//
//        studentRepository.save(student);
//
//        Exam exam = Exam.builder()
//                .date(LocalDate.now())
//                .grade(12.5f)
//                .subject("Maths")
//                .student(student)
//                .build();
//
//        examRepository.save(exam);

        Student student = studentRepository.findById(Student.class,1);
//
//        Cours cours = Cours.builder()
//                .hours(LocalDateTime.now())
//                .room("room")
//                .subject("subject")
//                .teacher("teacher")
//                .build();
//
//        cours.setStudents(Arrays.asList(student));
//
//        coursRepository.save(cours);
//
        System.out.println(
        examRepository.findByStudent(student)
        );

    }
}