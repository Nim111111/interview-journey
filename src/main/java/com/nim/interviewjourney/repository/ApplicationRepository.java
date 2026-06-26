package com.nim.interviewjourney.repository;

import com.nim.interviewjourney.entity.ApplicationEntity;
import com.nim.interviewjourney.entity.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository
        extends JpaRepository<ApplicationEntity, Long> {

    List<ApplicationEntity> findByStatus(ApplicationStatus status);
    List<ApplicationEntity> findByCompanyName(String companyName);
    List<ApplicationEntity> findByRoleContainingIgnoreCase(String role);
    


}