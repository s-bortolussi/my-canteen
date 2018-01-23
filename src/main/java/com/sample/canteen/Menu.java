package com.sample.canteen;


import java.util.Date;

public class Menu {

    private Date date;

    private String starter;

    private String mainCourse;

    private String sideOrder;

    private String dessert;

    public Menu(Date date, String starter, String mainCourse, String sideOrder, String dessert) {
        this.date = date;
        this.starter = starter;
        this.mainCourse = mainCourse;
        this.sideOrder = sideOrder;
        this.dessert = dessert;
    }

    public Date getDate() {
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
