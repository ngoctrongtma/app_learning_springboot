//package com.first_app.app_learning_springboot.student;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "api/v1/student")
//public class StudentController {
//    private final StudentService studentService;
//
//    @Autowired
//    public StudentController(StudentService studentService){
//        this.studentService = studentService;
//    }
//
//    @GetMapping
//    public List<Student> getStudents(){
//        return studentService.getStudents();
//    }
//
//    @GetMapping(path = "{studentId}")
//    public Student getStudentById(@PathVariable("studentId") Integer studentId){
//        return studentService.getStudentById(studentId);
//    }
//
//    @PostMapping
//    public void registerNewStudent(@RequestBody Student student){
//        studentService.addNewStudent(student);
//    }
//    @DeleteMapping(path =  "{studentId}")
//    public void deleteStudent(@PathVariable("studentId") Integer studentId){
//        studentService.deleteStudent(studentId);
//    }
//    @PutMapping(path = "{studentId}")
//    public void updateStudent(
//            @PathVariable("studentId") Integer studentId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String email
//    ){
//        studentService.updateStudent(studentId, name, email);
//    }
//}
