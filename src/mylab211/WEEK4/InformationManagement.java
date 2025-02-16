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

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getYob() {
        return yob;
    }
        
    boolean isValid(){
        return id.matches("\\d{6}") && name.matches("[a-zA-Z ]+")
                && phone.matches("\\d{12}") && major.length() <= 30
                && yob < Calendar.getInstance().get(Calendar.YEAR);
    }
    
    void input(Scanner sc){
        
        while(!id.matches("\\d{6}")){
            System.out.print("ID: ");
            id = sc.nextLine();
            if (!id.matches("\\d{6}")) 
                System.out.println("Data input is invalid");
        }
        while(!name.matches("[a-zA-Z ]+")){
            System.out.print("Fullname: ");
            name = sc.nextLine();
            if (!name.matches("[a-zA-Z ]+")) 
                System.out.println("Data input is invalid");
        }
        while(!phone.matches("\\d{12}")){
            System.out.print("Phone number: ");
            phone = sc.nextLine();
            if (!phone.matches("\\d{12}")) 
                System.out.println("Data input is invalid");
        }
        while(yob <=0 || yob >= Calendar.getInstance().get(Calendar.YEAR)){
            System.out.print("Year of Birth: ");
            if (sc.hasNextInt()) {
                yob = sc.nextInt();
                sc.nextLine();               
            } else {
                System.out.println("Data input is invalid");
                sc.nextLine(); 
            }
        }
        while(major.length() > 30 || major.isEmpty()){
            System.out.print("Major: ");
            major = sc.nextLine();
            if (major.length() > 30) 
                System.out.println("Data input is invalid");
        }            
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + phone + " - " + yob + " - " + major;
    }
}

class Teacher extends Person{
    int yearInP;
    String contactType;
    double salary;

    public Teacher() {
        super();
        this.yearInP = 0;
        this.contactType = "";
        this.salary = -1;
    }

    public int getYearInP() {
        return yearInP;
    }

    void inputAll(Scanner sc) {
        super.input(sc);
        
        while (yearInP <= 0 || yearInP > (Calendar.getInstance().get(Calendar.YEAR) - yob)){
            System.out.print("Year of Profession: ");
            if (sc.hasNextInt()){
                yearInP = sc.nextInt();
                sc.nextLine();                
            } else {
                System.out.println("Data input is invalid");
                sc.nextLine();
            }

        }
        while (true){
            System.out.print("Contact Type is 'Long' or 'Short': ");
            contactType = sc.nextLine();
            if (contactType.equalsIgnoreCase("Long") || contactType.equalsIgnoreCase("Short"))
                break;
            System.out.println("Data input is invalid");
        }
        
        while (salary <= 0 ){
            System.out.print("Salary: ");
            if (sc.hasNextDouble()) {
                salary = sc.nextDouble();
                sc.nextLine();    
            } else {
                System.out.println("Data input is invalid");
                sc.nextLine();
            } 
        }   
    }

    @Override
    public String toString() {
        return super.toString() + " - " + yearInP + " - " + contactType + " - " + salary;
    }
}

class Student extends Person{
    int yearOA;
    double score;

    public Student() {
        super();
        this.yearOA = 0;
        this.score = 0;
    }

    public int getYearOA() {
        return yearOA;
    }
    
    void inputAll(Scanner sc){
        super.input(sc);
        while (yearOA < yob || yearOA > Calendar.getInstance().get(Calendar.YEAR)){
            System.out.print("Year of Admission: ");
            if (sc.hasNextInt()) {
                yearOA = sc.nextInt();
                sc.nextLine();               
            } else {
                System.out.println("Data input is invalid");
                sc.nextLine();
            }
        }
        while (score <= 0 || score >= 100 ){
            System.out.print("Entrance English Score: ");
            if (sc.hasNextDouble()) {
                score = sc.nextDouble();
                sc.nextLine();
            } else {
                System.out.println("Data input is invalid");
                sc.nextLine();
            }
        }
    }  

    @Override
    public String toString() {
        return super.toString() + " - " + yearOA + " - " + score;
    }
    
    
}

