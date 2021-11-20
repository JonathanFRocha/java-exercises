package br.com.jonathanferreira.fundamentals.javaUtils;

import br.com.jonathanferreira.fundamentals.javaUtils.entities.CheckingAccount;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        var list = new ArrayList<CheckingAccount>();

        CheckingAccount account1 = new CheckingAccount("222", "111");
        CheckingAccount account2 = new CheckingAccount("222", "222");

        list.add(account1);
        list.add(account2);

        System.out.println(list.size());

        CheckingAccount acc = list.get(0);

        System.out.println(acc.getNumber());

        list.remove(0);

        System.out.println(list.size());

        CheckingAccount account3 = new CheckingAccount("222", "333");
        CheckingAccount account4 = new CheckingAccount("222", "444");

        list.add(account3);
        list.add(account4);

        for (CheckingAccount a : list) {
            System.out.println(a.getNumber());
        }
    }
}
