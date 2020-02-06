package com.example.myresume.bean;

public class EventBusMessage {

    String message;
    int count;

    public EventBusMessage(String message) {
        this.message = message;
        count = 1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        count++;
    }

}
