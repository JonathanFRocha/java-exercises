package br.com.jonathanferreira.fundamentals.javaUtils;

import br.com.jonathanferreira.fundamentals.javaUtils.entities.CheckingAccount;

public class TestArrayReferences {

    public static void main(String[] args) {
        CheckingAccount[] accounts = new CheckingAccount[5];

        var checkingAccount1 = new CheckingAccount("111", "111");
        accounts[0]= checkingAccount1;
    }
}
