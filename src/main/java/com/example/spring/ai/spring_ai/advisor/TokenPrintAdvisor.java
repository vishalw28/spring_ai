package com.example.spring.ai.spring_ai.advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisor;
import org.springframework.ai.chat.client.advisor.api.StreamAdvisorChain;

import reactor.core.publisher.Flux;

public class TokenPrintAdvisor implements CallAdvisor, StreamAdvisor{
    private final Logger LOG = LoggerFactory.getLogger(TokenPrintAdvisor.class);

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public int getOrder() {
       return 0;
    }

    @Override
    public Flux<ChatClientResponse> adviseStream(ChatClientRequest chatClientRequest,
            StreamAdvisorChain streamAdvisorChain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adviseStream'");
    }

    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        LOG.info("My TokenPrintAdvisor is called");
        LOG.info("Request sent to the model: {}", chatClientRequest.prompt().getContents());
        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);
        LOG.info("Response received from model: {}", chatClientResponse.chatResponse().getResult().getOutput().getText());
        LOG.info("Prompt token: {}", chatClientResponse.chatResponse().getMetadata().getUsage().getPromptTokens());
        LOG.info("Completion token: {}", chatClientResponse.chatResponse().getMetadata().getUsage().getCompletionTokens());
        LOG.info("Total consumed token: {}", chatClientResponse
        .chatResponse()
        .getMetadata()
        .getUsage()
        .getTotalTokens());
		return chatClientResponse;
    }

}