public class InformationManagement {
    private List<Person> personList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();

    
    boolean checkPerson(Person ps){
        for (Person person : personList){
            if(person.getId().equals(ps.getId())){
                return false;
            }
        } return true;
    }
    
    boolean addTeacher(Teacher tc){
        if (checkPerson(tc)){
            teacherList.add(tc);
            personList.add(tc);
            return true;
        } 
        return false;
    }
    
    boolean addStudent(Student st){
        if (checkPerson(st)){
            studentList.add(st);
            personList.add(st);
            return true;
        } 
        System.out.println("Add Student Fail");
        return false;
    }
    
    void showPerson(){
        if (personList.isEmpty()){
            System.out.println("No data");
            return;
        } else {
            System.out.println("# - ID - Fullname - Phone number - Year of birth - Major");
            int index = 1;
            for (Person ps : personList) {
                System.out.println(index++ + " - " + ps.getId()
                                    + " - " + ps.getName()
                                    + " - " + ps.phone
                                    + " - " + ps.getYob()
                                    + " - " + ps.major);
            }
        }    
    }
    void showTeacher(){
        if (teacherList.isEmpty()){
            System.out.println("No data");
            return;
        } else {
            System.out.println("# - ID - Fullname - Phone number - Year of birth"
                    + " - Major - Year in the profession - Contract type - Salary coefficient");
            int index = 1;
            for (Teacher tc : teacherList) {
                System.out.println(index + " - " + tc);
                index++;
            }
        }    
    }
    
    void showStudent(){
        if (studentList.isEmpty()){
            System.out.println("No data");
            return;
        } else {
            
            System.out.println("# - ID - Fullname - Phone number - Year of birth"
                    + " - Major - Year of admission - Entrance English score");
            int index = 1;
            for (Student st : studentList) {
                System.out.println(index + " - " + st);
                index++;
            }
        }    
    }
    
    void sortTeacher(){
        if (teacherList.isEmpty()){
            System.out.println("No data");
            return;
        } else {
            for (int i = 0; i < teacherList.size() - 1; i++){
                for (int j = 0; j < teacherList.size() - i - 1; j++){
                    if(teacherList.get(j).getYearInP() < teacherList.get(j + 1).getYearInP()){
                        Teacher temp = teacherList.get(j);
                        teacherList.set(j, teacherList.get(j + 1));
                        teacherList.set(j + 1, temp);
                    }
                }
            }
        }
    }
    
    void sortStudent(){
        if (studentList.isEmpty()){
            System.out.println("No data");
            return;
        } else {
            for (int i = 0; i < studentList.size() - 1; i++){
                for (int j = 0; j < studentList.size() - i - 1; j++){
                    if(studentList.get(j).getYearOA() < studentList.get(j + 1).getYearOA()){
                        Student temp = studentList.get(j);
                        studentList.set(j, studentList.get(j + 1));
                        studentList.set(j + 1, temp);
                    }
                }
            }
        }
    }
    
    void searchPerson(Scanner sc){
        System.out.print("Name: ");
        String name = sc.nextLine();

        for (Person ps : personList) {
            if (ps.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Result:");
                System.out.println("# - ID - Fullname - Phone number - Year of birth - Major");
                int index = 1;
                System.out.println(index++ + " - " + ps.getId()
                                    + " - " + ps.getName()
                                    + " - " + ps.phone
                                    + " - " + ps.getYob()
                                    + " - " + ps.major);
                index++;
            }
            else {
                System.out.println("Result: not found");
            }
        }
    }
    
    public static class Menu{
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
                                tc.inputAll(sc);
                                if (im.addTeacher(tc));
                            }
                            else if (teacherChoice == 2) {
                                im.sortTeacher();
                                im.showTeacher();                    
                                } else if (teacherChoice == 3) break;
                                else System.out.println("Invalid choice. Try again!");
                        }
                        break;

                    case 2:
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
                                st.inputAll(sc);
                                if (im.addStudent(st));
                            }
                            else if (studentChoice == 2) {
                                im.sortStudent();
                                im.showStudent();
                                } 
                                else if (studentChoice == 3) break;
                                else System.out.println("Invalid choice. Try again!");
                        }
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
    }
}