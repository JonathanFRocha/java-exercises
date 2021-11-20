package br.com.jonathanferreira.fundamentals.javaUtils;

import br.com.jonathanferreira.fundamentals.javaUtils.entities.AccountHolder;
import br.com.jonathanferreira.fundamentals.javaUtils.entities.CheckingAccount;

public class TestAccountHolder {
    public static void main(String[] args) {
        AccountHolder holder = new AccountHolder();

        CheckingAccount account1 = new CheckingAccount("222", "444");
        CheckingAccount account2 = new CheckingAccount("222", "222");

        holder.addAccount(account1);
        holder.addAccount(account2);

        var size = holder.getAccountsAmount();
        System.out.println(size);

        CheckingAccount ref = holder.getReference(0);
        System.out.println(ref.getNumber());
    }
}
