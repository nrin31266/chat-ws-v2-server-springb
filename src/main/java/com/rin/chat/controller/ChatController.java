package com.rin.chat.controller;

import com.rin.chat.constant.MessageType;
import com.rin.chat.dto.ApiResponse;
import com.rin.chat.dto.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage chatMessage
    ) {
        log.info("chatMessage: {}", chatMessage);
        return chatMessage;
    }

    @MessageMapping("/join")
    @SendTo("/topic/messages")
    public ChatMessage join(String username) {
        log.warn("username join: " + username);
        return ChatMessage.builder()
                .sender("System")
                .type(MessageType.JOIN)
                .content(username + " has joined")
                .build();
    }

    @MessageMapping("/leave")
    @SendTo("/topic/messages")
    public ChatMessage leave(String username) {
        log.warn("username leave: " + username);
        return ChatMessage.builder()
                .sender("System")
                .type(MessageType.LEAVE)
                .content(username + " has left the chat")
                .build();
    }

}
