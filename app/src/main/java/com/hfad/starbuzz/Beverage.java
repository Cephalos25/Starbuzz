package com.hfad.starbuzz;

public class Beverage {
    private String name;
    private String description;
    private int imageResourceId;

    private Beverage(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    private Beverage() {
    }

    public static final Beverage[] beverages = {
        new Beverage("Latte", "A couple of espresso shots with steamed milk.", R.drawable.latte),
        new Beverage("Cappuccino", "Espresso, hot milk, and steamed milk foam.", R.drawable.cappuccino),
        new Beverage("Filter", "Highest quality beans raosted and brewed fresh", R.drawable.filter)
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return name;
    }
}
