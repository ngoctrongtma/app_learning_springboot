//package com.first_app.app_learning_springboot.student;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.Period;
//
//@Entity // this is for hibernate
//@Table // this is for the table in database
//public class Student {
//
//    public Integer getAge() {
//        return Period.between(this.birthday, LocalDate.now()).getYears();
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    @Id
//    @SequenceGenerator(
//            name = "student_sequence",
//            sequenceName = "student_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "student_sequence"
//    )
//    private Integer id;
//    private String name;
//    private String email;
//    private LocalDate birthday;
//
//    @Transient
//    private Integer age;
//
//    public Student() {
//    }
//
//    public Student(Integer id, String name, String email, LocalDate birthday) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.birthday = birthday;
//    }
//
//    public Student(String name, String email, LocalDate birthday) {
//        this.name = name;
//        this.email = email;
//        this.birthday = birthday;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public LocalDate getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(LocalDate birthday) {
//        this.birthday = birthday;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", birthday=" + birthday +
//                ", age=" + this.getAge() +
//                '}';
//    }
//}
