package mylab211.WEEK6;

public class Salary {
    private double salary;
    private String status;
    private String date;

    public Salary(double salary, String status, String date) {
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    public double getSalary() {
        return salary;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }
}
