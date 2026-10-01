package com.jobtrack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobtrack.dto.InterviewResponse;
import com.jobtrack.entity.Interview;
import com.jobtrack.entity.JobApplication;
import com.jobtrack.entity.User;
import com.jobtrack.exception.ApplicationNotFoundException;
import com.jobtrack.exception.InterviewNotFoundException;
import com.jobtrack.exception.UnauthorizedApplicationException;
import com.jobtrack.repository.InterviewRepository;
import com.jobtrack.repository.JobApplicationRepository;

@Service
public class InterviewService {
    
    private final InterviewRepository interviewRepository;
    private final JobApplicationRepository jobApplicationRepository;
    
    public InterviewService(
            InterviewRepository interviewRepository,
            JobApplicationRepository jobApplicationRepository) {

        this.interviewRepository = interviewRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }
    
    public InterviewResponse  createInterview(
            Long applicationId,
            Interview interview,
            User user) {
        
        JobApplication application = jobApplicationRepository.findById(applicationId).
                orElseThrow(()->new ApplicationNotFoundException("Application not found"));
        
        if(!application.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedApplicationException("You are not authorised to add interview to this application");
              
        }
        
        interview.setApplication(application);
        Interview savedInterview=interviewRepository.save(interview);
        
        return toResponse(savedInterview);
    }
    
    public List<InterviewResponse> getInterviews(
            Long applicationId,
            User user) {

        JobApplication application = jobApplicationRepository
                .findById(applicationId)
                .orElseThrow(() ->
                        new ApplicationNotFoundException("Application not found"));

        if (!application.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedApplicationException(
                    "You are not authorized to access these interviews");
        }

        return interviewRepository.findByApplication(application).stream()
                .map(this::toResponse).
                toList();
    }
    
    public InterviewResponse updateInterview(
            Long interviewId,
            Interview updatedInterview,
            User user) {

        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() ->
                        new InterviewNotFoundException("Interview not found"));

        if (!interview.getApplication().getUser().getId().equals(user.getId())) {
            throw new UnauthorizedApplicationException(
                    "You are not authorized to update this interview");
        }

        interview.setRound(updatedInterview.getRound());
        interview.setInterviewDate(updatedInterview.getInterviewDate());
        interview.setInterviewTime(updatedInterview.getInterviewTime());
        interview.setMode(updatedInterview.getMode());
        interview.setStatus(updatedInterview.getStatus());
        interview.setInterviewer(updatedInterview.getInterviewer());
        interview.setFeedback(updatedInterview.getFeedback());

        Interview savedInterview = interviewRepository.save(interview);

        return toResponse(savedInterview);
    }
    
    public void deleteInterview(
            Long interviewId,
            User user) {

        Interview interview = interviewRepository.findById(interviewId)
                .orElseThrow(() ->
                        new InterviewNotFoundException("Interview not found"));

        if (!interview.getApplication().getUser().getId().equals(user.getId())) {
            throw new UnauthorizedApplicationException(
                    "You are not authorized to delete this interview");
        }

        interviewRepository.delete(interview);
    }
    
    private InterviewResponse toResponse(Interview interview) {

        return new InterviewResponse(
                interview.getId(),
                interview.getRound(),
                interview.getInterviewDate(),
                interview.getInterviewTime(),
                interview.getMode(),
                interview.getStatus(),
                interview.getInterviewer(),
                interview.getFeedback(),
                interview.getApplication().getId()
        );
    }

}
