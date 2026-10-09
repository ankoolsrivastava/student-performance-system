package com.studentperformance.analysis;

import com.studentperformance.marks.Mark;
import com.studentperformance.marks.MarkRepository;
import com.studentperformance.student.Student;
import com.studentperformance.student.StudentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {
    private final StudentRepository students;
    private final MarkRepository marks;
    public AnalysisController(StudentRepository students, MarkRepository marks){this.students=students;this.marks=marks;}

    @GetMapping("/summary")
    public Map<String,Object> summary(){
        List<Student> allStudents=students.findAll();
        List<Mark> allMarks=marks.findAll();
        double earned=allMarks.stream().map(Mark::getScore).filter(Objects::nonNull).mapToDouble(Double::doubleValue).sum();
        double possible=allMarks.stream().map(Mark::getMaxScore).filter(Objects::nonNull).mapToDouble(Double::doubleValue).sum();
        double average=possible>0?Math.round(earned/possible*10000.0)/100.0:0.0;
        return Map.of("studentCount",allStudents.size(),"assessmentCount",allMarks.size(),"averagePercentage",average);
    }

    @GetMapping("/student/{studentId}")
    public Map<String,Object> studentSummary(@PathVariable Long studentId){
        Student student=students.findById(studentId).orElseThrow(()->new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND,"Student not found"));
        List<Mark> studentMarks=marks.findByStudentId(studentId);
        double earned=studentMarks.stream().map(Mark::getScore).filter(Objects::nonNull).mapToDouble(Double::doubleValue).sum();
        double possible=studentMarks.stream().map(Mark::getMaxScore).filter(Objects::nonNull).mapToDouble(Double::doubleValue).sum();
        return Map.of("studentId",student.getId(),"studentName",student.getName(),"assessmentCount",studentMarks.size(),
            "averagePercentage",possible>0?Math.round(earned/possible*10000.0)/100.0:0.0,"marks",studentMarks);
    }
}