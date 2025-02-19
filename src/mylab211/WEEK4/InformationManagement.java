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
    
    void InputAll(String ID, String fname, String p, int yearOB, String m){
        id = ID;
        name = fname;
        phone = p;
        yob = yearOB;
        major = m;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + phone + " - " + yob + " - " + major;
    }
}

class Teacher extends Person{
    int yearInP;
    String contractType;
    double salary;

    public Teacher() {
        super();
        yearInP = 0;
        contractType = "";
        salary = -1;
    }

    public int getYearInP() {
        return yearInP;
    }

    void inputAll(int yInP, String cType, double slry) {
        super.InputAll(id, name, phone, yob, major);
        
        yearInP = yInP;
        contractType = cType;
        salary = slry;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + yearInP + " - " + contractType + " - " + salary;
    }
}

class Student extends Person{
    int yearOA;
    double score;

    public Student() {
        super();
        yearOA = 0;
        score = 0;
    }

    public int getYearOA() {
        return yearOA;
    }
    
    void inputAll(int yOA, double s){
        super.InputAll(id, name, phone, yob, major);

        yearOA = yOA;
        score = s;
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
                System.out.println("Add Person Fail");
                return false;
            }
        } 
        return true;
    }
    
    boolean addTeacher(Teacher tc){
        if (checkPerson(tc)){
            teacherList.add(tc);
            personList.add(tc);
            return true;
        }
        System.out.println("Add Teacher Fail");
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
}