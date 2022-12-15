package com.example.ApiDemo.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService
{
    private final StudentRepository _studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        _studentRepository = studentRepository;
    }

    public List<Student> getAllStudent()
    {
        return _studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> findByEmail = _studentRepository.findByEmail(student.getEmail());
        if (findByEmail.isPresent()){
            throw new IllegalStateException("Email is already exit");
        }
        _studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exits = _studentRepository.existsById(studentId);
        if (!exits){
            throw new IllegalStateException("student is not exit" + studentId);
        }
        _studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long id,String name,String email)
    {
        Student student = _studentRepository.findById(id).orElseThrow( () -> new IllegalStateException(""));
        if(name!=null && name.length() >0 && Objects.equals(name,student.getFirstName())){
            student.setFirstName(name);
        }
        if(email != null && email.length()>0 && Objects.equals(email,student.getEmail())){
            student.setEmail(email);
        }
    }
}
