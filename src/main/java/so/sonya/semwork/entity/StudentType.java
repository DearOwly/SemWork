package so.sonya.semwork.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum StudentType {
    STUDENT("Проживающий"),
    BLOCK_11_LEADER("Староста 1.1"),
    BLOCK_21_LEADER("Староста 2.1"),
    BLOCK_22_LEADER("Староста 2.2"),
    BLOCK_31_LEADER("Староста 3.1"),
    BLOCK_32_LEADER("Староста 3.2"),
    BLOCK_41_LEADER("Староста 4.1"),
    BLOCK_42_LEADER("Староста 4.2"),
    BLOCK_51_LEADER("Староста 5.1"),
    BLOCK_52_LEADER("Староста 5.2"),
    COUNCIL_MEMBER("Студсовет"),
    COUNCIL_CHAIR("Председатель");

    private final String display;

    public static StudentType getStudentPosition(String display) {
        return Arrays.stream(StudentType.values())
            .filter(studentPosition -> studentPosition.display.equals(display))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(display + " is not a valid student type"));
    }
}
