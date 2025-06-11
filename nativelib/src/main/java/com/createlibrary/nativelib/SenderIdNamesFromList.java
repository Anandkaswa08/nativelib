package com.createlibrary.nativelib;

public class SenderIdNamesFromList {


    public String getSixCharacterSender() {
        return sixCharacterSender;
    }

    public void setSixCharacterSender(String sixCharacterSender) {
        this.sixCharacterSender = sixCharacterSender;
    }

    public String getChangeNameOfSender() {
        return changeNameOfSender;
    }

    public void setChangeNameOfSender(String changeNameOfSender) {
        this.changeNameOfSender = changeNameOfSender;
    }

    public int getSenderNameFindWhere() {
        return senderNameFindWhere;
    }

    public void setSenderNameFindWhere(int senderNameFindWhere) {
        this.senderNameFindWhere = senderNameFindWhere;
    }

    public String getSenderNameLogo() {
        return senderNameLogo;
    }

    public void setSenderNameLogo(String senderNameLogo) {
        this.senderNameLogo = senderNameLogo;
    }

    public boolean isSenderIDPresent() {
        return isSenderIDPresent;
    }

    public void setSenderIDPresent(boolean senderIDPresent) {
        isSenderIDPresent = senderIDPresent;
    }

    String sixCharacterSender = "";
    String changeNameOfSender = "";
    int senderNameFindWhere = 0;
    String senderNameLogo = "";
    boolean isSenderIDPresent = false;

    public String getCheckIfBankID() {
        return checkIfBankID;
    }

    public void setCheckIfBankID(String checkIfBankID) {
        this.checkIfBankID = checkIfBankID;
    }

    String checkIfBankID = "0";



}
