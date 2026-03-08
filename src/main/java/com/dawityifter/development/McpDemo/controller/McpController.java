package com.dawityifter.development.McpDemo.controller;


import com.dawityifter.development.McpDemo.model.McpRequest;
import com.dawityifter.development.McpDemo.model.McpResponse;
import com.dawityifter.development.McpDemo.registry.ToolRegistry;
import com.dawityifter.development.McpDemo.tools.McpTool;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mcp")
public class McpController {

    private final ToolRegistry registry;

    public McpController(ToolRegistry registry) {
        this.registry = registry;
    }

    @PostMapping
    public McpResponse call(@RequestBody McpRequest request) {

        McpTool tool = registry.get(request.getTool());

        Object result =
                tool.execute(request.getArguments());

        return new McpResponse(result);
    }
}