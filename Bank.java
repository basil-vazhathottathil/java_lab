package basil_vazhathottathil;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        int choice;
        InvalidAmountException invalidamount = new InvalidAmountException("invalid amount , less than 0");
        InsufficientFundsException nofund = new InsufficientFundsException("insufficient balance");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of customers");
        int noOfCustomers = sc.nextInt();
        Customer[] customers = new Customer[noOfCustomers];

        for (int i = 0; i < noOfCustomers; i++) {
            customers[i] = new Customer();
            customers[i].getDetails(sc);
        }

        do {
            System.out.print("\n\n\n");
            System.out.print("MENU\n" + "1. Display all account details\n"
                    + "2. Search by account number\n" + "3. Deposit the amount\n"
                    + "4. Withdraw the amount\n" + "5. Exit\n");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    for (int i = 0; i < noOfCustomers; i++) {
                        customers[i].printDetails();
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the account number");
                    int search = sc.nextInt();
                    boolean accountFound = false;

                    for (int i = 0; i < noOfCustomers; i++) {
                        if (customers[i].accountNumber == search) {
                            customers[i].printDetails();
                            accountFound = true;
                            break;
                        }
                    }

                    if (accountFound==false) {
                        System.out.println("Account not found");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the account number");
                    int query = sc.nextInt();
                    for (int i = 0; i < noOfCustomers; i++) {
                        if (customers[i].accountNumber == query) {
                            try {
                                System.out.println("Enter the amount to deposit");
                                int deposit = sc.nextInt();
                                if (deposit < 0) {
                                    throw invalidamount;
                                }
                                customers[i].balance += deposit;
                            } catch (InvalidAmountException e) {
                                System.out.println(e.getMessage());
                            }
                        } 
                        else {
                            System.out.println("Account not found");
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter the account number");
                    int query = sc.nextInt();
                    for (int i = 0; i < noOfCustomers; i++) {
                        if (customers[i].accountNumber == query) {
                            try {
                                System.out.println("Enter the amount to withdraw");
                                int withdraw = sc.nextInt();
                                if (withdraw < 0) {
                                    throw invalidamount;
                                } else if (withdraw > customers[i].balance) {
                                    throw nofund;
                                } else {
                                    customers[i].balance -= withdraw;
                                }
                            } catch (InvalidAmountException e) {
                                System.out.println(e.getMessage());
                            } catch (InsufficientFundsException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("Account not found");
                            break;
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        } while (choice != 5);
    }
}

class Customer {
    Scanner sc = new Scanner(System.in);
    String accountType, customerName;
    int balance, accountNumber;

    public void getDetails(Scanner sc) {
        System.out.println("Enter the Customer Name");
        sc.nextLine();
        customerName = sc.nextLine();
        System.out.println("Enter the account Number");
        accountNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the account Type");
        accountType = sc.nextLine();
        System.out.println("Enter the balance in the account");
        balance = sc.nextInt();
    }

    public void printDetails() {
        System.out.println("________________________________");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account type : " + accountType);
        System.out.println("Balance : " + balance);
        System.out.println("________________________________");
    }

}

class InvalidAmountException extends Exception {
    InvalidAmountException(String str) {
        super(str);
    }
}

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String str) {
        super(str);
    }
}
