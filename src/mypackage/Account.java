package mypackage;

import java.text.NumberFormat;
import java.util.Scanner;

public class Account {
    int balance;
    int prevTransaction;
    String userName;
    String userId;
    
    Account(String cname, String cid) {
        userName = cname;
        userId = cid;
    }
     
    void deposit(int amount) {
        if(amount != 0) {
            balance += amount;
            prevTransaction = amount;
        }      
    }
    
    void withdraw(int amount) {
        if(balance != 0) {
            balance -= amount;
            prevTransaction = -amount;   
        }
        else {
            System.out.println("Insuficient funds");
        }
    }
    
    void getPrevTransaction() {
        String prevTransCurrency = NumberFormat.getCurrencyInstance().format(prevTransaction);
        if (prevTransaction > 0) {
            System.out.println("Deposited: " + prevTransCurrency);
        }
        else if (prevTransaction < 0) {
            System.out.println("Withdrawn: " + prevTransCurrency);
        }          
        else {
            System.out.println("You have not made any transactions.");
        }     
    }
    
    void calculateInterest(int years) {
        double interestRate = 0.06;
        double newBalance = (balance * interestRate * years) + balance;
        String newBalConvert = NumberFormat.getCurrencyInstance().format(newBalance);
        System.out.println();
        System.out.println("The current interest rate is " + (interestRate) + "%");
        System.out.println("In " + years + " years, your account balance will be " + newBalConvert);
    }
    
    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + userName + "!");
        System.out.println("Your user id is: " + userId + "\n");
        System.out.println("What would you like to do?\n");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdraw");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");
        
        do {
            System.out.println();
            System.out.print("Enter option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();
            
            switch(option) {
                case 'A':
                    String currConvert = NumberFormat.getCurrencyInstance().format(balance);
                    System.out.println("*************************************");
                    System.out.println("Account balance: " + currConvert);
                    System.out.println("*************************************");
                    break;
                case 'B':
                    System.out.print("Enter deposit ammount: ");
                    int depositInput = scanner.nextInt();
                    deposit(depositInput);
                    break;
                case 'C' :
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawInput = scanner.nextInt();
                    withdraw(withdrawInput);
                    break;
                case 'D':
                    System.out.println("*************************************");
                    getPrevTransaction();
                    System.out.println("*************************************");
                    break;
                case 'E':
                    System.out.print("enter how many years of interest: ");
                    int inputYears = scanner.nextInt();
                    calculateInterest(inputYears);
                    break;
                case 'F':
                    System.out.println("*************************************");
                    System.out.println("Thank you for banking with us today!");
                    System.out.println("*************************************");
                    System.out.println();
                    break;
                default:
                    System.out.println("System error. Invalid option.");
                    break;
            }  
        } while (option != 'F');       
    }
}
