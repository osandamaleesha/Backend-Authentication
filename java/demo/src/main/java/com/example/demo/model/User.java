package com.example.demo.model;

import java.util.UUID;

public class User {

    // Attributes
    private String userId;
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String profilePic;
    private String role;

    // Constructor
    public User(String emailAddress, String password, String firstName, String lastName, String gender, String profilePic, String role) {

        this.userId = UUID.randomUUID().toString(); // Automatically generate unique userId
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.profilePic = profilePic;
        this.role = role;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Methods

    // Sign up method
    public void signup() {
        System.out.println("User signed up successfully!");
        // Logic to save user details to the database
    }

    // Login method
    public void login() {
        System.out.println("User logged in successfully!");
        // Logic for login validation
    }

    // Logout method
    public void logout() {
        System.out.println("User logged out.");
        // Logic for user logout
    }

    // Edit profile method
    public void editProfile(String firstName, String lastName, String gender, String profilePic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.profilePic = profilePic;
        System.out.println("Profile updated successfully!");
        // Logic to update user profile in the database
    }

    // View profile method
    public void viewProfile() {
        System.out.println("Displaying user profile:");
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Gender: " + this.gender);
        System.out.println("Email: " + this.emailAddress);
        // Logic to display profile information
    }

    // View teacher profile method
    public void viewTeacher(String teacherId) {
        System.out.println("Displaying teacher profile for ID: " + teacherId);
        // Logic to display teacher profile based on teacherId
    }

    // Share teacher profile method
    public void shareTeacher(String teacherId) {
        System.out.println("Teacher profile for ID " + teacherId + " shared successfully.");
        // Logic to share teacher profile (via link, email, etc.)
    }

    // Share video method
    public void shareVideo(String videoId) {
        System.out.println("Video with ID " + videoId + " shared successfully.");
        // Logic to share a video (via link, email, etc.)
    }

    // Find video by ID method
    public Video findVideoById(String videoId) {
        System.out.println("Fetching video with ID: " + videoId);
        // Logic to fetch a video from the database by videoId
        return new Video(videoId, "Sample Video", "Video URL"); // Placeholder return
    }
}

