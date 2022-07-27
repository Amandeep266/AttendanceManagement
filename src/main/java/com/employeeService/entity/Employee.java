package com.employeeService.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @Column
    private String age;
    @Column
    private String department;

    @Column
    private String designation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private List<Attendance> attendence;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Attendance> getAttendence() {
        return attendence;
    }

    public void setAttendence(List<Attendance> attendence) {
        this.attendence = attendence;
    }


}
