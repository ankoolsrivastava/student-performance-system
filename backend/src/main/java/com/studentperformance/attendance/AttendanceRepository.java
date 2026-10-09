package com.studentperformance.attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<AttendanceRecord, Long> {
    List<AttendanceRecord> findByStudentId(Long studentId);
}
