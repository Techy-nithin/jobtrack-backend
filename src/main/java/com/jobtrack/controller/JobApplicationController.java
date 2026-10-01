package com.jobtrack.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobtrack.dto.JobApplicationResponse;
import com.jobtrack.entity.JobApplication;
import com.jobtrack.entity.User;
import com.jobtrack.exception.UserNotFoundException;
import com.jobtrack.repository.UserRepository;
import com.jobtrack.service.JobApplicationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final UserRepository userRepository;
    
    private final JobApplicationService jobApplicationService;
    
    public JobApplicationController(
            JobApplicationService jobApplicationService,
            UserRepository userRepository) {
        this.jobApplicationService=jobApplicationService;
        this.userRepository = userRepository;
    }
    
    @PostMapping
    public JobApplicationResponse  createApplication(
            @RequestBody @Valid JobApplication  application,
            Authentication authentication) {
        
        String email=authentication.getName();
        
        User user=userRepository.findByEmail(email)
        .orElseThrow(()->new UserNotFoundException("User Not found"));
        
        return jobApplicationService.createApplication(application, user);
    }
    
    @GetMapping
    public List<JobApplicationResponse> getMyApplications(Authentication authentication){
        String email=authentication.getName();
        
        User user=userRepository.findByEmail(email).
                orElseThrow(()-> new UserNotFoundException("User not found"));
        
        return jobApplicationService.getMyApplications(user);
    }
    
    @GetMapping("/{id}")
    public JobApplicationResponse  getApplicationById(
            @PathVariable Long id, 
            Authentication authentication) {
        
        String email=authentication.getName();
        User user= userRepository.findByEmail(email).
                orElseThrow(()->new UserNotFoundException("User not found"));
        
        return jobApplicationService.getApplicationById(id, user);
    }
    
    @PutMapping("/{id}")
    public JobApplicationResponse updateApplication(
            @PathVariable Long id,
            @RequestBody @Valid JobApplication updatedApplication,
            Authentication authentication) {
        
        String email = authentication.getName();
        

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        
        return jobApplicationService.updateApplication(
                id,
                updatedApplication,
                user
        );
    }
    
    @DeleteMapping("/{id}")
    public String deleteApplication(
            @PathVariable Long id,
            Authentication authentication) {
        
        String email=authentication.getName();
        
        User user=userRepository.findByEmail(email).
                orElseThrow(()-> new UserNotFoundException("User not found"));
        
        jobApplicationService.deleteApplication(id, user);
        
        return "Application deleted successfully";
    }
}
