package hospitalmanager.dto.response;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String gender;
    private String bloodGroup;
    private String address;
}