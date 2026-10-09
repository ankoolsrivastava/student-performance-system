package com.studentperformance.attendance;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceRepository attendance;
    public AttendanceController(AttendanceRepository attendance){this.attendance=attendance;}
    @GetMapping public List<AttendanceRecord> list(@RequestParam(required=false) Long studentId){
        return studentId==null?attendance.findAll():attendance.findByStudentId(studentId);
    }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public AttendanceRecord create(@Valid @RequestBody AttendanceRecord record){
        return attendance.save(record);
    }
    @PutMapping("/{id}") public AttendanceRecord update(@PathVariable Long id,@Valid @RequestBody AttendanceRecord input){
        AttendanceRecord r=attendance.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Attendance record not found"));
        r.setStudentId(input.getStudentId()); r.setAttendanceDate(input.getAttendanceDate()); r.setStatus(input.getStatus());
        return attendance.save(r);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){
        if(!attendance.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Attendance record not found");
        attendance.deleteById(id);
    }
}