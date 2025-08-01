package com.smarthealth.platform.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequest {
    private LocalDateTime appointmentTime;
    private String reason;
    private Long doctorId;
    private Long patientId;
}
