package com.jobtrack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobtrack.entity.JobApplication;
import com.jobtrack.entity.User;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{

    List<JobApplication> findByUser(User user);

}
