package com.cg.model.enums;

public enum EPurchaseOrderStatus {
    PENDING("Đang Chờ Xử Lý"),
    COMPLETED("Hoàn Tất");
    private final String value;

    EPurchaseOrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
