package com.sample.canteen;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WebhookRequestTest {

    @Test
    public void requestWithResultParametersIsRead() throws Exception {

        WebhookRequest request = DataFixture.readTestDataFile("webhook_request.json", WebhookRequest.class);

        assertEquals("2018-01-23", request.getResult().getParameters().get("date"));

    }

}