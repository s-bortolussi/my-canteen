package com.sample.canteen;

import java.util.List;

public class WebhookResponse {

    private List<Item> items;

    private List<Suggestion> suggestions;

    public WebhookResponse() {
    }

    public WebhookResponse(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }
}
