package so.sonya.semwork.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE("М"),
    FEMALE("Ж"),
    UNSPECIFIED("-");

    private final String display;

    public static Gender getGender(String display) {
        return Arrays.stream(Gender.values())
            .filter(gender -> gender.display.equals(display))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(display + " is not a valid gender"));
    }
}
