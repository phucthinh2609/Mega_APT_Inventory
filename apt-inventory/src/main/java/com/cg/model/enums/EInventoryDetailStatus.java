package com.cg.model.enums;

public enum EInventoryDetailStatus {
    IN_STOCK("Tồn kho"),
    EXPORTED("Đã xuất kho"),
    SOLD("Đã bán");
    private final String value;
    EInventoryDetailStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
