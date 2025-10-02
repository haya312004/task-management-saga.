package com.example.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByServiceName(String serviceName);
    List<AuditLog> findByUserId(String userId);
    List<AuditLog> findByAction(String action);
}