package so.sonya.semwork.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private LocalDate date;

    @Size(max = 255)
    @NotNull
    @Column(nullable = false)
    private String title;

    @NotNull
    @Column(nullable = false)
    private Integer points;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "event_participant",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    private List<Student> participants = new ArrayList<>();
}