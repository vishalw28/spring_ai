package com.example.spring.ai.spring_ai.service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.example.spring.ai.spring_ai.entity.Tut;

@Service
public class ChatServiceImpl implements ChatService{

    private final ChatClient chatClient;

    public ChatServiceImpl(org.springframework.ai.chat.client.ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public List<Tut> chat(String query) {
        List<Tut> content =chatClient.
            prompt(new Prompt(query, OpenAiChatOptions.builder()
                .model("gpt-4o-mini")
                .temperature(0.3)
                .maxTokens(100)
                .build())) // we can pass prompt here too.
            .call()
            .entity(new ParameterizedTypeReference<List<Tut>>(){});

        System.out.println(content);
            //.content();
       return content;
    }

}
