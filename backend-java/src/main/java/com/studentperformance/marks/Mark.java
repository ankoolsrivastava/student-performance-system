package com.studentperformance.marks;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "marks")
public class Mark {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Positive
    private Long studentId;
    @NotBlank @Size(max = 100)
    private String subject;
    @Size(max = 120)
    private String assessment;
    @NotNull @DecimalMin("0.0")
    private Double score;
    @NotNull @DecimalMin("0.1")
    private Double maxScore;
    private LocalDateTime createdAt = LocalDateTime.now();
    protected Mark() {}
    public Long getId(){return id;} public Long getStudentId(){return studentId;}
    public void setStudentId(Long v){studentId=v;} public String getSubject(){return subject;}
    public void setSubject(String v){subject=v;} public String getAssessment(){return assessment;}
    public void setAssessment(String v){assessment=v;} public Double getScore(){return score;}
    public void setScore(Double v){score=v;} public Double getMaxScore(){return maxScore;}
    public void setMaxScore(Double v){maxScore=v;} public LocalDateTime getCreatedAt(){return createdAt;}
}