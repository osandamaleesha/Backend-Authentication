package com.example.demo.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDTO extends UserDTO {

    @NotNull(message = "Grade cannot be null")
    @Size(min = 1, max = 13, message = "Grade must be between 1 and 13")
    private int grade;

    @NotNull(message = "Major cannot be null")
    private String major;

    // Getters and Setters
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
