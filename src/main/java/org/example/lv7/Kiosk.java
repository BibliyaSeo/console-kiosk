package org.example.lv7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Kiosk {
    // 스캐너 선언
    Scanner scanner = new Scanner(System.in);
    // 클래스에 바로 . 하지 말라고 하셨는데 더미데이터는 거의 static으로 사용하길래...
    private final List<Menu> menus = List.of(
            MenuData.getBurger(),
            MenuData.getDrinks(),
            MenuData.getDesserts()
    );

    List<CartItem> shoppingCart = new ArrayList<>();

    private boolean showMainMenu = true;
    private boolean showMenuItem = true;
    private Menu menuByCategory = null;

    public void start() {
        // 반복문 시작
        while (true) {
            if (showMainMenu) {
                // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
                System.out.println("[MAIN MENU]");
                // for문 형식
                /* for (int i = 0; i < menus.size(); i++) {
                *    System.out.println((i + 1) + ". " + menus.get(i).getCategory());
                } */

                // IntStream 형식
                IntStream.range(0, menus.size())
                        .forEach(i -> System.out.println((i + 1) + ". " + menus.get(i).getCategory()));

                System.out.println("0. 종료      | 종료");

                int choiceMain;

                // 오더 메뉴 보여주기
                if (!shoppingCart.isEmpty()) {
                    System.out.println();
                    System.out.println("[ORDER MENU]");
                    System.out.println((menus.size() + 1) + ". Orders      | 장바구니를 확인 후 주문합니다.");
                    System.out.println((menus.size() + 2) + ". Cancel      | 진행중인 주문을 취소합니다.");
                    // 숫자 입력 받기
                    choiceMain = getChoiceMenu("원하시는");
                } else {
                    // 숫자 입력 받기
                    choiceMain = getChoiceMenu("메인");
                }

                // 프로그램 종료
                if (choiceMain == 0) {
                    System.out.println("키오스크 프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }

                // 에러 처리
                if (choiceMain == -9999) {
                    System.out.println("숫자를 입력해 주세요.");
                    System.out.println();
                    continue;
                }

                // shopping cart가 있을시 선택이 +2까지 가능하게 해야함 함

                // 쇼핑 카트가 비었을 경우
                if (shoppingCart.isEmpty()) {
                    if (choiceMain < 0 || choiceMain > menus.size()) {
                        System.out.println("해당 번호의 메뉴가 없습니다.");
                        System.out.println();
                    } else {
                        // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                        menuByCategory = menus.get(choiceMain - 1);
                        // 메인메뉴 안 보여 주고 서브 메뉴로 넘어가기
                        showMainMenu = false;
                        showMenuItem = true;
                    }
                } else {
                    /* 쇼핑 카트가 있을 경우
                     * 1. 숫자가 size만큼일 경우
                     * 2. size+1일 경우 -> 쇼핑 카트가 비었으면
                     * 3. size+2일 경우
                     */
                    if (choiceMain > 0 && choiceMain <= menus.size()) {
                        menuByCategory = menus.get(choiceMain - 1);
                        showMainMenu = false;
                        showMenuItem = true;
                    } else if (choiceMain == (menus.size() + 1)) {
                        // 장바구니로 이동
                        showMainMenu = false;
                        showMenuItem = false;
                        System.out.println();
                        System.out.println("[ Orders ]");
                        // 같은 거 골랐을 때 수량 체크해서 넣어줘야하낭? -> 밑에서 해결

                        // for문 사용시
                        // double total = 0;
                        /* for (CartItem item : shoppingCart) {
                        *    System.out.println(item.toString());
                        *    total += item.getTotalPrice();
                        }*/

                        // Stream 사용
                        // 근데 여기서 SmokeShack 값만 빼고 싶다면?? .filter()이용해서.
                        double total = shoppingCart.stream()
                                .filter(item -> !item.getMenuItem().getName().equals("SmokeShack"))
                                .peek(item -> System.out.println(item))
                                .mapToDouble(item -> item.getTotalPrice())
                                .sum();

                        System.out.println();
                        // 장바구니 담은 거에서 값 합쳐줘야함
                        System.out.println("[ Total ]");
                        System.out.println(String.format("W %.2f", total));
                        System.out.println("1. 주문         2. 메뉴판");
                        if (scanner.hasNextInt()) {
                            int choice = scanner.nextInt();
                            if (choice == 1) {
                                // 주문 (주문이 완료 되었습니다. 쇼핑 카트 초기화)
                                // 할인 정보 추가
                                System.out.println();
                                System.out.println("할인 정보를 입력해 주세요.");

                                // for문 사용
                                /* for (DiscountType type : DiscountType.values()) {
                                *    System.out.println(
                                *            type.getChoice() + ". " + type.getUserType() + " : " + (int) (type.getDiscountRate() * 100) + "%");
                                } */

                                // Stream 사용
                                Stream.of(DiscountType.values())
                                        .forEach(type -> System.out.println(
                                                type.getChoice() + ". " + type.getUserType() + " : " + (int) (type.getDiscountRate() * 100) + "%"
                                        ));

                                // 할인에 따른 total 가격 조절해야함
                                if (scanner.hasNextInt()) {
                                    int choiceType = scanner.nextInt();
                                    if (choiceType > 0 && choiceType <= DiscountType.values().length) {
                                        // 매칭해서 선택한 번호에 따라서 이넘 값 가져오기
                                        DiscountType selected = DiscountType.fromChoice(choiceType);
                                        double discountRate = selected.getDiscountRate();
                                        double discountedTotal = total * (1 - discountRate);

                                        if (choiceType == 4) {
                                            System.out.println("주문이 완료되었습니다. 금액은 " + String.format("W %.2f", total) + " 입니다.");
                                        } else {
                                            System.out.println("주문이 완료되었습니다.\n할인이 적용된 금액은 " + String.format("W %.2f", discountedTotal) + " 입니다.");
                                        }

                                        shoppingCart.clear();
                                        System.out.println();
                                        showMainMenu = true;
                                    } else {
                                        System.out.println("유효한 숫자를 입력해 주세요.");
                                        scanner.nextLine();
                                    }
                                } else {
                                    System.out.println("유효한 숫자를 입력해 주세요.");
                                    scanner.nextLine();
                                }
                            } else if (choice == 2) {
                                // 메뉴판으로 돌아가기
                                System.out.println();
                                showMainMenu = true;
                            } else {
                                System.out.println("1번과 2번 중 골라주세요.");
                                scanner.nextLine();
                            }
                        } else {
                            System.out.println("1번과 2번 중 골라주세요.");
                            scanner.nextLine();
                        }

                    } else if (choiceMain == (menus.size() + 2)) {
                        // 진행중인 주문 취소 -> 쇼핑카트 리셋
                        System.out.println("진행 중인 주문을 취소합니다.");
                        shoppingCart.clear();
                        System.out.println();
                        showMainMenu = true;
                    } else {
                        System.out.println("해당 번호의 메뉴가 없습니다.");
                        System.out.println();
                    }
                }


            } else {
                // 메인 메뉴 말고 카테고리별 메뉴 보여주기
                if (showMenuItem) {
                    System.out.println();
                    System.out.println("[" + menuByCategory.getCategory().toUpperCase() + " MENU]");
                    List<MenuItem> menuItems = menuByCategory.getMenuItems();
                    // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력

                    // for문 사용
                    /* for (int i = 0; i < menuItems.size(); i++) {
                    *    System.out.println((i + 1) + ". " + menuItems.get(i));
                    } */

                    // IntStream 사용
                    IntStream.range(0, menuItems.size())
                            .forEach(i -> System.out.println((i + 1) + ". " + menuItems.get(i)));

                    System.out.println("0. 메인 메뉴로    | 뒤로가기");

                    // 숫자 입력 받기
                    int choiceMenu = getChoiceMenu(menuByCategory.getCategory());

                    // 뒤로 가기
                    if (choiceMenu == 0) {
                        System.out.println();
                        showMainMenu = true;
                        // continue 안 넣어주면 안 됨!
                        continue;
                    }

                    // 에러 처리
                    if (choiceMenu == -9999) {
                        System.out.println("숫자를 입력해 주세요.");
                        System.out.println();
                        continue;
                    }

                    if (choiceMenu < 0 || choiceMenu > menuByCategory.getMenuItems().size()) {
                        System.out.println("해당 번호의 메뉴가 없습니다.");
                        System.out.println();
                    } else {
                        // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                        // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.
                        MenuItem menuItemByCategory = menuByCategory.getMenuItems().get(choiceMenu - 1);
                        System.out.println();
                        System.out.println(menuItemByCategory);

                        // 장바구니 추가
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인         2. 취소");


                        if (scanner.hasNextInt()) {
                            boolean found = false;
                            int choice = scanner.nextInt();
                            if (choice == 1) {
                                // stream으로 바꾸려 했는데... 포기! for문으로 그냥 둠
                                for (CartItem item : shoppingCart) {
                                    if (item.getMenuItem().getName().equals(menuItemByCategory.getName())) {
                                        // 같은 항목이 있으면 수량 증가
                                        item.increaseQuantity();
                                        found = true;
                                        break;
                                    }
                                }
                                // 겹치는 거 없으면 바로 추가
                                if (!found) {
                                    shoppingCart.add(new CartItem(menuItemByCategory));
                                }
                                System.out.println();
                                System.out.println(menuItemByCategory.getName() + " 이 장바구니에 추가되었습니다.");
                                System.out.println();
                                showMainMenu = true;
                            }
                        } else {
                            System.out.println("1번과 2번 중 골라주세요.");
                            scanner.nextLine();
                        }
                    }
                }
            }
        }
    }

    private int getChoiceMenu(String label) {
        System.out.print(label + " 메뉴의 번호를 선택해 주세요: ");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.nextLine();
            return -9999;
        }
    }
}
