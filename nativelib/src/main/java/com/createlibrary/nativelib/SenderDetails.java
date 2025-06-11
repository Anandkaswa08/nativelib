package com.createlibrary.nativelib;

public class SenderDetails {
    public String getSixCharacterSender() {
        return sixCharacterSender;
    }

    public void setSixCharacterSender(String sixCharacterSender) {
        this.sixCharacterSender = sixCharacterSender;
    }

    public String getSenderNameFound() {
        return senderNameFound;
    }

    public void setSenderNameFound(String senderNameFound) {
        this.senderNameFound = senderNameFound;
    }

    public String getIsBankSender() {
        return isBankSender;
    }

    public void setIsBankSender(String isBankSender) {
        this.isBankSender = isBankSender;
    }

    String sixCharacterSender = "";
    String senderNameFound = "";
    String isBankSender = "";
}
