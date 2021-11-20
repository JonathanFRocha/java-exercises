package br.com.jonathanferreira.fundamentals.javaUtils;

import br.com.jonathanferreira.fundamentals.javaUtils.entities.CheckingAccount;

import java.util.ArrayList;

public class TestArrayListEquals {
    public static void main(String[] args) {
        var list = new ArrayList<CheckingAccount>();

        CheckingAccount account1 = new CheckingAccount("222", "111");
        CheckingAccount account2 = new CheckingAccount("222", "222");
        CheckingAccount account3 = new CheckingAccount("222", "222");

        list.add(account1);
        list.add(account2);

        boolean exists = list.contains(account3);
        System.out.println(exists);
        for (CheckingAccount a : list) {
            System.out.println(a.getNumber());
        }
    }
}
