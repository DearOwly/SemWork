package so.sonya.semwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import so.sonya.semwork.entity.Announcement;

import java.util.UUID;

public interface AnnouncementRepository extends JpaRepository<Announcement, UUID> {
}