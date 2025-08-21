package org.example.Repository;

import org.example.entity.Student;
import org.example.exception.NotFoundException;

import javax.persistence.EntityManager;

public class StudentRepository extends BaseRepository<Student> {
    public StudentRepository(EntityManager em) {
        super(em);
    }

    public Student update (Student student){
        try{
            Student studentfound = findById(Student.class,student.getId());

            em.getTransaction().begin();
            studentfound.setAdress(student.getAdress());
            studentfound.setFirstname(student.getFirstname());
            studentfound.setLastname(student.getLastname());
            studentfound.setClasse(student.getClasse());
            em.getTransaction().commit();
            return studentfound;
        }catch (NotFoundException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
