package br.com.jonathanferreira.fundamentals.javaUtils.entities;

public abstract class Account implements Comparable<Account> {
    private double balance;
    private String agency;
    private String number;
    private Client client;

    public Account(String agency, String number) {
        this.balance = 0;
        this.agency = agency;
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double value){
        balance += value;
        return balance;
    }

    public double withdraw(double value){
        balance -= value;
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", agency='" + agency + '\'' +
                ", number='" + number + '\'' +
                ", client=" + client +
                '}';
    }

    @Override
    public int compareTo(Account account) {
        var number1 = Integer.parseInt(number);
        var number2 = Integer.parseInt(account.number);
        return Integer.compare(number1, number2);
    }
}
