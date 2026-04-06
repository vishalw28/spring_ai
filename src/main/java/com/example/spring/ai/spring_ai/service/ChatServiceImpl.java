package com.example.spring.ai.spring_ai.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.example.spring.ai.spring_ai.entity.Tut;

import lombok.experimental.var;

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
            //     .maxTokens(100) // To reduce the output
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

    public String chatTemplate(){
       
        
        var systemPromptTEmplate = SystemPromptTemplate.builder()
            .template("You are a helpful conding assistant. You are an expert in coding")
            .build();

        var systemMsg = systemPromptTEmplate.createMessage();
        
         String query="""
                Tell about with {techName} with an example of {example}
                """;
        
        PromptTemplate userPromptTemplate = PromptTemplate.builder().template(query).build();
        // // Render the template
        
        var userMsg = userPromptTemplate.createMessage(Map.of("techName", "Spring",
            "example", "Spring exception"
        ));

        Prompt prompt = new Prompt(systemMsg, userMsg);

        return this.chatClient.prompt(prompt).call().content();
    }
}
