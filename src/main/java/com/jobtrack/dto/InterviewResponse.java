package com.jobtrack.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.jobtrack.enums.InterviewMode;
import com.jobtrack.enums.InterviewStatus;

public class InterviewResponse {

    private Long id;
    private String round;
    private LocalDate interviewDate;
    private LocalTime interviewTime;
    private InterviewMode mode;
    private InterviewStatus status;
    private String interviewer;
    private String feedback;
    private Long applicationId;
    
    public InterviewResponse(
            Long id,
            String round,
            LocalDate interviewDate,
            LocalTime interviewTime,
            InterviewMode mode,
            InterviewStatus status,
            String interviewer,
            String feedback,
            Long applicationId) {

        this.id = id;
        this.round = round;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.mode = mode;
        this.status = status;
        this.interviewer = interviewer;
        this.feedback = feedback;
        this.applicationId = applicationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public LocalTime getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(LocalTime interviewTime) {
        this.interviewTime = interviewTime;
    }

    public InterviewMode getMode() {
        return mode;
    }

    public void setMode(InterviewMode mode) {
        this.mode = mode;
    }

    public InterviewStatus getStatus() {
        return status;
    }

    public void setStatus(InterviewStatus status) {
        this.status = status;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
    
    
}
