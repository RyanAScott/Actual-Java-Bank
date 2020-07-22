package bankingapplication;
import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {
        
        //bank account constructor
        BankAccount obj1 = new BankAccount("Gold", "GD0003");
        obj1.showMenu();
        
    }// main
    
}// class (main)

class BankAccount{
    // variables
    int balance;// money in account
    int previousTransaction;
    String customerName;
    String customerId;
    
    // constuctor
    BankAccount(String cname, String cid){
    
        customerName = cname;
        customerId = cid;
        
    }// constructor
    
    // deposit method
    void deposit(int amount){
    
        if(amount != 0){
        
            // deposit amount is added to balance
            balance = balance + amount;
            // record amount deposited in (Will likely be displayed)
            previousTransaction = amount;
            
        }// if
        
    }// deposit
    
    // withdraw method
    void withdraw(int amount){
    
        if(amount != 0){
        
            // withdraw amount is substacted from balance
            balance = balance - amount;
            // record the transaction with a minus sign in front to signal money taken out
            previousTransaction = -amount;
            
        }// if
        
    }// withdraw
    
    // get previous transaction method
    void getPreviousTransaction(){
    
        if(previousTransaction > 0){
            
            // Displays deposited amount
            System.out.println("Deposited: " + previousTransaction);
            
        }// if 
        else if(previousTransaction < 0){
        
            // displays withdrawn amount
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
            // Math.abs removes negative sign
            
        }// else if   
        else{
        
            System.out.println("No transaction occured");
            
        }// else 
        
    }// getPreviousTransaction
    
    void Menu(){
    
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");
        
    }// menu
    
    // show menu method
    void showMenu(){
    
        char option = '\0';// \0 is a placeholder value
        Scanner scanner = new Scanner(System.in);
        
        // welcome message
        System.out.println("Welcome "+customerName);
        System.out.println("Your ID is "+customerId);
        System.out.println("\n");
        
        // options          
        Menu();
        
        do{
        
            System.out.println("==================================================");
            System.out.println("Enter an option");
            System.out.println("==================================================");
            option = scanner.next().charAt(0);// char variable scanner
            System.out.println("\n");
            
            //switch statement for scanner variable
            switch(option){
            
                case 'A':
                case 'a':
                    System.out.println("-------------------------------------");
                    System.out.println("Balance = "+balance);
                    System.out.println("-------------------------------------");
                    System.out.println("\n");
                    Menu();
                    break;
                
                case 'B':
                case 'b':
                    System.out.println("-------------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("-------------------------------------");
                    int amount = scanner.nextInt();// scanner for deposit amount
                    deposit(amount);// deposit method
                    System.out.println("\n");
                    Menu();
                    break;
                    
                case 'C':
                case 'c':
                    System.out.println("-------------------------------------");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("-------------------------------------");
                    int amount2 = scanner.nextInt();// scanner for the withdraw amount
                    withdraw(amount2);// withdraw method
                    System.out.println("\n");
                    Menu();
                    break;
                    
                case 'D':
                case 'd':
                    System.out.println("-------------------------------------");
                    getPreviousTransaction();//getPreviousTransaction method
                    System.out.println("-------------------------------------");
                    System.out.println("\n");
                    Menu();
                    break;
                    
                case 'E':
                    System.out.println("*************************************");
                    break;
                    
                default:
                    System.out.println("Invalid Option! Please enter again");
                    Menu();
                    break;
                
            }// switch
            
        }while(option != 'E');// do while loop
        
        System.out.println("Thank You for using our services");
        
    }// showMenu

}// class BankAccount
