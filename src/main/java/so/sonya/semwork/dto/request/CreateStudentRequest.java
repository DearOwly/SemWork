package so.sonya.semwork.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import so.sonya.semwork.entity.Gender;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateStudentRequest {
    @NotNull
    @Size(max = 255)
    private String fullName;

    @NotNull
    private Gender gender;

    @NotNull
    @Size(max = 255)
    private String institute;

    @NotNull
    private Integer yearOfStudy;

    @NotNull
    private Short roomId;
}