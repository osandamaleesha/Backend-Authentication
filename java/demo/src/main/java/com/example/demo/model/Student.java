package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    // Attributes
    private List<Teacher> savedTeachers;  // List of saved teachers

    // Constructor
    public Student(String emailAddress, String password, String firstName, String lastName, String gender, String profilePic) {
        super(emailAddress, password, firstName, lastName, gender, profilePic, "STUDENT");  // Calling the parent constructor with "STUDENT" role
        this.savedTeachers = new ArrayList<>();  // Initialize the list of saved teachers
    }

    // Getters and Setters
    public List<Teacher> getSavedTeachers() {
        return savedTeachers;
    }

    public void setSavedTeachers(List<Teacher> savedTeachers) {
        this.savedTeachers = savedTeachers;
    }

    // Methods

    // Watch videos method
    public void watchVideos(List<Video> videos) {
        System.out.println("Displaying videos for student:");
        for (Video video : videos) {
            System.out.println("Watching video: " + video.getTitle());
        }
        // Logic to display and play videos for the student
    }

    // Save a teacher's profile to the student's saved list
    public void saveTeacher(Teacher teacher) {
        if (!savedTeachers.contains(teacher)) {
            savedTeachers.add(teacher);
            System.out.println("Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " saved successfully.");
        } else {
            System.out.println("Teacher is already saved.");
        }
        // Logic to save the teacher's profile to the student's savedTeachers list
    }

    // Review a teacher
    public void reviewTeacher(Teacher teacher, String review, int rating) {
        System.out.println("Reviewing teacher: " + teacher.getFirstName() + " " + teacher.getLastName());
        System.out.println("Review: " + review + ", Rating: " + rating + "/5");
        // Logic to submit a review and rating for a teacher
    }

    // Delete a review for a teacher
    public void deleteReview(Teacher teacher) {
        System.out.println("Review deleted for teacher: " + teacher.getFirstName() + " " + teacher.getLastName());
        // Logic to delete a review for the given teacher
    }
}
