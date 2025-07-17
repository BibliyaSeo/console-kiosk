package org.example.lv4;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // 스캐너 선언
    Scanner scanner = new Scanner(System.in);
    // 클래스에 바로 . 하지 말라고 하셨는데 더미데이터는 거의 static으로 사용하길래...
    List<Menu> menus = List.of(
            MenuData.getBurger(),
            MenuData.getDrinks(),
            MenuData.getDesserts()
    );

    boolean showMainMenu = true;
    Menu menuByCategory = null;
    MenuItem menuItemByCategory = null;

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
                int choiceMain = getChoiceMenu("메인");

                // 프로그램 종료
                if (choiceMain == 0) {
                    System.out.println("키오스크 프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }

                // 0보다 작거나 메뉴 사이즈보다 큰걸 선택했을때
                if (choiceMain < 0 || choiceMain > menus.size()) {
                    System.out.println("해당 번호의 메뉴가 없습니다.");
                } else {
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                    menuByCategory = menus.get(choiceMain - 1);
                    // 메인메뉴 안 보여 주고 서브 메뉴로 넘어가기
                    showMainMenu = false;
                }
            } else {
                // 메인 메뉴 말고 카테고리별 메뉴 보여주기
                System.out.println();
                System.out.println("[" + menuByCategory.getCategory().toUpperCase() + " MENU]");
                List<MenuItem> menuItems = menuByCategory.getMenuItems();
                // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력
                for (int i = 0; i < menuItems.size(); i++) {
                    System.out.println((i + 1) + ". " + menuItems.get(i));
                }
                System.out.println("0. 메인 메뉴로    | 뒤로가기");

                // 숫자 입력 받기
                int choiceMenu = getChoiceMenu(menuByCategory.getCategory());

                // 뒤로 가기
                if (choiceMenu == 0) {
                    showMainMenu = true;
                    // continue 안 넣어주면 오류남!
                    continue;
                }

                // 0보다 작거나 메뉴 사이즈보다 큰걸 선택했을때
                if (choiceMenu < 0 || choiceMenu > menuByCategory.getMenuItems().size()) {
                    System.out.println("해당 번호의 메뉴가 없습니다.");
                } else {
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                    // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
                    menuItemByCategory = menuByCategory.getMenuItems().get(choiceMenu - 1);
                    System.out.println();
                    System.out.println("선택한 메뉴: " + menuItemByCategory);
                }

            }
        }
    }

    private int getChoiceMenu(String label) {
        System.out.print(label + " 메뉴의 번호를 선택해 주세요: ");
        return scanner.nextInt();
    }
}
