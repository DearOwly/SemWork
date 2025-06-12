package so.sonya.semwork.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageType type;

    @NotNull
    @Column(nullable = false)
    private String content;

    @NotNull
    @Column(nullable = false)
    private String sender;

    @Column(name = "session_id")
    private String sessionId;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        SYSTEM
    }

//    public MessageType getType() {
//        return type;
//    }
//
//    public void setType(MessageType type) {
//        this.type = type;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getSender() {
//        return sender;
//    }
//
//    public void setSender(String sender) {
//        this.sender = sender;
//    }
}