package br.com.jonathanferreira.fundamentals.javaUtils;

import br.com.jonathanferreira.fundamentals.javaUtils.entities.Account;
import br.com.jonathanferreira.fundamentals.javaUtils.entities.CheckingAccount;
import br.com.jonathanferreira.fundamentals.javaUtils.entities.SavingsAccount;

import java.util.ArrayList;
import java.util.Comparator;

public class TestAnonObject {
    public static void main(String[] args) {
        var cc1 = new CheckingAccount("22", "33");
        cc1.deposit(333.0);

        var cc2 = new SavingsAccount("22", "44");
        cc2.deposit(444.0);

        var cc3 = new CheckingAccount("22", "11");
        cc3.deposit(111.0);

        var cc4 = new SavingsAccount("22", "22");
        cc4.deposit(222.0);

        var list = new ArrayList<Account>();
        list.add(cc1);
        list.add(cc2);
        list.add(cc3);
        list.add(cc4);

        for (Account a : list) {
            System.out.println(a.getNumber());
        }

        list.sort(new Comparator<Account>() {

                      @Override
                      public int compare(Account c1, Account c2) {
                          var c1Number = Integer.parseInt(c1.getNumber());
                          var c2Number = Integer.parseInt(c2.getNumber());
                          return Integer.compare(c1Number, c2Number);
                      }
                  }
        );


        for (Account a : list) {
            System.out.println(a.getNumber());
        }
    }
}


