package org.example.Repository;

import org.example.entity.Exam;
import org.example.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ExamRepository extends BaseRepository<Exam> {
    public ExamRepository(EntityManager em) {
        super(em);
    }

    public List<Exam> findByStudent (Student student){
        Query query =  em.createQuery("Select e From Exam as e where e.student = :student",Exam.class);
        query.setParameter("student",student);
        return query.getResultList();
    }
}
