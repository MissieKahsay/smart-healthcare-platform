package com.smarthealth.platform.service.impl;

import com.smarthealth.platform.dto.AppointmentRequest;
import com.smarthealth.platform.model.Appointment;
import com.smarthealth.platform.model.Doctor;
import com.smarthealth.platform.model.Patient;
import com.smarthealth.platform.repository.AppointmentRepository;
import com.smarthealth.platform.repository.DoctorRepository;
import com.smarthealth.platform.repository.PatientRepository;
import com.smarthealth.platform.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public void bookAppointment(AppointmentRequest request) {
        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = Appointment.builder()
                .appointmentTime(request.getAppointmentTime())
                .reason(request.getReason())
                .doctor(doctor)
                .patient(patient)
                .build();

        appointmentRepository.save(appointment);
    }
}
