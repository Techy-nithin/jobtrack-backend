package com.jobtrack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobtrack.entity.Interview;
import com.jobtrack.entity.JobApplication;

public interface InterviewRepository extends JpaRepository<Interview, Long>{

    List<Interview>findByApplication(JobApplication application);
}
