package com.nim.interviewjourney.service;

import com.nim.interviewjourney.dto.DashboardResponse;
import com.nim.interviewjourney.entity.ApplicationEntity;
import com.nim.interviewjourney.entity.ApplicationStatus;
import com.nim.interviewjourney.exception.ResourceNotFoundException;
import com.nim.interviewjourney.repository.ApplicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public ApplicationEntity getById(Long id) {

        return applicationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Application not found"));
    }

    public ApplicationEntity update(Long id, ApplicationEntity updatedApplication) {

        ApplicationEntity existing = applicationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Application not found"));

        existing.setCompanyName(updatedApplication.getCompanyName());
        existing.setRole(updatedApplication.getRole());
        existing.setExperienceRequired(updatedApplication.getExperienceRequired());
        existing.setApplicationDate(updatedApplication.getApplicationDate());
        existing.setStatus(updatedApplication.getStatus());
        existing.setJobSource(updatedApplication.getJobSource());
        existing.setNotes(updatedApplication.getNotes());

        return applicationRepository.save(existing);
    }

    public void delete(Long id) {

        ApplicationEntity application = applicationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Application not found"));

        applicationRepository.delete(application);
    }

    public List<ApplicationEntity> getByStatus(ApplicationStatus status) {
        return applicationRepository.findByStatus(status);
    }

    public List<ApplicationEntity> getByCompanyName(String companyName) {
        return applicationRepository.findByCompanyName(companyName);
    }

    public DashboardResponse getDashboardStats() {

        long totalApplications = applicationRepository.count();

        long applied =
                applicationRepository.findByStatus(ApplicationStatus.APPLIED).size();

        long rejected =
                applicationRepository.findByStatus(ApplicationStatus.REJECTED).size();

        long offerReceived =
                applicationRepository.findByStatus(ApplicationStatus.OFFER_RECEIVED).size();

        return new DashboardResponse(
                totalApplications,
                applied,
                rejected,
                offerReceived
        );
    }

    public List<ApplicationEntity> getApplicationsSortedByDate() {

        return applicationRepository.findAll(
                Sort.by(Sort.Direction.DESC, "applicationDate")
        );
    }

    public List<ApplicationEntity> getApplicationsSortedByCompany() {

        return applicationRepository.findAll(
                Sort.by(Sort.Direction.ASC, "companyName")
        );
    }

    public Page<ApplicationEntity> getApplicationsPaginated(int page, int size) {

        return applicationRepository.findAll(
                PageRequest.of(page, size)
        );
    }
    public List<ApplicationEntity> searchByRole(String role) {
    return applicationRepository.findByRoleContainingIgnoreCase(role);
}
}