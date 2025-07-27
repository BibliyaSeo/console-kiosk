package org.example.answer;

public enum UserType {
    NATIONAL_MERIT(0.10),   // 국가유공자
    MILITARY(0.05),         // 군인
    STUDENT(0.03),          // 학생
    NORMAL(0.00);           // 일반

    private final double discountRate;

    UserType(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}