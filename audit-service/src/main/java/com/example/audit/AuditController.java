package com.example.audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {
    
    @Autowired
    private AuditRepository auditRepository;
    
    @GetMapping
    public List<AuditLog> getAllAuditLogs() {
        return auditRepository.findAll();
    }
    
    @GetMapping("/service/{serviceName}")
    public List<AuditLog> getAuditLogsByService(@PathVariable String serviceName) {
        return auditRepository.findByServiceName(serviceName);
    }
    
    @GetMapping("/user/{userId}")
    public List<AuditLog> getAuditLogsByUser(@PathVariable String userId) {
        return auditRepository.findByUserId(userId);
    }
    
    @PostMapping
    public AuditLog createAuditLog(@RequestBody AuditLog auditLog) {
        return auditRepository.save(auditLog);
    }
}