package mylab211.WEEK4;

import java.util.*;

class Person{
    String id, name, phone, major;
    int yob;

    public Person() {
        this.id = "";
        this.name = "";
        this.phone = "";
        this.major = "";
        this.yob = 0;
    }
    
    boolean isValid(){
        return id.matches("\\d{6}") && name.matches("[a-zA-Z ]+")
                && phone.matches("\\d{12}") && major.length() <= 30
                && yob < Calendar.getInstance().get(Calendar.YEAR);
    }
    
    void input(){
        Scanner sc = new Scanner(System.in);
        
        while(!id.matches("\\d{6}")){
            System.out.println("ID: ");
            id = sc.nextLine();
        }
        while(!name.matches("[a-zA-Z ]+")){
            System.out.println("Fullname: ");
            name = sc.nextLine();
        }
        while(!phone.matches("\\d{12}")){
            System.out.println("Phone number: ");
            phone = sc.nextLine();
        }
        while(yob >= Calendar.getInstance().get(Calendar.YEAR)){
            System.out.println("Year of Birth: ");
            yob = sc.nextInt();
            sc.nextLine();
        }
        while(major.length() > 30){
            System.out.println("Major: ");
            major = sc.nextLine();
        }            
    }

    @Override
    public String toString() {
        return " - " + id + " - " + name + " - " + phone + " - " + major + " - " + yob;
    }
}

class Teacher extends Person{
    int yearOP;
    String contactType;
    double salary;

    
    
    
}

public class InformationManagement {
    
}
