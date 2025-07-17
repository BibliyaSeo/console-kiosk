package org.example.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    List<MenuItem> menuItems = new ArrayList<>();

    public void start() {
        // 메뉴 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for (MenuItem menu : menuItems) {
            System.out.println(menu);
        }
        System.out.println("0. 종료      | 종료");

        // 실행
        runKiosk();
    }

    public void setMenuItems(int id, String name, double price, String description) {
        menuItems.add(new MenuItem(id, name, price, description));
    }

    // 이 안에서만 사용하니까 private
    private void runKiosk() {
        while (true) {
            int choice = getChoiceMenuId();
            // 만약 0이면 프로그램 종료
            if (choice == 0) {
                System.out.println("키오스크 프로그램을 종료합니다.");
                scanner.close();
                return;
            }

            MenuItem selectedMenu = findMenuById(choice);

            if (selectedMenu != null) {
                System.out.println("선택한 메뉴: " + selectedMenu);
            } else {
                System.out.println("해당 번호의 메뉴가 없습니다.");
            }
        }
    }

    private int getChoiceMenuId() {
        System.out.print("메뉴의 번호를 선택해 주세요: ");
        return scanner.nextInt();
    }

    private MenuItem findMenuById(int id) {
        for (MenuItem menu : menuItems) {
            if (menu.getId() == id) {
                return menu;
            }
        }
        return null;
    }
}
