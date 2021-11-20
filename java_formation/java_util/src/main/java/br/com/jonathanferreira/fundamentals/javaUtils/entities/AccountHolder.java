package br.com.jonathanferreira.fundamentals.javaUtils.entities;

public class AccountHolder {
    private CheckingAccount[] references;
    private int posicaoLivre;

    public AccountHolder() {

        references = new CheckingAccount[10];
        posicaoLivre = 0;
    }


    public void addAccount(CheckingAccount acc) {
        references[posicaoLivre] = acc;
        posicaoLivre++;
    }

    public int getAccountsAmount() {
        return posicaoLivre;
    }

    public CheckingAccount getReference(int i) {
        return references[i];
    }
}
