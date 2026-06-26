package com.nim.interviewjourney.controller;

import com.nim.interviewjourney.entity.ApplicationEntity;
import com.nim.interviewjourney.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.nim.interviewjourney.entity.ApplicationStatus;
import java.util.List;
import com.nim.interviewjourney.dto.DashboardResponse;
import org.springframework.data.domain.Page;
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ApplicationEntity create(
            @Valid @RequestBody ApplicationEntity application) {

        return applicationService.create(application);
    }

    @GetMapping
    public List<ApplicationEntity> getAll() {
        return applicationService.getAll();
    }

    @GetMapping("/{id}")
    public ApplicationEntity getById(@PathVariable Long id) {
        return applicationService.getById(id);
    }

    @PutMapping("/{id}")
    public ApplicationEntity update(
            @PathVariable Long id,
            @Valid @RequestBody ApplicationEntity application) {

        return applicationService.update(id, application);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        applicationService.delete(id);

        return "Application deleted successfully";
    }
    @GetMapping("/status/{status}")
public List<ApplicationEntity> getByStatus(
        @PathVariable ApplicationStatus status) {

    return applicationService.getByStatus(status);
}
@GetMapping("/company/{companyName}")
public List<ApplicationEntity> getByCompanyName(
        @PathVariable String companyName) {

    return applicationService.getByCompanyName(companyName);
}
@GetMapping("/dashboard")
public DashboardResponse dashboard() {
    return applicationService.getDashboardStats();
}
@GetMapping("/sorted/date")
public List<ApplicationEntity> getSortedByDate() {
    return applicationService.getApplicationsSortedByDate();
}

@GetMapping("/sorted/company")
public List<ApplicationEntity> getSortedByCompany() {
    return applicationService.getApplicationsSortedByCompany();
}
@GetMapping("/paged")
public Page<ApplicationEntity> getPaginated(
        @RequestParam int page,
        @RequestParam int size) {

    return applicationService.getApplicationsPaginated(page, size);
}
@GetMapping("/search")
public List<ApplicationEntity> searchByRole(
        @RequestParam String role) {

    return applicationService.searchByRole(role);
}
}