package org.example.lv4;

import java.util.List;

public class MenuData {
    public static Menu getBurger() {
        return new Menu("Burgers", List.of(
                new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거"),
                new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
        ));
    }

    public static Menu getDrinks() {
        return new Menu("Drinks", List.of(
                new MenuItem(1, "Coke", 2.0, "시원한 코카콜라"),
                new MenuItem(2, "Lemonade", 2.5, "상큼한 레모네이드"),
                new MenuItem(3, "Americano", 3.0, "고소한 아메리카노(ICE/HOT)"),
                new MenuItem(4, "Milkshake", 3.5, "바닐라, 초코, 딸기, 쿠키앤크림")
        ));
    }

    public static Menu getDesserts() {
        return new Menu("Desserts", List.of(
                new MenuItem(1, "Vanilla Ice Cream", 3.0, "맛있는 바닐라 아이스크림"),
                new MenuItem(2, "Tiramisu", 3.5, "마스카포네 치즈 크림 잔뜩"),
                new MenuItem(3, "Brownie", 4.0, "초코 가득 진한 맛의 디저트")
        ));
    }
}
