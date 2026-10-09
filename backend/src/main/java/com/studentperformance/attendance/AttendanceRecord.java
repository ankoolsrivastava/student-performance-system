package com.studentperformance.attendance;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name="attendance_records", uniqueConstraints=@UniqueConstraint(columnNames={"student_id","attendance_date"}))
public class AttendanceRecord {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @NotNull @Positive private Long studentId;
    @NotNull private LocalDate attendanceDate;
    @NotBlank @Pattern(regexp="PRESENT|ABSENT|LATE") private String status;
    protected AttendanceRecord(){}
    public Long getId(){return id;} public Long getStudentId(){return studentId;}
    public void setStudentId(Long v){studentId=v;} public LocalDate getAttendanceDate(){return attendanceDate;}
    public void setAttendanceDate(LocalDate v){attendanceDate=v;} public String getStatus(){return status;}
    public void setStatus(String v){status=v==null?null:v.toUpperCase(java.util.Locale.ROOT);}
}