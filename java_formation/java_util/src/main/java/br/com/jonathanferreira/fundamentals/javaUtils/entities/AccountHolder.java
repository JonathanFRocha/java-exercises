package br.com.jonathanferreira.fundamentals.javaUtils.entities;

public class AccountHolder {
    private CheckingAccount[] references;


    public AccountHolder() {
        references = new CheckingAccount[10];
    }

    public CheckingAccount[] getReferences() {
        return references;
    }

    public void setReferences(CheckingAccount[] references) {
        this.references = references;
    }
}
