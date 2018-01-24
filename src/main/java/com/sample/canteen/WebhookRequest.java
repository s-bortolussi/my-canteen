package com.sample.canteen;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebhookRequest {

    private Result result;

    public WebhookRequest() {
    }

    public WebhookRequest(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "WebhookRequest{" +
                "result=" + result +
                '}';
    }
}
