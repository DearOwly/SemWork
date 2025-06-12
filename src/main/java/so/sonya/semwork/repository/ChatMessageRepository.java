package so.sonya.semwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import so.sonya.semwork.entity.ChatMessage;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySessionId(String sessionId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ChatMessage c WHERE c.sessionId = ?1")
    void deleteBySessionId(String sessionId);
}
