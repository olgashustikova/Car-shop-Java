package restservice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restservice.demo.dto.ChatDto;
import restservice.demo.entity.Chat;
import restservice.demo.service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/add-chat")
    public ResponseEntity<ChatDto> addChat(@RequestBody ChatDto chatDto) {
        ChatDto savedChatDto = chatService.addChat(chatDto);
        return ResponseEntity.ok(savedChatDto);
    }

    @GetMapping("/get-chat")
    public ResponseEntity<List<ChatDto>> getChat(@RequestParam(required = false) String fromUser, @RequestParam(required = false) String toUser ) {
        if (fromUser == null && toUser == null) {
            List<ChatDto> chatDtos = chatService.getAllChats();
            return ResponseEntity.ok(chatDtos);
        } else if (fromUser != null && toUser == null){
            List<ChatDto> chats = chatService.getChatByFromUser(fromUser);

            if (chats.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                List<ChatDto> chatDtos = chatService.getChatByFromUser(fromUser);
                return ResponseEntity.ok(chatDtos);
            }
        }
        else if (fromUser == null && toUser != null){
            List<ChatDto> chats = chatService.getChatByToUser(toUser);
            if (chats.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                List<ChatDto> chatDtos = chatService.getChatByToUser(toUser);
                return ResponseEntity.ok(chatDtos);
            }
        }
        else if (fromUser != null && toUser != null){
            List<ChatDto> chats = chatService.getChatsByFromUserAndToUser(fromUser, toUser);

            if (chats.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                List<ChatDto> chatDtos = chatService.getChatsByFromUserAndToUser(fromUser, toUser);
                return ResponseEntity.ok(chatDtos);
            }
        }
    else {
        return ResponseEntity.badRequest().build();
    }
    }



}
   


