package org.example.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menuItems = new ArrayList<>();

        // 메뉴 설정
        menuItems.add(new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(2, "SmokeShack", 8.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(3, "Cheeseburger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem(4, "Hamburger", 5.4, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));

        // 메뉴 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem menu : menuItems) {
            System.out.println(menu);
        }
        System.out.println("0. 종료      | 종료");

        while (true) {
            System.out.print("메뉴의 번호를 선택해 주세요: ");
            int choice = scanner.nextInt();
            // 만약 0이면 프로그램 종료
            if (choice == 0) {
                System.out.println("키오스크 프로그램을 종료합니다.");
                scanner.close();
                return;
            }

            MenuItem selectedMenu = null;
            // menuItems의 id와 입력값이 같다면 출력 / 아니면 지원하지 않는 메뉴
            for (MenuItem menu : menuItems) {
                if (menu.getId() == choice) {
                    selectedMenu = menu;
                    break;
                }
            }

            if (selectedMenu != null) {
                System.out.println("선택한 메뉴: " + selectedMenu);
            } else {
                System.out.println("해당 번호의 메뉴가 없습니다.");
            }
        }
    }
}
