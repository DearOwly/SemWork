package so.sonya.semwork.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ApplicationResponse {
    @NotNull
    private UUID id;

    @NotNull
    private LocalDate date;

    @NotNull
    private UUID applicantId;

    @NotNull
    private ApplicationTypeResponse type;

    private boolean completed;
}