package so.sonya.semwork.dto.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ApplicationTypeResponse {
    @NotNull
    @Size(max = 255)
    private String id;

    @NotNull
    @Size(max = 255)
    private String display;
}