package org.example.lv5;

public class MenuItem {
    // 이름, 가격, 설명 필드 선언하여 관리
    private final String name;
    private final double price;
    private final String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.
    @Override
    public String toString() {
        return name + " | W " + price + " | " + description;
    }
}
