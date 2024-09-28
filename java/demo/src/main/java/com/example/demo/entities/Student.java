package com.example.demo.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "STUDENT_DETAILS")
public class Student extends User {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "GRADE")
    private String grade;

    @Column(name = "MAJOR")
    private String major;

    public void onCreate() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }

    // Getters and setters...
    @Override
    public UUID getId() {
        return id != null ? id : super.getId(); // Fallback to User's ID
    }

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

    public void setId(UUID id) {
        this.id = id;
    }
}
