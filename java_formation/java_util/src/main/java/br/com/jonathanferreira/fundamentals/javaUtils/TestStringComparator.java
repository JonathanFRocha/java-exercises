package br.com.jonathanferreira.fundamentals.javaUtils;

import br.com.jonathanferreira.fundamentals.javaUtils.entities.Account;
import br.com.jonathanferreira.fundamentals.javaUtils.entities.CheckingAccount;
import br.com.jonathanferreira.fundamentals.javaUtils.entities.Client;
import br.com.jonathanferreira.fundamentals.javaUtils.entities.SavingsAccount;

import java.util.ArrayList;
import java.util.Comparator;

public class TestStringComparator {
    public static void main(String[] args) {
        var cc1 = new CheckingAccount("22", "33");
        var clientCC1 = new Client("Zambi");
        cc1.deposit(333.0);
        cc1.setClient(clientCC1);

        var cc2 = new SavingsAccount("22", "44");
        var clientCC2 = new Client("Delta");
        cc2.deposit(444.0);
        cc2.setClient(clientCC2);

        var cc3 = new CheckingAccount("22", "11");
        var clientCC3 = new Client("Rodni");
        cc3.deposit(111.0);
        cc3.setClient(clientCC3);

        var cc4 = new SavingsAccount("22", "22");
        var clientCC4 = new Client("Abel");
        cc4.deposit(222.0);
        cc4.setClient(clientCC4);

        var list = new ArrayList<Account>();
        list.add(cc1);
        list.add(cc2);
        list.add(cc3);
        list.add(cc4);

        for(Account a: list){
            System.out.println(a.getNumber());
        }

        var comparator = new ClientComparator();
        list.sort(comparator);

        for(Account a: list){
            System.out.println(a);
        }
    }
}

class ClientComparator implements Comparator<Account> {

    @Override
    public int compare(Account c1, Account c2) {
        var nameC1 = c1.getClient().getName();
        var nameC2 = c2.getClient().getName();
        return nameC1.compareTo(nameC2);
    }
}
