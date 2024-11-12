package so.sonya.semwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import so.sonya.semwork.entity.RoomInspection;

import java.util.UUID;

public interface RoomInspectionRepository extends JpaRepository<RoomInspection, UUID> {
}