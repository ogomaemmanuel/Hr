package com.ogoma.hr_core.enums;

public enum GenderEnum {
    M("M"), F("F");

    private String code;

    private GenderEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
