package com.dawityifter.development.McpDemo.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ExternalBillpayApiClient {
    private final WebClient webClient;

    public ExternalBillpayApiClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://payment-service")
                .build();
    }

    public Object post(String path, Object body) {

        return webClient.post()
                .uri(path)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }
}