package com.example.demo.entities;



import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_DETAILS")
public class Student extends User {

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "MAJOR")
    private String major;

    // Getters and setters...

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
