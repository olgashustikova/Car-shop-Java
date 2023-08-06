package restservice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restservice.demo.dto.ChatDto;
import restservice.demo.entity.Chat;
import restservice.demo.repository.ChatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {

    private final ChatRepository chatRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public ChatDto addChat(ChatDto chatDto) {
        Chat chat = new Chat();
        chat.setDate(chatDto.getDate());
        chat.setFromUser(chatDto.getFromUser());
        chat.setText(chatDto.getText());
        chat.setToUser(chatDto.getToUser());

        Chat savedChat = chatRepository.save(chat);

        // Convert the saved entity back to the DTO
        ChatDto savedChatDto = new ChatDto();
        savedChatDto.setId(savedChat.getId());
        savedChatDto.setDate(savedChat.getDate());
        savedChatDto.setFromUser(savedChat.getFromUser());
        savedChatDto.setText(savedChat.getText());
        savedChatDto.setToUser(savedChat.getToUser());

        return savedChatDto;
    }


    public List<ChatDto> getAllChats() {
        List<Chat> chats = chatRepository.findAll();

        // Convert List<Chat> to List<ChatDto>
        List<ChatDto> chatDtos = new ArrayList<>();
        for (Chat chat : chats) {
            ChatDto chatDto = new ChatDto();
            chatDto.setId(chat.getId());
            chatDto.setDate(chat.getDate());
            chatDto.setFromUser(chat.getFromUser());
            chatDto.setText(chat.getText());
            chatDto.setToUser(chat.getToUser());

            chatDtos.add(chatDto);
        }

        return chatDtos;
    }


    public List<ChatDto> getChatByFromUser(String fromUser) {
        List<Chat> chats = chatRepository.findByFromUser(fromUser);
        return convertDtoFromEntity(chats);
    }

    public List<ChatDto> getChatByToUser(String toUser) {
        List<Chat> chats = chatRepository.findByToUser(toUser);
        return convertDtoFromEntity(chats);
    }
    public List<ChatDto> getChatsByFromUserAndToUser(String fromUser, String toUser) {
        List<Chat> chats = chatRepository.findByFromUserAndToUser(fromUser, toUser);
        return convertDtoFromEntity(chats);
    }

    private List<ChatDto> convertDtoFromEntity(List<Chat> chatEntites) {
        List<ChatDto> chatDtos = new ArrayList<>();
        for (Chat chat : chatEntites) {
            ChatDto chatDto = new ChatDto();
            chatDto.setId(chat.getId());
            chatDto.setDate(chat.getDate());
            chatDto.setToUser(chat.getToUser());
            chatDto.setText(chat.getText());
            chatDto.setFromUser(chat.getFromUser());

            chatDtos.add(chatDto);
        }
        return chatDtos;
    }

}
