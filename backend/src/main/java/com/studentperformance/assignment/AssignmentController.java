package com.studentperformance.assignment;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    private final AssignmentRepository assignments;
    public AssignmentController(AssignmentRepository assignments){this.assignments=assignments;}
    @GetMapping public List<Assignment> list(){return assignments.findAll();}
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Assignment create(@Valid @RequestBody Assignment a){return assignments.save(a);}
    @PutMapping("/{id}") public Assignment update(@PathVariable Long id,@Valid @RequestBody Assignment input){
        Assignment a=assignments.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Assignment not found"));
        a.setTitle(input.getTitle()); a.setSubject(input.getSubject()); a.setDescription(input.getDescription()); a.setDueDate(input.getDueDate());
        return assignments.save(a);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){
        if(!assignments.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Assignment not found");
        assignments.deleteById(id);
    }
}