package com.dawityifter.development.McpDemo.model;

import java.util.Map;

public class McpRequest {

    private String tool;
    private Map<String,Object> arguments;

    public String getTool() {
        return tool;
    }

    public Map<String,Object> getArguments() {
        return arguments;
    }
}