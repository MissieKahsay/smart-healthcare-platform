package com.smarthealth.platform.controller;

import com.smarthealth.platform.dto.AppointmentRequest;
import com.smarthealth.platform.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentRequest request) {
        appointmentService.bookAppointment(request);
        return ResponseEntity.ok("Appointment booked successfully");
    }
}
