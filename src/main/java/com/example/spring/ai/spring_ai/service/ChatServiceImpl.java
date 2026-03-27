package com.example.spring.ai.spring_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    private final ChatClient chatClient;

    public ChatServiceImpl(org.springframework.ai.chat.client.ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    
    


    @Override
    public String chat(String query) {
        String prompt = "Tell me about virat kohli";
        // Prompt prompt = new Prompt(quer)
        String content =chatClient.
            prompt() // we can pass prompt here too.
            .user(prompt)
            .system("As an expert in cricket")
            .call()
            .content();
       return content;
    }

}
