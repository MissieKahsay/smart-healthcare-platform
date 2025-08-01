package com.smarthealth.platform.repository;

import com.smarthealth.platform.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
