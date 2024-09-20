package com.example.demo.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class StudentRequest {

    private UUID id; // Optional: include if the ID is provided in the request, e.g., for updates

    @NotNull(message = "Grade cannot be null")
    @Size(min = 1, max = 50, message = "Grade must be between 1 and 50 characters")
    private String grade;

    @NotNull(message = "Major cannot be null")
    @Size(min = 1, max = 50, message = "Major must be between 1 and 50 characters")
    private String major;

    // Getters and setters...
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}
