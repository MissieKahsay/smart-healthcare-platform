package com.smarthealth.platform.repository;

import com.smarthealth.platform.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
