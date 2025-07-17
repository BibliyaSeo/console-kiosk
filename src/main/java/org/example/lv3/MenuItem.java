package org.example.lv3;

public class MenuItem {
    int id;
    String name;
    double price;
    String description;

    public MenuItem(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + ". " + name + " | W " + price + " | " + description;
    }
}
