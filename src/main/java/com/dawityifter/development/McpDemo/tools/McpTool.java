package com.dawityifter.development.McpDemo.tools;

import org.springframework.ai.chat.messages.ToolResponseMessage;

import java.util.Map;

public interface McpTool {
    String name();
    ToolResponseMessage.ToolResponse execute(Map<String, Object> args);
}
