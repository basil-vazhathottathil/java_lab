package basil_vazhathottathil;
import java.util.Scanner;

public class EmployeeDetails {
    public static void main(String[] args) {
        Officer officer = new Officer();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Manager manager = new Manager();
        System.out.println("Enter the officer details:");
        employee1.getDetails();
        officer.getSpecialization();
        System.out.println("Specialization: " + officer.specialization);
        employee1.printDetails();
        employee1.printSalary();
        System.out.println("\n\n");
        System.out.println("Enter the manager details:");
        employee2.getDetails();
        manager.getDepartment();
        System.out.println("Department: " + manager.department);
        employee2.printDetails();
        employee2.printSalary();
    }
}

class Employee {
    String name, address, phoneNumber;
    int age;
    long salary;
    Scanner scan = new Scanner(System.in);

    public void getDetails() {
        System.out.println("Enter the name:");
        name = scan.next();
        System.out.println("Enter the address:");
        scan.nextLine();
        address = scan.nextLine();
        System.out.println("Enter the phone number:");
        phoneNumber = scan.nextLine();
        System.out.println("Enter the age:");
        age = scan.nextInt();
        System.out.println("Enter the salary:");
        salary = scan.nextLong();
    }

    public void printSalary() {
        System.out.println("Salary: " + salary);
    }
    
    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Age: " + age);
    }
}

class Manager extends Employee {
    String department;

    public void getDepartment() {
        System.out.println("Enter the department: ");
        department = scan.next();
    }
}

class Officer extends Employee {
    String specialization;

    public void getSpecialization() {
        System.out.println("Enter the specialization: ");
        specialization = scan.next();
    }
}
