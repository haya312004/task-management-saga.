package com.example.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    
    @Autowired
    private NotificationRepository notificationRepository;
    
    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
    
    @GetMapping("/user/{userId}")
    public List<Notification> getNotificationsByUser(@PathVariable String userId) {
        return notificationRepository.findByUserId(userId);
    }
    
    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }
    
    @PostMapping("/email")
    public Notification sendEmailNotification(@RequestBody Notification notification) {
        notification.setType("EMAIL");
        // هنا راح يكون كود إرسال الإيميل الفعلي
        notification.setStatus("SENT");
        return notificationRepository.save(notification);
    }
}