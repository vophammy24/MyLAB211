package mylab211.WEEK4;

import java.util.Calendar;
import java.util.Scanner;

public class IMMenu {
    public static void menu(Scanner sc){

        InformationManagement im = new InformationManagement();

        while(true){
            System.out.println("*** Information Management ***");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("3. Person");
            System.out.println("4. Exit");
            System.out.print("You choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    teacherValues(sc, im);
                    break;

                case 2:
                    studentValues(sc, im);
                    break;

                case 3:
                    while (true){
                        System.out.println("\n*** Person Management ***");
                        System.out.println("1. Search");
                        System.out.println("2. Print all");
                        System.out.println("3. Exit");
                        System.out.print("You choose: ");
                        int studentChoice = sc.nextInt();
                        sc.nextLine();

                        if (studentChoice == 1){
                            im.searchPerson(sc);
                        }
                        else if (studentChoice == 2) {
                            im.showPerson();
                            } 
                            else if (studentChoice == 3) break;
                            else System.out.println("Invalid choice. Try again!");
                    }
                    break;
                case 4: 
                    System.out.println("BYE AND SEE YOU NEXT TIME ");
                    return;

                default:
                        System.out.println("Invalid option");
            }
        }
    }
    
    public static void teacherValues(Scanner sc, InformationManagement im){
        while (true){
            System.out.println("\n*** Teacher Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int teacherChoice = sc.nextInt();
            sc.nextLine();

            if (teacherChoice == 1){
                Teacher tc = new Teacher();
                
                while(!tc.id.matches("\\d{6}")){
                    System.out.print("ID: ");
                    tc.id = sc.nextLine();
                    if (!tc.id.matches("\\d{6}")) 
                        System.out.println("Data input is invalid");
                }
                while(!tc.name.matches("[a-zA-Z ]+")){
                    System.out.print("Fullname: ");
                    tc.name = sc.nextLine();
                    if (!tc.name.matches("[a-zA-Z ]+")) 
                        System.out.println("Data input is invalid");
                }
                while(!tc.phone.matches("\\d{12}")){
                    System.out.print("Phone number: ");
                    tc.phone = sc.nextLine();
                    if (!tc.phone.matches("\\d{12}")) 
                        System.out.println("Data input is invalid");
                }
                while(tc.yob <=0 || tc.yob >= Calendar.getInstance().get(Calendar.YEAR)){
                    System.out.print("Year of birth: ");
                    if (sc.hasNextInt()) {
                        tc.yob = sc.nextInt();
                        sc.nextLine();               
                    } else {
                        System.out.println("Data input is invalid");
                        sc.nextLine(); 
                    }
                }
                while(tc.major.length() > 30 || tc.major.isEmpty()){
                    System.out.print("Major: ");
                    tc.major = sc.nextLine();
                    if (tc.major.length() > 30) 
                        System.out.println("Data input is invalid");
                }    
                while (tc.yearInP <= 0 || tc.yearInP > (Calendar.getInstance().get(Calendar.YEAR) - tc.yob)){
                    System.out.print("Year in the profession: ");
                    if (sc.hasNextInt()){
                        tc.yearInP = sc.nextInt();
                        sc.nextLine();                
                    } else {
                        System.out.println("Data input is invalid");
                        sc.nextLine();
                    }

                }
                while (true){
                    System.out.print("Contact type: ");
                    tc.contractType = sc.nextLine();
                    if (tc.contractType.equalsIgnoreCase("Long") || tc.contractType.equalsIgnoreCase("Short"))
                        break;
                    System.out.println("Data input is invalid");
                }

                while (tc.salary <= 0 ){
                    System.out.print("Salary coefficient: ");
                    if (sc.hasNextDouble()) {
                        tc.salary = sc.nextDouble();
                        sc.nextLine();    
                    } else {
                        System.out.println("Data input is invalid");
                        sc.nextLine();
                    } 
                }
                tc.inputAll(tc.yearInP, tc.contractType, tc.salary);
                im.addTeacher(tc);
            } else if (teacherChoice == 2) {
                im.sortTeacher();
                im.showTeacher();                    
                } else if (teacherChoice == 3) break;
                else System.out.println("Invalid choice. Try again!");
        }
    }
    
    public static void studentValues(Scanner sc, InformationManagement im){
        while (true){
            System.out.println("\n*** Student Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int studentChoice = sc.nextInt();
            sc.nextLine();

            if (studentChoice == 1){
                Student st = new Student();
                
                while(!st.id.matches("\\d{6}")){
                    System.out.print("ID: ");
                    st.id = sc.nextLine();
                    if (!st.id.matches("\\d{6}")) 
                        System.out.println("Data input is invalid");
                }
                while(!st.name.matches("[a-zA-Z ]+")){
                    System.out.print("Fullname: ");
                    st.name = sc.nextLine();
                    if (!st.name.matches("[a-zA-Z ]+")) 
                        System.out.println("Data input is invalid");
                }
                while(!st.phone.matches("\\d{12}")){
                    System.out.print("Phone number: ");
                    st.phone = sc.nextLine();
                    if (!st.phone.matches("\\d{12}")) 
                        System.out.println("Data input is invalid");
                }
                while(st.yob <=0 || st.yob >= Calendar.getInstance().get(Calendar.YEAR)){
                    System.out.print("Year of birth: ");
                    if (sc.hasNextInt()) {
                        st.yob = sc.nextInt();
                        sc.nextLine();               
                    } else {
                        System.out.println("Data input is invalid");
                        sc.nextLine(); 
                    }
                }
                while(st.major.length() > 30 || st.major.isEmpty()){
                    System.out.print("Major: ");
                    st.major = sc.nextLine();
                    if (st.major.length() > 30) 
                        System.out.println("Data input is invalid");
                }
                while (st.yearOA < st.yob || st.yearOA > Calendar.getInstance().get(Calendar.YEAR)){
                    System.out.print("Year of admission: ");
                    if (sc.hasNextInt()) {
                        st.yearOA = sc.nextInt();
                        sc.nextLine();               
                    } else {
                        System.out.println("Data input is invalid");
                        sc.nextLine();
                    }
                }
                while (st.score <= 0 || st.score >= 100 ){
                    System.out.print("Entrance English score: ");
                    if (sc.hasNextDouble()) {
                        st.score = sc.nextDouble();
                        sc.nextLine();
                    } else {
                        System.out.println("Data input is invalid");
                        sc.nextLine();
                    }
                }
                
                st.inputAll(st.yearOA, st.score);
                im.addStudent(st);
            }
            else if (studentChoice == 2) {
                im.sortStudent();
                im.showStudent();
                } 
                else if (studentChoice == 3) break;
                else System.out.println("Invalid choice. Try again!");
        }
    }
}
