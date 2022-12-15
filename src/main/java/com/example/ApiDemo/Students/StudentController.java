package com.example.ApiDemo.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController
{
    private final StudentService _studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        _studentService = studentService;
    }

    @GetMapping("getAll")
    public List<Student> getAllStudent()
    {
        return _studentService.getAllStudent();
    }
    @PostMapping("create")
    public void registerStudent(@RequestBody Student student)
    {
        _studentService.addStudent(student);
    }
    @DeleteMapping(path = {"studentId"})
    public void deleteStudent(@PathVariable("studentId") Long studentId)
    {
        _studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "studentId")
    public void updateStudent(@PathVariable("studentId") Long studentId,@RequestParam(required = false) String name,@RequestParam(required = false) String email)
    {
    _studentService.updateStudent(studentId,name,email);
    }
}
