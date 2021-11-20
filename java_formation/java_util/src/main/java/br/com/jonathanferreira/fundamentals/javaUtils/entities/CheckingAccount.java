package br.com.jonathanferreira.fundamentals.javaUtils.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckingAccount that = (CheckingAccount) o;
        return Objects.equals(agency, that.agency) && Objects.equals(number, that.number);
    }


}
