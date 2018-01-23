package com.sample.canteen;

import java.util.Date;

public class MenuBuilder {
    private Date date;
    private String starter;
    private String mainCourse;
    private String sideOrder;
    private String dessert;

    public MenuBuilder date(Date date) {
        this.date = date;
        return this;
    }

    public MenuBuilder starter(String starter) {
        this.starter = starter;
        return this;
    }

    public MenuBuilder mainCourse(String mainCourse) {
        this.mainCourse = mainCourse;
        return this;
    }

    public MenuBuilder sideOrder(String sideOrder) {
        this.sideOrder = sideOrder;
        return this;
    }

    public MenuBuilder dessert(String dessert) {
        this.dessert = dessert;
        return this;
    }

    public Menu build() {
        return new Menu(date, starter, mainCourse, sideOrder, dessert);
    }
}