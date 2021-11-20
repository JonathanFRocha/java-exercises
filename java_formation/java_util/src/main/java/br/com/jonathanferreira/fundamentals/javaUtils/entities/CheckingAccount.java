package br.com.jonathanferreira.fundamentals.javaUtils.entities;

public class CheckingAccount {
    private String agency;
    private String number;

    public CheckingAccount(String agency, String number) {
        this.agency = agency;
        this.number = number;
    }

    public CheckingAccount() {
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
