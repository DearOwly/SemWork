package so.sonya.semwork.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import so.sonya.semwork.entity.ChatMessage;
import so.sonya.semwork.repository.ChatMessageRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatMessageRepository chatMessageRepository;

    @MessageMapping("/chat/sendMessage")
    @SendTo("/support/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage,
                                   SimpMessageHeaderAccessor headerAccessor) {

        String initiatorId = getInitiatorId(headerAccessor);
        chatMessage.setSessionId(initiatorId);

        chatMessageRepository.save(chatMessage);

        return chatMessage;
    }

    @MessageMapping("/chat/addUser")
    @SendTo("/support/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {

        String initiatorId = getInitiatorId(headerAccessor);
        chatMessage.setSessionId(initiatorId);

        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());

        chatMessageRepository.save(chatMessage);

        return chatMessage;
    }

    @MessageMapping("/chat/getHistory")
    @SendTo("/support/public")
    public List<ChatMessage> getChatHistory(SimpMessageHeaderAccessor headerAccessor) {
        String initiatorId = (String) headerAccessor.getSessionAttributes().get("initiatorId");
        return chatMessageRepository.findBySessionId(initiatorId);
    }

    private String getInitiatorId(SimpMessageHeaderAccessor headerAccessor) {
        String initiatorId = (String) headerAccessor.getSessionAttributes().get("initiatorId");
        if (initiatorId == null) {
            initiatorId = headerAccessor.getSessionId();
            headerAccessor.getSessionAttributes().put("initiatorId", initiatorId);
        }
        return initiatorId;
    }
}