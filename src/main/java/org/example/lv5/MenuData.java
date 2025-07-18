package org.example.lv5;

import java.util.List;

public class MenuData {
    public static Menu getBurger() {
        return new Menu("Burgers", List.of(
                new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
        ));
    }

    public static Menu getDrinks() {
        return new Menu("Drinks", List.of(
                new MenuItem("Coke", 2.0, "시원한 코카콜라"),
                new MenuItem("Lemonade", 2.5, "상큼한 레모네이드"),
                new MenuItem("Americano", 3.0, "고소한 아메리카노(ICE/HOT)"),
                new MenuItem("Milkshake", 3.5, "바닐라, 초코, 딸기, 쿠키앤크림")
        ));
    }

    public static Menu getDesserts() {
        return new Menu("Desserts", List.of(
                new MenuItem("Vanilla Ice Cream", 3.0, "맛있는 바닐라 아이스크림"),
                new MenuItem("Tiramisu", 3.5, "마스카포네 치즈 크림 잔뜩"),
                new MenuItem("Brownie", 4.0, "초코 가득 진한 맛의 디저트")
        ));
    }
}
