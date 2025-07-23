# 🍔 Console Kiosk

자바를 이용한 콘솔 기반 키오스크 시스템입니다.  
단계별로 객체지향 설계를 적용하며 확장 가능한 구조로 구현하였습니다.  
`Scanner`, `조건문`, `반복문`부터 시작해 `클래스 분리`, `캡슐화`, `스트림`, `Enum` 등을 사용했습니다.


<br />

## Lv 1. 기본 키오스크 흐름 제어

햄버거 메뉴 리스트 출력

사용자 숫자 입력 → 해당 메뉴 출력 or 종료

Scanner, if, while 문을 통해 흐름 제어

<br />


## Lv 2. MenuItem 클래스로 메뉴 관리

메뉴 항목을 객체로 분리 (이름, 가격, 설명)

List<MenuItem>을 통해 햄버거 메뉴 관리

반복문을 통해 전체 메뉴 출력 및 사용자 선택

<br />


## Lv 3. Kiosk 클래스로 흐름 분리

전체 메뉴 흐름을 담당하는 Kiosk 클래스 생성

start() 메서드로 프로그램 시작 및 제어

main()에서는 Kiosk 객체만 생성 및 실행

<br />


## Lv 4. Menu 클래스를 통한 카테고리화

MenuItem들을 포함하는 Menu 클래스 생성

Kiosk에서 List를 통해 여러 카테고리 관리

메뉴 선택 → 메뉴 상세 출력

뒤로가기 및 종료 구현

<br />


## Lv 5. 캡슐화

모든 클래스의 필드를 private으로 보호

getter, setter를 통한 안전한 데이터 접근

<br />


# 🛒 도전 기능: 장바구니 및 주문 처리

## Lv 6. 장바구니 구현

선택한 메뉴 → 장바구니에 추가 여부 묻기

장바구니 목록 및 총 금액 확인

주문 완료 시 장바구니 초기화

<br />

## Lv 7. Enum & Stream 활용

사용자 유형 Enum (학생, 군인, 일반인) → 할인 적용

스트림을 사용한 장바구니 필터링 및 출력

람다를 통한 간결한 처리


# 회고록 보기
Lv1, Lv2 : https://www.notion.so/Lv1-Lv2-23255d5f00a080e39ac3e45c1c31fd4c?source=copy_link
Lv3 : https://www.notion.so/Lv3-23255d5f00a080aca412c88207278543?source=copy_link
Lv4, Lv5 : https://www.notion.so/Lv4-Lv5-23355d5f00a080878fa0c3ef054bcb4f?source=copy_link
Lv6 : https://www.notion.so/Lv6-23755d5f00a0807bbb7aecb2e79eb9a5?source=copy_link
Lv7 : https://www.notion.so/Lv7-23955d5f00a0802ca667cf08609cb511?source=copy_link
