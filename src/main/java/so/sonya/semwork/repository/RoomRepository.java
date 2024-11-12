package so.sonya.semwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import so.sonya.semwork.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Short> {
}