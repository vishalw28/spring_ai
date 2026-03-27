package com.example.spring.ai.spring_ai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.ai.spring_ai.entity.Tut;
import com.example.spring.ai.spring_ai.service.ChatService;


@RestController
@RequestMapping
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chat")
    public ResponseEntity<List<Tut>> chat(@RequestParam(value="q") String query){
        var resultResponse = chatService.chat(query);
        return ResponseEntity.ok(resultResponse);
    }
    
}
