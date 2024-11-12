package so.sonya.semwork.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import so.sonya.semwork.entity.Application;

import java.util.List;
import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    Page<Application> findByApplicant_Id(UUID id, Pageable pageable);
}