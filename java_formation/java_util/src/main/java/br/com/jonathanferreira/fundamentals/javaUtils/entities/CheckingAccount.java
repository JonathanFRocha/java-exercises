package br.com.jonathanferreira.fundamentals.javaUtils.entities;

import java.util.Objects;

public class CheckingAccount extends Account {

    public CheckingAccount(String agency, String number) {
        super(agency, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckingAccount that = (CheckingAccount) o;
        return Objects.equals(getAgency(), that.getAgency()) && Objects.equals(getNumber(), that.getNumber());
    }
}
