package com.studentperformance.student;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Size(max = 120)
    @Column(nullable = false, length = 120)
    private String name;

    @Email @Size(max = 180)
    @Column(unique = true, length = 180)
    private String email;

    @Size(max = 80)
    private String className;

    @Size(max = 40)
    private String rollNumber;

    private LocalDateTime createdAt = LocalDateTime.now();

    protected Student() {}

    public Student(String name, String email, String className, String rollNumber) {
        this.name = name; this.email = email; this.className = className; this.rollNumber = rollNumber;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}