package com.studentperformance.assignment;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name="assignments")
public class Assignment {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotBlank @Size(max=160) private String title;
    @NotBlank @Size(max=100) private String subject;
    @Size(max=2000) private String description;
    private LocalDate dueDate;
    protected Assignment(){}
    public Long getId(){return id;} public String getTitle(){return title;} public void setTitle(String v){title=v;}
    public String getSubject(){return subject;} public void setSubject(String v){subject=v;}
    public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate v){dueDate=v;}
}