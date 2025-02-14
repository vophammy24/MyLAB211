package mylab211.WEEK4;

import java.util.*;
import mylab211.WEEK4.Student;

public class StudentManagement {
    
    private List<Student> studentList = new ArrayList<>();
    
    public boolean checkStudent(Student st){
        for (Student s: studentList){
            if(s.getId().equals(st.getId())){
                return false;
            }
        }
        return true;
    }
    
    public boolean addStudent(Student st){
        if(checkStudent(st)){
            studentList.add(st);
            System.out.println("Add Student Complete");
            return true;
        } 
        System.out.println("Add Student Fail");
        return false;
    }
    
    public void showStudents(){
        for (Student st: studentList){
            System.out.println(st.toString());
        }
    }
    
    public List<Student> findStudent(String name){
        List<Student> result = new ArrayList<>();
            for (Student st : studentList){
                if(st.getName().toLowerCase().contains(name.toLowerCase()));
                result.add(st);
            }
        return result;
    }
    
    public boolean deleteStudent(String id){
        Iterator<Student> iterator = studentList.iterator();
            while(iterator.hasNext()) {
                if (iterator.next().getId().equals(id)){
                    iterator.remove();
                    System.out.println("Delete Student Complete");
                    return true;
                }
            }
        return false;
    }
    
    public boolean updateStudent(String id, String newName, String newSemester, String newCourse){
        for (Student st : studentList){
            if (st.getId().equals(id)){
                st.setName(newName);
                st.setSemester(newSemester);
                st.setCourseName(newCourse);
                System.out.println("Update Student Complete");
                return true;
            }
        }
        return false;
    }
    
    public void sortStudents(){
        Collections.sort(studentList, new Comparator<Student>(){
        
        @Override
        public int compare(Student st1, Student st2){
            return st1.getName().compareTo(st2.getName());
            }
        });
    }
    
    public void reportStudents(){
        Map<String, Integer> ds = new HashMap<>();
        for (Student st: studentList){
            String key = st.getId() + "|" + st.getName() + "|" + st.getCourseName();
            ds.put(key, ds.getOrDefault(key,0) + 1);
        }
        
        for (Map.Entry<String, Integer> infor: ds.entrySet()){
            System.out.println(infor.getKey() + "|" + infor.getValue());
        }
    }
    
    public void display(){
        Scanner sc = new Scanner(System.in);
        int studentCount = 0;
        
        while(true){
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/ Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice){
                case 1:
                    while(true){
                        System.out.print("Enter ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Semester: ");
                        String semester = sc.nextLine();
                        String courseName;
                        while (true) {
                            System.out.print("Enter Course Name (Java, .Net, C/C++): ");
                            courseName = sc.nextLine();
                            if (courseName.equals("Java") || courseName.equals(".Net") || courseName.equals("C/C++")) {
                                break;
                            }
                            System.out.println("Invalid course. Please enter Java, .Net, or C/C++.");
                        }
                        addStudent(new Student(id, name, semester, courseName));
                        studentCount++;
                        
                        if (studentCount >= 3) {
                            System.out.print("Do you want to continue adding students? (Y/N): ");
                            String continueChoice = sc.nextLine();
                            if (!continueChoice.equalsIgnoreCase("Y")) {
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter Name to Find: ");
                    String searchName = sc.nextLine();
                    List<Student> foundStudents = findStudent(searchName);
                    if (foundStudents.isEmpty()) {
                        System.out.println("No students found with name: " + searchName);
                    } else {
                        foundStudents.sort(Comparator.comparing(Student::getName));
                        System.out.println("Found students:");
                        for (Student student : foundStudents) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to Update/Delete: ");
                    String updateId = sc.nextLine();
                    System.out.print("Update (U) or Delete (D): ");
                    String action = sc.nextLine();
                    if (action.equalsIgnoreCase("U")){
                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new Semester: ");
                        String newSemester = sc.nextLine();
                        String newCourse;
                        while (true) {
                            System.out.print("Enter new Course (Java, .Net, C/C++): ");
                            newCourse = sc.nextLine();
                            if (newCourse.equals("Java") || newCourse.equals(".Net") || newCourse.equals("C/C++")) {
                                break;
                            }
                            System.out.println("Invalid course. Please enter Java, .Net, or C/C++.");
                        }
                        updateStudent(updateId, newName, newSemester, newCourse);
                    } else if (action.equalsIgnoreCase("D")){
                        deleteStudent(updateId);
                    }
                    break;
                case 4:
                    reportStudents();
                    break;
                case 5:
                    System.out.println("Exiting Program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }
}
