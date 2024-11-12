package so.sonya.semwork.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class Announcement {
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

    @Size(max = 1023)
    @NotNull
    @Column(nullable = false)
    private String description;
}