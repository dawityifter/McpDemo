package com.dawityifter.development.McpDemo.registry;

import com.dawityifter.development.McpDemo.tools.McpTool;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ToolRegistry {

    private final Map<String, McpTool> tools = new ConcurrentHashMap<>();

    public void register(McpTool tool) {
        tools.put(tool.name(), tool);
    }

    public McpTool get(String name) {
        McpTool tool = tools.get(name);

        if (tool == null) {
            throw new RuntimeException("Tool not found: " + name);
        }

        return tool;
    }

    public Collection<McpTool> list() {
        return tools.values();
    }
}
