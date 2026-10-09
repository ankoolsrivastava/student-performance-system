package com.studentperformance.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository students;
    public StudentController(StudentRepository students) { this.students = students; }

    @GetMapping
    public List<Student> list() { return students.findAll(); }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return students.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody Student student) {
        student.setName(student.getName().trim());
        return students.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @Valid @RequestBody Student input) {
        Student student = get(id);
        student.setName(input.getName().trim());
        student.setEmail(input.getEmail());
        student.setClassName(input.getClassName());
        student.setRollNumber(input.getRollNumber());
        return students.save(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { students.delete(get(id)); }
}