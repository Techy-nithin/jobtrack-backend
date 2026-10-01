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

import com.jobtrack.dto.InterviewResponse;
import com.jobtrack.entity.Interview;
import com.jobtrack.entity.User;
import com.jobtrack.exception.UserNotFoundException;
import com.jobtrack.repository.UserRepository;
import com.jobtrack.service.InterviewService;

@RestController
@RequestMapping("/api/applications/{applicationId}/interviews")
public class InterviewController {

    private final InterviewService interviewService;
    private final UserRepository userRepository;
    
    public InterviewController(
            InterviewService interviewService,
            UserRepository userRepository) {
        this.interviewService = interviewService;
        this.userRepository = userRepository;
    }
    
    @PostMapping
    public InterviewResponse  createInterview(
            @PathVariable Long applicationId,
            @RequestBody Interview interview,
            Authentication authentication) {
        
        String email=authentication.getName();
    
        User user=userRepository.findByEmail(email).
                orElseThrow(()-> new UserNotFoundException("User not found"));
        
        return interviewService.createInterview(applicationId, interview, user);
    }
    
    @GetMapping
    public List<InterviewResponse> getInterviews(
            @PathVariable Long applicationId,
            Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return interviewService.getInterviews(
                applicationId,
                user
        );
    }
    
    @PutMapping("/{interviewId}")
    public InterviewResponse updateInterview(
            @PathVariable Long interviewId,
            @RequestBody Interview updatedInterview,
            Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return interviewService.updateInterview(
                interviewId,
                updatedInterview,
                user
        );
    }
    
    @DeleteMapping("/{interviewId}")
    public String deleteInterview(
            @PathVariable Long interviewId,
            Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        interviewService.deleteInterview(interviewId, user);

        return "Interview deleted successfully";
        
        
    }
}
