package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Teacher extends User {

    // Attributes
    private UUID teacherId;
    private Location location;
    private Contact contact;
    private String subject;
    private List<Qualification> qualifications;
    private String bio;
    private double ratings;
    private String review;
    private List<Video> uploadedVideos;

    // Constructor
    public Teacher(String emailAddress, String password, String firstName, String lastName, String gender, String profilePic,
                   String town, String district, String province, String mobile, String email, String subject, String bio) {
        super(emailAddress, password, firstName, lastName, gender, profilePic, "TEACHER");  // Calling parent constructor with "TEACHER" role
        this.teacherId = UUID.randomUUID();  // Automatically generate unique teacherId
        this.location = new Location(town, district, province);
        this.contact = new Contact(mobile, email);
        this.subject = subject;
        this.qualifications = new ArrayList<>();
        this.bio = bio;
        this.ratings = 0.0;
        this.review = "";
        this.uploadedVideos = new ArrayList<>();
    }

    // Getters and Setters
    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public List<Video> getUploadedVideos() {
        return uploadedVideos;
    }

    public void setUploadedVideos(List<Video> uploadedVideos) {
        this.uploadedVideos = uploadedVideos;
    }

    // Methods

    // Upload a video
    public void uploadVideos(Video video) {
        if (validateVideoOwnership(video)) {
            uploadedVideos.add(video);
            notifyUserOnUploadSuccess();
            System.out.println("Video uploaded: " + video.getTitle());
        }
    }

    // Delete a video
    public void deleteVideos(Video video) {
        if (validateVideoOwnership(video)) {
            if (removeVideoFromStorage(video)) {
                uploadedVideos.remove(video);
                removeVideoMetadata(video);
                System.out.println("Video deleted: " + video.getTitle());
            }
        } else {
            System.out.println("Video ownership validation failed. Cannot delete video.");
        }
    }

    // Get the average rating of the teacher
    public double getAverageRating() {
        // This could be implemented based on multiple reviews, here we return the current rating
        return ratings;
    }

    // Update the average rating based on new ratings
    public void updateAverageRating(double newRating) {
        // Logic to update the average rating based on new ratings received
        // Placeholder: we can just reset the rating for now, real implementation will average ratings over time
        this.ratings = newRating;
        System.out.println("Rating updated to: " + this.ratings);
    }

    // Save a video to the list of uploaded videos
    public void saveVideo(Video video) {
        uploadedVideos.add(video);
        System.out.println("Video saved: " + video.getTitle());
    }

    // Notify user after successful upload
    public void notifyUserOnUploadSuccess() {
        System.out.println("Notification: Video uploaded successfully.");
        // Send notification logic
    }

    // Remove video from storage
    public boolean removeVideoFromStorage(Video video) {
        System.out.println("Removing video from storage: " + video.getTitle());
        // Logic to remove video from storage (cloud, local, etc.)
        return true; // Assuming the deletion was successful
    }

    // Validate if the teacher owns the video they are trying to delete/upload
    public boolean validateVideoOwnership(Video video) {
        // Logic to validate that this teacher owns the video
        // For now, we assume all videos are owned by the teacher
        return true;
    }

    // Remove video metadata
    public boolean removeVideoMetadata(Video video) {
        System.out.println("Removing metadata for video: " + video.getTitle());
        // Logic to remove metadata related to the video
        return true; // Assuming the operation was successful
    }
}

