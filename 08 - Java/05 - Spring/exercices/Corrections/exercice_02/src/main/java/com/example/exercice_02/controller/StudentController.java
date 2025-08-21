package com.example.exercice_02.controller;

import com.example.exercice_02.model.Student;
import com.example.exercice_02.service.StudentService;
import com.example.exercice_02.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class StudentController {
    private final UserService userService;
    private String location = "src/main/resources/static/image";
    private final StudentService studentService;


    public StudentController(StudentService studentService, UserService userService) {
        this.studentService = studentService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/formulaire")
    public String formAddStudent(Model model){
        if(userService.isLogged()){
            model.addAttribute("student", new Student());
            return "form";
        }
        return "redirect:/login";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult,
                             @RequestParam("image")MultipartFile image
                             ) throws IOException {
        if(bindingResult.hasErrors()){
            return "form";
        } else {
            if (student.getId() != null) {
                studentService.updateStudent(student.getId(), student);
            } else {
                Path destination = Paths.get(location).resolve(image.getOriginalFilename()).toAbsolutePath();
                student.setPhoto(image.getOriginalFilename());
                InputStream inputStream = image.getInputStream();
                Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
                studentService.createStudent(student);
            }
        }
        return "redirect:/students";
    }

    @RequestMapping("/students") // /students?search=toto
    public String listStudents(@RequestParam(name = "search", required = false) String search, Model model){
        if(userService.isLogged()) {
            if (search == null) {
                model.addAttribute("students", studentService.getStudents());
            } else {
                model.addAttribute("students", studentService.getStudentsByName(search));
            }
            return "students";
        }
        return "redirect:/login";
    }

    @RequestMapping("/student/{id}")
    public String ShowStudent(@PathVariable Long id, Model model){
        if(userService.isLogged()) {
            model.addAttribute("student", studentService.getStudentById(id));
            return "detail";
        }
        return "redirect:/login";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("studentId") Long id){
        if(userService.isLogged()) {
            studentService.deleteStudent(id);
            return "redirect:/students";
        }
        return "redirect:/login";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("studentId") Long id, Model model){
        if(userService.isLogged()) {
            model.addAttribute("student", studentService.getStudentById(id));
            return "form";
        }
        return "redirect:/login";
    }
}
