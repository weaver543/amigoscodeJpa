package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private   StudentRepository studentRepository;

    // put Autowired below for constructor injection, rather than above for field injection
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        System.out.println("adding " + student);
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new IllegalStateException("that student doesnt exist");
        }
    }

    public Optional<Student> getStudent(Long id) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            return Optional.of(studentOptional.get());
        } else {
            return Optional.empty();
        }
    }

    public void updateStudent(long id, String name, String email) {
        if (studentRepository.existsById(id)) {
            Optional<Student> studentOptional = studentRepository.findById(id);
        }
    }
}
