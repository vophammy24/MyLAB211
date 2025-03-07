package mylab211.WEEK6;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String code;
    private String name;
    private int age;
    private String location;
    private List<Salary> salaryHistory;

    public Worker(String code, String name, int age, String location, double salary) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.location = location;
        this.salaryHistory = new ArrayList<>();
        this.salaryHistory.add(new Salary(salary, "Begin", ""));
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }
    

    public List<Salary> getSalaryHistory() {
        return salaryHistory;
    }
    
    public void addSalary(Salary s){
        salaryHistory.add(s);
    }
    
}
