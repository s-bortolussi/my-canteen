package com.sample.canteen;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class WebhookResponseTest {

    public static final String EXPECTED = "Au menu de 2018-01-29, en entrée : Velouté de citrouille , en plat principal : Escalope de dinde viennoise et sa poêlée romanesco, en dessert : Mousse au chocolat. Bon appetit :-)";

    @Test
    public void requestWithResultParametersIsRead() throws Exception {

        WebhookResponse response = DataFixture.readTestDataFile("webhook_response.json", WebhookResponse.class);

        assertEquals(EXPECTED, response.getItems().get(0).getSimpleResponse().getDisplayText());
        assertEquals(EXPECTED, response.getItems().get(0).getSimpleResponse().getTextToSpeech());


    }

}