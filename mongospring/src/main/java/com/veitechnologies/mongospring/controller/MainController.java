package com.veitechnologies.mongospring.controller;

import com.veitechnologies.mongospring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.veitechnologies.mongospring.repository.studentRepo;

import java.util.List;

@RestController
public class MainController {

    @Autowired

    studentRepo studentrepo;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        studentrepo.save(student);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentrepo.findById(id).orElse(null);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent()
    {
        return studentrepo.findAll();
    }

    @PutMapping("/updateStudent")
    public void updateStudent(@RequestBody Student student){
        Student data = studentrepo.findById(student.getRno()).orElse(null);
        System.out.println(data);
        if(data!=null){
            data.setName(student.getName());
            data.setAddress(student.getAddress());
            studentrepo.save(data);
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentrepo.deleteById(id);
    }
}
