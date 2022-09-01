package com.ksyoo.demo.student;

import com.ksyoo.demo.basecontroller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController extends BaseController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public Student RegisterNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public Student deleteStudent(@PathVariable("studentId") Long id) {
        return studentService.deleteStudent(id);
    }

    @PatchMapping(path = "{studentId}")
    public Student updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody(required = false) StudentUpdateParam param
    ) {
        return studentService.updateStudent(studentId, param);
    }

}
