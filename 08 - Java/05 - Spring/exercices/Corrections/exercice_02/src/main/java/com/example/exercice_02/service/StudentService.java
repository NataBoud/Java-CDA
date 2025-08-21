package com.example.exercice_02.service;

import com.example.exercice_02.dao.StudentRepository;
import com.example.exercice_02.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

//    private List<Student> students = new ArrayList<>();
//    private Long currentId = 1L;
//
    public StudentService(StudentRepository studentRepository) {
//        Student student = new Student(currentId++, "John", "Doe", "John@email.fr", 20);
//        students.add(student);
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findAllByLastname(name);
    }

    public Student createStudent(Student student) {
//       student.setId(currentId++);
//       students.add(student);
       return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
//        students.removeIf(student -> student.getId().equals(id));
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        Student studentExist = getStudentById(id);
        if (studentExist != null) {
//            studentExist.setLastname(student.getLastname());
//            studentExist.setFirstname(student.getFirstname());
//            studentExist.setEmail(student.getEmail());
//            studentExist.setAge(student.getAge());
            studentRepository.save(student);
        }
        return studentExist;
    }
}
