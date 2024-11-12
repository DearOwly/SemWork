package so.sonya.semwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import so.sonya.semwork.entity.Event;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}