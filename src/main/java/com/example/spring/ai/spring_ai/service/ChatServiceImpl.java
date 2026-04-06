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
        this.chatClient = builder
            // Default options or default related methods helps you while building the big system.
            // eg. You're building the coding assistance. Due to below configuration it always act as coding expert.
            // .defaultSystem("You are a helpful coding assistant. You are an expert in coding.")
            // // .defaultAdvisors() => Advisors are like interceptors
            // .defaultOptions(OpenAiChatOptions.builder()
            //     .model("gpt-4o-mini")
            //     .temperature(0.3)
            //     .maxTokens(100)
            //     .build())
            .build();
    }

    @Override
    public List<Tut> chat(String query) {
        Prompt prompt = new Prompt(query);
        String template = "As an expert in coding and programming. Always write a program in java. Now reply for this question: {query}";
        List<Tut> content =chatClient.
            prompt() // we can pass prompt here too.
            .user(u -> u.text(template).param("query", query))
            .call()
            .entity(new ParameterizedTypeReference<List<Tut>>(){});

        System.out.println(content);
            //.content();
       return content;
    }

}
