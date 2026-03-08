package com.dawityifter.development.McpDemo.tools;

import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

public class DynamicMcpTool implements McpTool {

    private final String name;
    private final String serviceUrl;
    private final String path;
    private final HttpMethod method;
    private final WebClient client;

    public DynamicMcpTool(
            String name,
            String serviceUrl,
            String path,
            HttpMethod method,
            WebClient client) {

        this.name = name;
        this.serviceUrl = serviceUrl;
        this.path = path;
        this.method = method;
        this.client = client;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public org.springframework.ai.chat.messages.ToolResponseMessage.ToolResponse execute(Map<String, Object> args) {

        Object result = client.method(method)
                .uri(serviceUrl + path)
                .bodyValue(args)
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        return new org.springframework.ai.chat.messages.ToolResponseMessage.ToolResponse(null, name(),
                result != null ? result.toString() : "");
    }
}