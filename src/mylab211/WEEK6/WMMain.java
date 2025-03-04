package mylab211.WEEK6;

import java.util.Scanner;

public class WMMain {
    public static void main(String[] args) {
        WorkerManagement wm = new WorkerManagement();
        Scanner sc = new Scanner(System.in);
        
        while (true){
            System.out.println("\nWorker Management System");
            System.out.println("1. Add Worker");
            System.out.println("2. Increase Salary");
            System.out.println("3. Decrease Salary");
            System.out.println("4. Show Salary Adjustments");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine();
                switch(option){
                    case 1: 
                        System.out.println("Add Worker");
                        System.out.print("Enter Code: ");
                        String code = sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter Location: ");
                        String location = sc.nextLine();
                        wm.addWorker(new Worker(code, name, age, location, salary));
                        break;
                    case 2:
                        System.out.println("Increase Salary");
                        System.out.print("Enter Code: ");
                        code = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        salary = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Enter Date: ");
                        String date = sc.nextLine();
                        wm.changeUpSalary(code, salary, date);
                        break;
                    case 3:
                        System.out.println("3. Decrease Salary");
                        System.out.print("Enter Code: ");
                        code = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        salary = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter Date: ");
                        date = sc.nextLine();
                        wm.changeDownSalary(code, salary, date);
                    case 4:
                        wm.getInformationSalary();
                        break;
                    case 5:
                        return;
                    default:    
                        System.out.println("Invalid option. Please try again.");
                }
        }  
    }
}
