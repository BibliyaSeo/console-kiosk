package org.example.lv4;

import java.util.List;

public class Menu {
    String category;
    List<MenuItem> menuItems;

    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    // MenuItem 클래스를 List로 관리

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    // List를 리턴하는 함수
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // 구조에 맞게 함수를 선언해놓고 가져다 사용하세요.
    public String getCategory() {
        return category;
    }
}
