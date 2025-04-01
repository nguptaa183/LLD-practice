package org.example.bankaccount;

//Encapsulation Practice
public class BankAccount {
    private final String accountNumber;
    private final String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=Math.max(balance,0);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println(amount + "$ deposited!");
        }
        else{
            System.out.println("Amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn $"+amount);
            } else {
                System.out.println("Insufficient Funds!");
            }
        } else {
            System.out.println("Amount must be positive!");
        }
    }

}
