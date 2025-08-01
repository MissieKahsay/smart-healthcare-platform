package com.smarthealth.platform.service;

import com.smarthealth.platform.dto.AppointmentRequest;

public interface AppointmentService {
    void bookAppointment(AppointmentRequest request);
}
