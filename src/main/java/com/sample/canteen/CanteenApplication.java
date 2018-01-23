package com.sample.canteen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class CanteenApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanteenApplication.class, args);
    }

    @Bean
    CommandLineRunner init(MenuRepository menuRepository) {
        menuRepository.deleteAll();
        return (arg) -> Arrays.asList(
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
                        .build()
        ).forEach(menuRepository::save);
    }


}
