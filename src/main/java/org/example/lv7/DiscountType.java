package org.example.lv7;

public enum DiscountType {
    VETERAN(1, "국가유공자", 0.10),
    SOLDIER(2, "군인", 0.05),
    STUDENT(3, "학생", 0.03),
    COMMONER(4, "일반", 0.00);

    private final int choice;
    private final String userType;
    private final double discountRate;

    DiscountType(int choice, String userType, double discountRate) {
        this.choice = choice;
        this.userType = userType;
        this.discountRate = discountRate;
    }

    public int getChoice() {
        return choice;
    }

    public String getUserType() {
        return userType;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    // 연산자 매칭 번호에 따라서 타입 return하기
    public static DiscountType fromChoice(int choice) {
        for (DiscountType type : values()) {
            if (type.getChoice() == choice) {
                return type;
            }
        }
        throw new IllegalArgumentException("해당되는 할인 유형이 없습니다.");
    }
}
