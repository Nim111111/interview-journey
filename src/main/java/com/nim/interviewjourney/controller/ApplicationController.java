package com.nim.interviewjourney.controller;

import com.nim.interviewjourney.entity.ApplicationEntity;
import com.nim.interviewjourney.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ApplicationEntity create(@RequestBody ApplicationEntity application) {
        return applicationService.create(application);
    }

    @GetMapping
    public List<ApplicationEntity> getAll() {
        return applicationService.getAll();
    }
}