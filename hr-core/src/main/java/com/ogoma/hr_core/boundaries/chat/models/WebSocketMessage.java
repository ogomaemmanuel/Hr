package com.ogoma.vue_starter.vue_starter.boundaries.chat.models;

public class WebSocketMessage<T> {
    private String type;
    private T  data;
    private String message;

    public String getType() {
        return type;
    }

    public WebSocketMessage<T> setType(String type) {
        this.type = type;
        return this;
    }

    public T getData() {
        return data;
    }

    public WebSocketMessage<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public WebSocketMessage<T> setMessage(String message) {
        this.message = message;
        return this;
    }

}
