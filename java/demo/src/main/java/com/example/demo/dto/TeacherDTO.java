package com.example.demo.dto;


import javax.validation.constraints.NotNull;

public class TeacherDTO extends UserDTO {

    @NotNull(message = "Subject cannot be null")
    private String subject;

    @NotNull(message = "Qualification cannot be null")
    private String qualification;

    // Getters and Setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
