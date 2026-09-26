package hospitalmanager.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private Long userId;
    private String name;
    private String email;
    private String role;
    private String token;
    private String message;
}