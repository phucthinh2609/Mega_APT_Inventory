package com.cg.model.enums;

public enum ESituationValue {
    PENDING("Đang Chờ Xử Lý"),
    DELIVERY("Đang Giao Hàng"),
    COMPLETE("Hoàn Thành");
    private final String value;
    ESituationValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
