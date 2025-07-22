package org.example.lv6;

public class CartItem {
    // 수량 표기하려고 만듦
    private final MenuItem menuItem;
    private int quantity;

    public CartItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        this.quantity = 1;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        quantity++;
    }

    public double getTotalPrice() {
        return menuItem.getPrice() * quantity;
    }

    @Override
    public String toString() {
//        name + " | W " + price + " | " + description;
        return "수량 | " + quantity + " | " + menuItem.getName() + " | W " + menuItem.getPrice() + " | " + menuItem.getDescription();
    }
}
