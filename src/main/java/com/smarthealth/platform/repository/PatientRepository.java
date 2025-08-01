package com.smarthealth.platform.repository;

import com.smarthealth.platform.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
