package hospitalmanager.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponse {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String specialization;
    private String qualification;
    private String experience;
    private String consultationFee;
    private Boolean available;
}