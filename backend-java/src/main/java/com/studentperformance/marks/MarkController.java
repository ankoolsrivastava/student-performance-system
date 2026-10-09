package com.studentperformance.marks;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarkController {
    private final MarkRepository marks;
    public MarkController(MarkRepository marks){this.marks=marks;}
    @GetMapping public List<Mark> list(@RequestParam(required=false) Long studentId){
        return studentId == null ? marks.findAll() : marks.findByStudentId(studentId);
    }
    @GetMapping("/{id}") public Mark get(@PathVariable Long id){
        return marks.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Mark not found"));
    }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Mark create(@Valid @RequestBody Mark mark){
        validateScore(mark); return marks.save(mark);
    }
    @PutMapping("/{id}") public Mark update(@PathVariable Long id,@Valid @RequestBody Mark input){
        Mark mark=get(id); mark.setStudentId(input.getStudentId()); mark.setSubject(input.getSubject());
        mark.setAssessment(input.getAssessment()); mark.setScore(input.getScore()); mark.setMaxScore(input.getMaxScore());
        validateScore(mark); return marks.save(mark);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){marks.delete(get(id));}
    private void validateScore(Mark m){
        if(m.getScore()!=null && m.getMaxScore()!=null && m.getScore()>m.getMaxScore())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Score cannot exceed maxScore");
    }
}