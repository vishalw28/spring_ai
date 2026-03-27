package com.example.spring.ai.spring_ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import com.example.spring.ai.spring_ai.entity.Tut;

@Service
public class ChatServiceImpl implements ChatService{

    private final ChatClient chatClient;

    public ChatServiceImpl(org.springframework.ai.chat.client.ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    
    


    @Override
    public Tut chat(String query) {
        var content =chatClient.
            prompt(new Prompt(query)) // we can pass prompt here too.
            .call()
            .entity(Tut.class); // With entity it 
            /**
                Result:
                {
                    title: "Java Programming Language",
                    content: "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language that is widely used for building enterprise-scale applications, mobile applications, and web applications. Java is known for its portability across platforms, thanks to the Java Virtual Machine (JVM), which allows Java programs to run on any device that has the JVM installed.",
                    createdYear: "1995"
                }

                But same 
             */

        System.out.println(content);
            //.content();
       return content;
    }

}
