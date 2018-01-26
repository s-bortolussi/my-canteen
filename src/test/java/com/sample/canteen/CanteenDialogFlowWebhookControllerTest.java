package com.sample.canteen;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class CanteenDialogFlowWebhookControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CanteenDialogFlowWebhookController controller;

    @Mock
    private MenuRepository menuRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @Test
    public void webhook() throws Exception {
        Mockito.when(menuRepository.findByDate(Year.of(2018).atMonth(1).atDay(23)))
                .thenReturn(
                        new MenuBuilder()
                                .date(Year.of(2018).atMonth(1).atDay(23))
                                .starter("a starter")
                                .mainCourse("a main course")
                                .sideOrder("a side order")
                                .dessert("a dessert")
                                .build()
                );


        this.mockMvc.perform(post("/webhook")
                .content(DataFixture.toJson(webhookRequest()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.speech", Matchers.equalTo("Au menu, en entrée : a starter , en plat principal : a main course et a side order, en dessert : a dessert. Bon appetit.\n Je reste disponible pour vous donner le menu d'un autre jour.")))
                .andExpect(jsonPath("$.displayText", Matchers.equalTo("Au menu, en entrée : a starter , en plat principal : a main course et a side order, en dessert : a dessert. Bon appetit.\n Je reste disponible pour vous donner le menu d'un autre jour.")));
    }

    private WebhookRequest webhookRequest() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("date", "2018-01-23");
        Result result = new Result(parameters);
        return new WebhookRequest(result);
    }

}