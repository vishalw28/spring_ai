package com.example.spring.ai.spring_ai.service;

import com.example.spring.ai.spring_ai.entity.Tut;
import java.util.List;

public interface ChatService {
    List<Tut> chat(String query);
}
