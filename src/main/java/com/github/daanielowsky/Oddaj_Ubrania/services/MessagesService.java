package com.github.daanielowsky.Oddaj_Ubrania.services;

import com.github.daanielowsky.Oddaj_Ubrania.Repositories.MessagesRepository;
import com.github.daanielowsky.Oddaj_Ubrania.dto.MessageDTO;
import com.github.daanielowsky.Oddaj_Ubrania.entity.Messages;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static com.github.daanielowsky.Oddaj_Ubrania.services.Converter.*;

@Service
public class MessagesService {

    private MessagesRepository messagesRepository;

    public MessagesService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    @Transactional
    public void creatingMessage(MessageDTO messageDTO){
        Messages messages = convertToMessagesFromDTO(messageDTO);
        messagesRepository.save(messages);
    }

    @Transactional
    public List<Messages> getAllMessages(){
        List<Messages> allBy = messagesRepository.getAllBy();
        return allBy;
    }

    public void deleteMessage(Long id) {
        Messages messageById = messagesRepository.getMessageById(id);
        messagesRepository.delete(messageById);
    }

    public Long countAllMessages(){
        Long messagesAmount = messagesRepository.countAllBy();
        return messagesAmount;

    }
}
