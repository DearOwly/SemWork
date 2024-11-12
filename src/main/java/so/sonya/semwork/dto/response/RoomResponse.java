package so.sonya.semwork.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RoomResponse {
    @NotNull
    private Short id;

    @NotNull
    private GenderResponse gender;
}