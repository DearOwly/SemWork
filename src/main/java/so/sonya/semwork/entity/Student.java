package so.sonya.semwork.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Size(max = 255)
    @NotNull
    @Column(nullable = false)
    private String username;

    @Size(max = 255)
    @NotNull
    @Column(nullable = false)
    private String password;

    @Size(max = 255)
    @NotNull
    @Column(nullable = false)
    private String fullName;

    @NotNull
    @Enumerated
    @Column(nullable = false)
    private Gender gender;

    @Size(max = 255)
    @NotNull
    @Column(nullable = false)
    private String institute;

    @NotNull
    @Column(nullable = false)
    private Integer yearOfStudy;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @NotNull
    @Enumerated
    @Column(nullable = false)
    private StudentType type;
}