package com.example.demo.model;

public class Notification {

    // Attributes
    private Teacher savedTeachers;

    // Constructor
    public Notification(Teacher savedTeachers) {
        this.savedTeachers = savedTeachers;
    }

    // Getter and Setter for savedTeachers
    public Teacher getSavedTeachers() {
        return savedTeachers;
    }

    public void setSavedTeachers(Teacher savedTeachers) {
        this.savedTeachers = savedTeachers;
    }

    // Methods

    // Simulates watching videos from a teacher
    public void watchVideos() {
        System.out.println("Watching videos from the teacher: " + savedTeachers.getFirstName() + " " + savedTeachers.getLastName());
    }

    // Saves the teacher to the user's saved teachers list
    public void saveTeacher() {
        System.out.println("Teacher " + savedTeachers.getFirstName() + " " + savedTeachers.getLastName() + " has been saved.");
    }

    // Allows a student to review a teacher
    public void reviewTeacher() {
        System.out.println("Reviewing teacher: " + savedTeachers.getFirstName() + " " + savedTeachers.getLastName());
    }

    // Deletes a review for a teacher
    public void deleteReview() {
        System.out.println("Review for the teacher " + savedTeachers.getFirstName() + " " + savedTeachers.getLastName() + " has been deleted.");
    }

}
