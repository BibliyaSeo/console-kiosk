package org.example.lv6;

import java.util.List;

public class Menu {
    private final String category;
    private final List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    // List를 리턴하는 함수
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.
    public String getCategory() {
        return category;
    }
}
