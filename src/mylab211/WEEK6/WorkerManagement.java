package mylab211.WEEK6;

import java.util.ArrayList;
import java.util.List;

public class WorkerManagement {
    List<Worker> workers = new ArrayList<>();

    public boolean addWorker(Worker worker){
        for(Worker w: workers){
            if(w.getCode().equals(worker.getCode())){
                System.out.println("ID already exists.");
                return false;
            }
        }
        workers.add(worker);
        return true;
    }

    public void changeUpSalary(String code, double money, String date){
        for(Worker worker: workers){
            if(worker.getCode().equals(code)){
                List<Salary> history = worker.getSalaryHistory();
                double lastSalary = history.isEmpty() ? 0 : history.get(history.size() - 1).getSalary();
                if(money > lastSalary)
                    worker.addSalary(new Salary(money, "UP", date));
            }
        }
    }

    public void changeDownSalary(String code, double money, String date){
        for(Worker worker: workers){
            if(worker.getCode().equals(code)){
                List<Salary> history = worker.getSalaryHistory();
                double lastSalary = history.get(history.size() - 1).getSalary();
                if(money < lastSalary)
                    worker.addSalary(new Salary(money, "DOWN", date));
            }
        }
    }

    public void getInformationSalary(){
        System.out.printf("%-10s %-15s %-5s %-10s %-10s %-12s%n", 
                      "Code", "Name", "Age", "Salary", "Status", "Date");
        for(Worker worker: workers){
            for(Salary sl: worker.getSalaryHistory())
                System.out.printf("%-10s %-15s %-5d %-10.2f %-10s %-12s%n",
                        worker.getCode(), worker.getName(), worker.getAge(),
                        sl.getSalary(), sl.getStatus(), sl.getDate());
        }
    }
}
