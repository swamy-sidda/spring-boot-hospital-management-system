package hospitalmanager.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponse {

    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long departmentId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String reason;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}