package com.github.m3ssman.spring.activemq.model;

import java.io.Serializable;

public class Notification implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String to;
    private String body;

    public Notification() {
    }

    public Notification(String to, String body) {
        this.to = to;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format("Notification{to=%s, body=%s}", getTo(), getBody());
    }

}
