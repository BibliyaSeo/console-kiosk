package org.example.lv3;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.setMenuItems(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        kiosk.setMenuItems(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        kiosk.setMenuItems(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        kiosk.setMenuItems(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");
        kiosk.start();
    }
}
