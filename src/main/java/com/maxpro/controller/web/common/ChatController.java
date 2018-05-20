package com.maxpro.controller.web.common;

import com.maxpro.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class ChatController {

    private final String BASE_PATH = "/common/chat";
    private final String CHAT_INDEX_PAGE = BASE_PATH + "/index";
    private final String CHAT_BOX_PAGE = BASE_PATH + "/chat";

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @RequestMapping("/chat")
    public String chatIndex() {
        return CHAT_INDEX_PAGE;
    }

    @RequestMapping("/chat2")
    public String chatBox() {
        return CHAT_BOX_PAGE;
    }

}
