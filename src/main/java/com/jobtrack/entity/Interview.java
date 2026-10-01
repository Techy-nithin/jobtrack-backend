package com.jobtrack.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.jobtrack.enums.InterviewMode;
import com.jobtrack.enums.InterviewStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Interview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    @ManyToOne
    private JobApplication application;
    
    private String round;

    private LocalDate interviewDate;

    private LocalTime interviewTime;
    
    @Enumerated(EnumType.STRING)
    private InterviewMode mode;
    
    @Enumerated(EnumType.STRING)
    private InterviewStatus status;
    
    private String interviewer;
    
    private String feedback;

    public Interview() {
    }

    public Interview(Long id, JobApplication application, String round, LocalDate interviewDate,
            LocalTime interviewTime, InterviewMode mode, InterviewStatus status, String interviewer, String feedback) {
        this.id = id;
        this.application = application;
        this.round = round;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.mode = mode;
        this.status = status;
        this.interviewer = interviewer;
        this.feedback = feedback;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobApplication getApplication() {
        return application;
    }

    public void setApplication(JobApplication application) {
        this.application = application;
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

  
    
    

    

}
