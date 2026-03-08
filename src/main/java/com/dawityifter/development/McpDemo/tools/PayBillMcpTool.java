package com.dawityifter.development.McpDemo.tools;

import com.dawityifter.development.McpDemo.client.ExternalBillpayApiClient;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

@Component
public class PayBillMcpTool implements McpTool {

    private final ExternalBillpayApiClient apiClient;

    public PayBillMcpTool(ExternalBillpayApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public String name() {
        return "payBill";
    }

    @Override
    public org.springframework.ai.chat.messages.ToolResponseMessage.ToolResponse execute(Map<String, Object> args) {

        String memberId = (String) args.get("memberId");
        BigDecimal amount = new BigDecimal(args.get("amount").toString());

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Invalid amount");
        }

        Object result = apiClient.post(
                "/payments",
                args);
        return new org.springframework.ai.chat.messages.ToolResponseMessage.ToolResponse(null, name(),
                result != null ? result.toString() : "");
    }
}