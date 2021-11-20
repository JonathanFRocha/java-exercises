package br.com.jonathanferreira.fundamentals.javaUtils.entities;

import java.util.Objects;

public class SavingsAccount extends Account {

    public SavingsAccount(String agency, String number) {
        super(agency, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavingsAccount that = (SavingsAccount) o;

        return Objects.equals(getAgency(), that.getAgency()) && Objects.equals(getNumber(), that.getNumber());
    }


}
