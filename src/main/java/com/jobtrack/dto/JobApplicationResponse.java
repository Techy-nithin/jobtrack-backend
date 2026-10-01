package com.jobtrack.dto;

import java.time.LocalDate;

import com.jobtrack.enums.ApplicationStatus;

public class JobApplicationResponse {

    private Long id;
    private String companyName;
    private String jobTitle;
    private String location;
    private ApplicationStatus status;
    private LocalDate appliedDate;
    private String jobUrl;
    private String notes;
    private Long userId;
    public JobApplicationResponse() {
    }
    public JobApplicationResponse(Long id, String companyName, String jobTitle, String location, ApplicationStatus status,
            LocalDate appliedDate, String jobUrl, String notes, Long userId) {
        this.id = id;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.location = location;
        this.status = status;
        this.appliedDate = appliedDate;
        this.jobUrl = jobUrl;
        this.notes = notes;
        this.userId = userId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public ApplicationStatus getStatus() {
        return status;
    }
    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
    public LocalDate getAppliedDate() {
        return appliedDate;
    }
    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }
    public String getJobUrl() {
        return jobUrl;
    }
    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
}
