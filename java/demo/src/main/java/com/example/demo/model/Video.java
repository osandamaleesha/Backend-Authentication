package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Video {

    // Attributes
    private UUID videoId;
    private String url;
    private String description;
    private String title;
    private int views;
    private LocalDateTime uploadDate;
    private UUID teacherId;
    private String subject;
    private double rating;
    private String shareableLink;

    // Constructor
    public Video(String url, String description, String title, UUID teacherId, String subject) {
        this.videoId = UUID.randomUUID(); // Generate unique videoId
        this.url = url;
        this.description = description;
        this.title = title;
        this.views = 0;
        this.uploadDate = LocalDateTime.now();
        this.teacherId = teacherId;
        this.subject = subject;
        this.rating = 0.0;
        this.shareableLink = generateShareableLink();
    }

    // Getters and Setters
    public UUID getVideoId() {
        return videoId;
    }

    public void setVideoId(UUID videoId) {
        this.videoId = videoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getShareableLink() {
        return shareableLink;
    }

    public void setShareableLink(String shareableLink) {
        this.shareableLink = shareableLink;
    }

    // Methods

    public void playVideo() {
        System.out.println("Playing video: " + title);
        incrementViews();
    }

    public void incrementViews() {
        this.views++;
    }

    public void getVideoInfo() {
        System.out.println("Video Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Uploaded by Teacher ID: " + teacherId);
        System.out.println("Views: " + views);
        System.out.println("Rating: " + rating);
        System.out.println("Shareable Link: " + shareableLink);
    }

    public void rateVideo(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void shareVideo() {
        System.out.println("Shareable Link: " + shareableLink);
    }

    public void deleteVideo() {
        System.out.println("Deleting video with ID: " + videoId);
        // Logic to delete the video from storage
    }

    public String generateShareableLink() {
        return "https://video.platform.com/video/" + videoId.toString();
    }

    public String formatLinkForPlatform(String link, String platform) {
        return platform + ": " + link;
    }

    public void generateThumbnail() {
        System.out.println("Generating thumbnail for video: " + title);
    }

    public void updateVideoDetails() {
        System.out.println("Updating video details for: " + title);
    }

    public void getDuration() {
        // Placeholder for actual duration logic
        System.out.println("Getting video duration...");
    }

    public void loadVideo() {
        System.out.println("Loading video: " + title);
    }

    public void bufferVideo() {
        System.out.println("Buffering video: " + title);
    }

    public int trackPlaybackProgress() {
        // Placeholder for tracking video playback progress
        return 0;  // Default return value
    }

    public void resumeVideo(int lastPlayedTime) {
        System.out.println("Resuming video at: " + lastPlayedTime + " seconds.");
    }

    public void pauseVideo() {
        System.out.println("Pausing video: " + title);
    }

    public void stopVideo() {
        System.out.println("Stopping video: " + title);
    }

    public boolean validateVideo(Video video) {
        // Placeholder logic for video validation
        return video != null;
    }

    public boolean checkStorageSpace() {
        // Placeholder logic for checking storage space
        return true;
    }

    public void removeVideoFromStorage(Video video) {
        if (validateVideo(video)) {
            System.out.println("Removing video from storage: " + video.getTitle());
            // Logic to remove video from storage
        }
    }

    public boolean removeVideoMetadata(Video video) {
        if (validateVideo(video)) {
            System.out.println("Removing metadata for video: " + video.getTitle());
            // Logic to remove metadata
            return true;
        }
        return false;
    }
}
