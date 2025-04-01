package org.example.bankaccount;

public class TestBank {
    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount("3746318","Nikhil",10000);
        System.out.println("Initial Balance = " + bankAccount.getBalance());
        bankAccount.deposit(3434);
        bankAccount.deposit(390843);
        bankAccount.withdraw(43940);
        bankAccount.withdraw(43940000);
        System.out.println("Final Balance = " + bankAccount.getBalance());
    }
}
