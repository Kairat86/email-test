package com.epam.doshekenov.model;


import org.apache.commons.lang.RandomStringUtils;

public class EmailMessage {

    private String to;
    private String subject;
    private String msgText;

    public EmailMessage(String to, String subject, String msgText) {
        this.to = to;
        this.subject = subject;
        this.msgText = msgText;
    }

    public EmailMessage(String to) {
        this.to = to;
        this.subject = RandomStringUtils.randomAlphabetic(7);
        this.msgText = RandomStringUtils.randomAlphabetic(10);
    }

    public EmailMessage() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }
}
