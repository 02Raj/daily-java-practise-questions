package oops.classbasics;

public class BankAccount {

    private String accountHolder;    // Data Hiding
    private double balance;

    BankAccount(String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }else{
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public static void main(String[] args) {

        BankAccount myaccount = new BankAccount("Divyansh",50);
        System.out.println("Current Balance: $" + myaccount.getBalance());
        myaccount.deposit(100);
        System.out.println("Current Balance: $" + myaccount.getBalance());
        myaccount.withdraw(100);
//        System.out.println("withdraw: $" + myaccount.getBalance());
    }
}
