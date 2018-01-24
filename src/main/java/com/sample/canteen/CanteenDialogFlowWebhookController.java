package com.sample.canteen;

import ai.api.model.Fulfillment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_DATE;

@RestController
public class CanteenDialogFlowWebhookController {

    Logger logger = LoggerFactory.getLogger(CanteenDialogFlowWebhookController.class);

    private MenuRepository menuRepository;

    public CanteenDialogFlowWebhookController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @PostMapping("/webhook")
    public Fulfillment webhook(@RequestBody WebhookRequest request) {
        logger.debug("request : " + request);
        Menu menu = menuRepository.findByDate(getDate(request));
        Fulfillment response = new Fulfillment();
        response.setSpeech(generateTextResponse(menu));
        response.setDisplayText(generateTextResponse(menu));
        return response;
    }

    private String generateTextResponse(Menu menu) {
        return String.format("Au menu de %s, en entrée : %s , en plat principal : %s et %s, en dessert : %s. Bon appetit :-)\n. Je reste disponible pour vous donner le menu d'un autre jour.", menu.getDate().toString(), menu.getStarter(), menu.getMainCourse(), menu.getSideOrder(), menu.getDessert());
    }

    private LocalDate getDate(WebhookRequest request) {
        return LocalDate.parse((String) request.getResult().getParameters().get("date"), ISO_DATE);
    }
}
