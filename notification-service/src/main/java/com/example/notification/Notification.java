package com.example.notification;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    
    private String userId;
    private String message;
    private String type; // EMAIL, SMS, PUSH
    private LocalDateTime timestamp;
    private String status; // SENT, FAILED, PENDING
    
    // Constructors
    public Notification() {
        this.timestamp = LocalDateTime.now();
        this.status = "PENDING";
    }
    
    public Notification(String userId, String message, String type) {
        this();
        this.userId = userId;
        this.message = message;
        this.type = type;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}