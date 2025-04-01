package org.example.ExoHibernate;

import org.example.ExoHibernate.Entity.Adresse;
import org.example.ExoHibernate.Entity.Course;
import org.example.ExoHibernate.Entity.Exam;
import org.example.ExoHibernate.Entity.Student;
import org.example.ExoHibernate.Repository.AdresseRepository;
import org.example.ExoHibernate.Repository.CourseRepository;
import org.example.ExoHibernate.Repository.ExamRepository;
import org.example.ExoHibernate.Repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        // Initialisation des repositories
        StudentRepository studentRepo = new StudentRepository(em);
        AdresseRepository adresseRepo = new AdresseRepository(em);
        ExamRepository examRepo = new ExamRepository(em);
        CourseRepository courseRepo = new CourseRepository(em);

        // Démarrer la transaction
        em.getTransaction().begin();

        // Création des objets
        Adresse adresse = Adresse.builder().street("11 rue de la Republique").city("Lille").codePostal("59000").build();
        Adresse adresse2 = Adresse.builder().street("44 rue de Rue").city("Ville").codePostal("(59589").build();


        Course course1 = Course.builder().subject("test").teacher("Marta Doe").classroom("12").schedule("mar, 9h00").build();
        Course course2 = Course.builder().subject("test 2").teacher("John Smith").classroom("101").schedule("lun, 10h00").build();

        Exam exam1 = Exam.builder().subject("anglais").grade(18).build();
        Exam exam2 = Exam.builder().subject("géometrie").grade(16).build();

        Student student = Student.builder()
                .firstName("Titi")
                .lastName("Tata")
                .numeroClass("12")
                .adresse(adresse)
                .exams(Arrays.asList(exam1, exam2))
                .courses(Arrays.asList(course1, course2))
                .build();

        Student student1 = Student.builder()
                .firstName("Test")
                .lastName("Tata")
                .numeroClass("12")
                .adresse(adresse)
                .exams(Arrays.asList(exam1, exam2))
                .courses(Arrays.asList(course1, course2))
                .build();

// Ajouter le student aux courses
        course1.setStudents(Arrays.asList(student, student1));
        course2.setStudents(Arrays.asList(student, student1));

// Ajouter les courses au student
        student.setCourses(Arrays.asList(course1, course2));
        // Sauvegarde des entités
//        courseRepo.save(course);
        examRepo.save(exam1);
        examRepo.save(exam2);
        courseRepo.save(course1);
        courseRepo.save(course2);
        studentRepo.save(student);
        studentRepo.save(student1);

        em.getTransaction().commit();

    }
}
