package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable("id") Long id) {

        return studentService
                .getStudent(id)
                .orElse(new Student("newname2", "newemail2", LocalDate.now()  ));
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        System.out.println("DELETINGGG2 " + studentId);
        studentService.deleteStudent(studentId);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable("id") long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email ) {
        studentService.updateStudent(id, name, email);   // not implemented

    }

}
