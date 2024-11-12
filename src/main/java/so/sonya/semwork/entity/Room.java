package so.sonya.semwork.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Room {
    @Id
    @Column(nullable = false)
    private Short id;

    @NotNull
    @Enumerated
    @Column(nullable = false)
    private Gender gender;

    @OneToMany(mappedBy = "room")
    private List<Student> students = new ArrayList<>();
}