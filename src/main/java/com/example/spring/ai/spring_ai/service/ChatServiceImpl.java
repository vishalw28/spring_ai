package com.example.spring.ai.spring_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{

    private final ChatClient chatClient;

    public ChatServiceImpl(org.springframework.ai.chat.client.ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    
    


    @Override
    public String chat(String query) {
    
        // Prompt prompt = new Prompt(quer)
        var content =chatClient.
            prompt(new Prompt(query)) // we can pass prompt here too.
            // .user(prompt)
            // .system("As an expert in cricket")
            .call()
            .chatResponse() // ChatResponse gives the metadata such as generation, assistent msg,
            // .getMetadata(); 
            /**
                MetaDataResult: 
                { id: chatcmpl-******, usage: DefaultUsage{promptTokens=8, completionTokens=9, totalTokens=17}, rateLimit: { @type: org.springframework.ai.openai.metadata.OpenAiRateLimit, requestsLimit: 10000, requestsRemaining: 9999, requestsReset: PT1M4S, tokensLimit: 200000; tokensRemaining: 199997; tokensReset: PT0S } }
            
            */
           .getResult()
           .getOutput()
           .getText();


        System.out.println(content);
            //.content();
       return content;
    }

}
