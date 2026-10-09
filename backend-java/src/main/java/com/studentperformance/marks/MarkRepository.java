package com.studentperformance.marks;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> findByStudentId(Long studentId);
}