package com.sample.canteen;


import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Menu {

    @Id
    public String id;

    private LocalDate date;

    private String starter;

    private String mainCourse;

    private String sideOrder;

    private String dessert;

    public Menu(LocalDate date, String starter, String mainCourse, String sideOrder, String dessert) {
        this.date = date;
        this.starter = starter;
        this.mainCourse = mainCourse;
        this.sideOrder = sideOrder;
        this.dessert = dessert;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStarter() {
        return starter;
    }

    public String getMainCourse() {
        return mainCourse;
    }

    public String getSideOrder() {
        return sideOrder;
    }

    public String getDessert() {
        return dessert;
    }
}
