package so.sonya.semwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import so.sonya.semwork.entity.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    @Query("""
        SELECT student
        FROM Student student
        WHERE student.fullName ilike :fullName
        """)
    List<Student> findByFullNameLike(String fullName);

    @Query("""
        SELECT student
        FROM Student student
        WHERE student.room.id = :roomId
        """)
    List<Student> findByRoom_Id(Short roomId);

    Optional<Student> findByUsername(String username);

    @Query(value = """
        WITH
            room_inspections AS (
                SELECT DISTINCT r.*
                FROM student s
                         LEFT JOIN room_inspection r ON s.room_id = r.room_id
                WHERE s.id = :id
            ),
            events AS (
                SELECT DISTINCT e.*
                FROM student s
                         LEFT JOIN event_participant ep ON s.id = ep.participant_id
                         LEFT JOIN event e ON ep.event_id = e.id
                WHERE s.id = :id
            ),
            room_inspection_points AS (
                SELECT SUM(points) AS points
                FROM room_inspections
            ),
            event_points AS (
                SELECT SUM(points) AS points
                FROM events
            )
        SELECT (SELECT COALESCE(points, 0) FROM room_inspection_points) +
               (SELECT COALESCE(points, 0) FROM event_points) AS points
        """,
        nativeQuery = true)
    Integer getPointsById(UUID id);

    boolean existsByUsername(String username);
}