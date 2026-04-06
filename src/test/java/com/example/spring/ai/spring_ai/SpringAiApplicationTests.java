package com.example.spring.ai.spring_ai;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.ai.spring_ai.service.ChatService;

@SpringBootTest
class SpringAiApplicationTests {

	@Autowired
	private ChatService chatService;
	@Test
	void contextLoads() {
	}

	@Test
	void testTemplateRenderer(){
		System.out.println("Template renderer");
		var output = chatService.chatTemplate();
		System.out.println(output);
		assertNotNull(output);
	}

}
