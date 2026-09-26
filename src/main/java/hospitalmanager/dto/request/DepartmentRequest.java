package hospitalmanager.dto.request;

import jakarta.validation.constraints.NotBlank;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest {

    @NotBlank(message = "Department name is required")
    private String name;

    private String description;
}