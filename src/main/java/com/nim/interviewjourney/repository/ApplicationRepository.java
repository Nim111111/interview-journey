package com.nim.interviewjourney.repository;

import com.nim.interviewjourney.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

}