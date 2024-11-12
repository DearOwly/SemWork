package so.sonya.semwork.dto.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class StudentResponse {
    @NotNull
    private UUID id;

    @NotNull
    @Size(max = 255)
    private String fullName;

    @NotNull
    private GenderResponse gender;

    @NotNull
    @Size(max = 255)
    private String institute;

    @NotNull
    private Integer yearOfStudy;

    @NotNull
    private Short roomId;

    @NotNull
    private StudentTypeResponse type;

    @NotNull
    private Integer points;
}