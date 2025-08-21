package org.example.util;

import org.example.DAO.StudentDAO;
import org.example.entity.Student;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Ihm {
    private Scanner scanner;
    private StudentDAO studentDAO;

    public Ihm() {
        scanner = new Scanner(System.in);
        studentDAO = new StudentDAO();
    }

    public void start(){
        String entry ;
        while (true){
            showMenu();
            entry = scanner.nextLine();
            switch (entry){
                case "1" -> createStudent();
                case "2" -> showAllStudent();
                case "3" -> showStudentByClass();
                case "4" -> deleteStudent();
            }
        }
    }

    private void showMenu (){
        System.out.println("""
                ---- student app ----
                1/ create student
                2/ get all student
                3/ get student by class
                4/ delete student
                """);
    }

    private void createStudent(){
        System.out.println("--- add student ---");
        System.out.println("firstname :");
        String firstname = scanner.nextLine();

        System.out.println("lastname :");
        String lastname = scanner.nextLine();

        System.out.println("classNumber :");
        int classNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("diplomeDate : (dd-MM-yyyy)");
        String dateStr = scanner.nextLine();

        LocalDate dateDiplome = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        Student student = Student.builder().firstname(firstname).lastname(lastname).classNumber(classNumber).diplomeDate(dateDiplome).build();

        studentDAO.addStudent(student);

    }

    private void showAllStudent(){
        System.out.println("--- all student ---");
        for (Student student : studentDAO.getAllStudent()){
            System.out.println(student);
        }
//        studentDAO.getAllStudent().forEach(System.out::println);
    }

    private void showStudentByClass(){
        System.out.println("--- Student by class ---");
        System.out.println("class number :");
        int classNumber = scanner.nextInt();
        scanner.nextLine();

        List<Student> students = studentDAO.getAllStudentByClass(classNumber);

        for (Student student : students){
            System.out.println(student);
        }
    }

    private void deleteStudent(){
        System.out.println("--- delete Student ---");
        showAllStudent();

        System.out.println("id student :");
        int id = scanner.nextInt();
        scanner.nextLine();

        if(studentDAO.deleteStudent(id)){
            System.out.println("Student delete");
        }else{
            System.out.printf("error durieng deletion");
        }
    }

}

