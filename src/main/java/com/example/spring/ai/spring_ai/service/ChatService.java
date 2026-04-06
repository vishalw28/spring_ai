package com.example.spring.ai.spring_ai.service;

import java.util.List;

import com.example.spring.ai.spring_ai.entity.Tut;

public interface ChatService {
    List<Tut> chat(String query);
    String chatTemplate();
}
