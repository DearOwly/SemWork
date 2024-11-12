package so.sonya.semwork.dto.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class EventResponse {
    @NotNull
    private UUID id;

    @NotNull
    private LocalDate date;

    @NotNull
    @Size(max = 255)
    private String title;

    @NotNull
    private Integer points;

    private List<@NotNull UUID> participantIds;
}