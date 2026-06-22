package com.nim.interviewjourney.service;

import com.nim.interviewjourney.entity.ApplicationEntity;
import com.nim.interviewjourney.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ApplicationEntity create(ApplicationEntity application) {
        return applicationRepository.save(application);
    }

    public List<ApplicationEntity> getAll() {
        return applicationRepository.findAll();
    }
}