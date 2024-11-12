package so.sonya.semwork.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ApplicationType {
    COCKROACH_TREATMENT("Обработка от тараканов");

    private final String display;

    public static ApplicationType getApplicationType(String display) {
        return Arrays.stream(ApplicationType.values())
            .filter(applicationType -> applicationType.display.equals(display))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(display + " is not a valid application type"));
    }
}
