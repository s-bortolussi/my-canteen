package com.sample.canteen;

public class Item {

    private SimpleResponse simpleResponse;

    public Item() {
    }

    public Item(SimpleResponse simpleResponse) {
        this.simpleResponse = simpleResponse;
    }

    public SimpleResponse getSimpleResponse() {
        return simpleResponse;
    }
}
