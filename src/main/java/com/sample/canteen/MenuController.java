package com.sample.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class MenuController {

    @GetMapping("/menus")
    public List<Menu> listMenus() {
        return Arrays.asList(
                new MenuBuilder()
                        .date(new Date())
                        .starter("Velouté de citrouille")
                        .mainCourse("Escalope de dinde viennoise")
                        .sideOrder("Poêlée romanesco")
                        .dessert("Mousse au chocolat")
                        .build(),
                new MenuBuilder()
                        .date(new Date())
                        .starter("Chou blanc en salade")
                        .mainCourse("Sauté de bœuf bourguignon")
                        .sideOrder("Purée de pommes de terre maison")
                        .dessert("Petits suisses aux fruits")
                        .build());
    }

}

