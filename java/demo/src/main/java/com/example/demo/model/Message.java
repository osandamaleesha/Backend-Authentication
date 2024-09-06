package com.example.demo.model;

import java.util.UUID;

/**
 * The Message class represents a message sent from one user to another.
 * It includes attributes such as messageId, content, timestamp, senderId, and receiverId.
 * It provides methods to send, view, delete, edit, and mark messages as read.
 */
public class Message {

    // Attributes
    private String messageId;
    private String content;
    private String time;
    private String date;
    private String senderId;
    private String receiverId;
    private boolean isRead; // Additional attribute to track read status

    // Constructor
    /**
     * Constructs a new Message with the specified content, sender, and receiver.
     * The messageId is automatically generated, and the current date and time are set.
     *
     * @param content     The content of the message.
     * @param senderId    The userId of the sender.
     * @param receiverId  The userId of the receiver.
     */
    public Message(String content, String senderId, String receiverId) {
        this.messageId = UUID.randomUUID().toString(); // Generate unique messageId
        this.content = content;
        this.senderId = senderId;
        this.receiverId = receiverId;
        // Set current date and time (format: YYYY-MM-DD and HH:MM:SS)
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        this.date = now.toLocalDate().toString();
        this.time = now.toLocalTime().withNano(0).toString();
        this.isRead = false; // Initially, the message is unread
    }

    // Getters and Setters

    /**
     * Gets the unique identifier of the message.
     *
     * @return The messageId.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the unique identifier of the message.
     *
     * @param messageId The messageId to set.
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * Gets the content of the message.
     *
     * @return The message content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the message.
     *
     * @param content The message content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the time the message was sent.
     *
     * @return The time in HH:MM:SS format.
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time the message was sent.
     *
     * @param time The time to set in HH:MM:SS format.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets the date the message was sent.
     *
     * @return The date in YYYY-MM-DD format.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date the message was sent.
     *
     * @param date The date to set in YYYY-MM-DD format.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the userId of the sender.
     *
     * @return The senderId.
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * Sets the userId of the sender.
     *
     * @param senderId The senderId to set.
     */
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    /**
     * Gets the userId of the receiver.
     *
     * @return The receiverId.
     */
    public String getReceiverId() {
        return receiverId;
    }

    /**
     * Sets the userId of the receiver.
     *
     * @param receiverId The receiverId to set.
     */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    /**
     * Checks if the message has been read.
     *
     * @return true if the message is read, false otherwise.
     */
    public boolean isRead() {
        return isRead;
    }

    /**
     * Sets the read status of the message.
     *
     * @param isRead The read status to set.
     */
    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    // Methods

    /**
     * Sends the message. In a real application, this method would handle the logic
     * to store the message in a database or send it through a messaging service.
     */
    public void sendMessage() {
        // Placeholder for sending message logic
        System.out.println("Message sent from User " + senderId + " to User " + receiverId + ".");
        // Implement actual sending logic here (e.g., save to database)
    }

    /**
     * Views the message details.
     */
    public void viewMessage() {
        System.out.println("Message ID: " + messageId);
        System.out.println("From: User " + senderId);
        System.out.println("To: User " + receiverId);
        System.out.println("Date: " + date + " Time: " + time);
        System.out.println("Content: " + content);
        System.out.println("Read: " + (isRead ? "Yes" : "No"));
    }

    /**
     * Deletes the message. In a real application, this would remove the message
     * from the storage system.
     */
    public void deleteMessage() {
        // Placeholder for deletion logic
        System.out.println("Message with ID " + messageId + " has been deleted.");
        // Implement actual deletion logic here (e.g., remove from database)
    }

    /**
     * Edits the content of the message. Only the sender should typically be allowed
     * to edit the message.
     *
     * @param newContent The new content for the message.
     */
    public void editMessage(String newContent) {
        this.content = newContent;
        // Update the timestamp to reflect the edit time (optional)
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        this.date = now.toLocalDate().toString();
        this.time = now.toLocalTime().withNano(0).toString();
        System.out.println("Message with ID " + messageId + " has been edited.");
        // Implement actual edit logic here (e.g., update in database)
    }

    /**
     * Marks the message as read.
     */
    public void markAsRead() {
        this.isRead = true;
        System.out.println("Message with ID " + messageId + " has been marked as read.");
        // Implement actual mark as read logic here (e.g., update in database)
    }

    // Optional: Override toString() for easier debugging and logging
    @Override
    public String toString() {
        return "Message{" +
                "messageId='" + messageId + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}

