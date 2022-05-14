package com.ogoma.hr_core.models;

public class ResponseModel<T> {
    private String state;
    private String status;
    private String message;
    private T data;

    public String getState() {
        return state;
    }

    public ResponseModel<T> setState(String state) {
        this.state = state;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ResponseModel<T> setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseModel<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseModel<T> setData(T data) {
        this.data = data;
        return this;
    }
}
