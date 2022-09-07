package com.cg.model.enums;

public enum EBussinessStatus {
    NEW_RELEASES("Mới Ra Mắt"),
    NEW_ARRIVAL("Hàng Mới Về"),
    OUT_OF_STOCK("Tạm Hết Hàng"),
    STOP_SELLING("Ngừng Kinh Doanh");

    private final String value;

    EBussinessStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
