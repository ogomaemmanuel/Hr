package com.ogoma.vue_starter.vue_starter.enums;

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
