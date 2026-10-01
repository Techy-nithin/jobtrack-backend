package com.jobtrack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobtrack.dto.JobApplicationResponse;
import com.jobtrack.entity.JobApplication;
import com.jobtrack.entity.User;
import com.jobtrack.exception.ApplicationNotFoundException;
import com.jobtrack.exception.UnauthorizedApplicationException;
import com.jobtrack.repository.JobApplicationRepository;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    
    public JobApplicationService(
            JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository=jobApplicationRepository;
    }
    
    public JobApplicationResponse  createApplication(JobApplication application,
            User user) {
        application.setUser(user);
        
        JobApplication savedApplication =
                jobApplicationRepository.save(application);

        
        return toResponse(savedApplication);
    }
    
    public List<JobApplicationResponse> getMyApplications(User user){
        return  jobApplicationRepository.findByUser(user).
                stream().
                map(this::toResponse).
                toList();
    }
    
    public JobApplicationResponse  getApplicationById(Long id, User user) {
        
        JobApplication application=jobApplicationRepository.findById(id).
                orElseThrow(()-> new ApplicationNotFoundException("Application not found"));
        
        if(!application.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedApplicationException("You are not authorized");
        }
        
        return toResponse(application);
    }
    
    public JobApplicationResponse updateApplication(
            Long id,
            JobApplication updatedApplication,
            User user) {

        JobApplication application = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("Application not found"));

        if (!application.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedApplicationException(
                    "You are not authorized to update this application");
        }

        application.setCompanyName(updatedApplication.getCompanyName());
        application.setJobTitle(updatedApplication.getJobTitle());
        application.setLocation(updatedApplication.getLocation());
        application.setStatus(updatedApplication.getStatus());
        application.setAppliedDate(updatedApplication.getAppliedDate());
        application.setJobUrl(updatedApplication.getJobUrl());
        application.setNotes(updatedApplication.getNotes());

        JobApplication savedApplication =
                jobApplicationRepository.save(application);
        
        return toResponse(savedApplication);
    }
    
    public void deleteApplication(Long id, User user) {

        JobApplication application = jobApplicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        if (!application.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedApplicationException(
                    "You are not authorized to delete this application");
        }

        jobApplicationRepository.delete(application);
    }
    
    private JobApplicationResponse toResponse(JobApplication application) {

        return new JobApplicationResponse(
                application.getId(),
                application.getCompanyName(),
                application.getJobTitle(),
                application.getLocation(),
                application.getStatus(),
                application.getAppliedDate(),
                application.getJobUrl(),
                application.getNotes(),
                application.getUser().getId()
        );
    }
}
