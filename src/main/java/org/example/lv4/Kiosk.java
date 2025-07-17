package org.example.lv4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // 스캐너 선언
    Scanner scanner = new Scanner(System.in);
    // 선용 튜터님께서 클래스에 . 하지 말라고 하셨는데 더미데이터는 거의 static으로 사용하길래...
    // 바로 . 해버렸어욯...ㅎㅎ
    List<Menu> menus = List.of(
            MenuData.getBurger(),
            MenuData.getDrinks(),
            MenuData.getDesserts()
    );

    boolean showMainMenu = true;
    Menu menuByCategory = null;

    public void start() {
        // 반복문 시작
        while (true) {
            if (showMainMenu) {
                // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
                System.out.println("[MAIN MENU]");
                for (int i = 0; i < menus.size(); i++) {
                    System.out.println((i + 1) + ". " + menus.get(i).getCategory());
                }
                System.out.println("0. 종료      | 종료");

                // 숫자 입력 받기
                int choice = getChoiceMenuId("메인");


                if (choice == 0) {
                    System.out.println("키오스크 프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }

                if (choice < 0 || choice >= menus.size()) {
                    System.out.println("해당 번호의 메뉴가 없습니다.");
                } else {
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                    // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?
                    menuByCategory = menus.get(choice - 1);
                    showMainMenu = false;

                }
            } else {
                // 메인 메뉴 말고 카테고리별 메뉴 보여주기
                System.out.println(menuByCategory.getCategory().toUpperCase() + " MENU");
                // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                List<MenuItem> menuItems = menuByCategory.getMenuItems();
                

                // 숫자 입력 받기

                // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
            }
        }
    }

    private int getChoiceMenuId(String label) {
        System.out.print(label + " 메뉴의 번호를 선택해 주세요: ");
        return scanner.nextInt();
    }
}
