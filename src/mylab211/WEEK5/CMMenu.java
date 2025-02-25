package mylab211.WEEK5;

import java.time.LocalDate;
import java.util.Scanner;

public class CMMenu {
    public static void menu(Scanner sc){
        CourseManagement cm = new CourseManagement();
        
        while(true){
            System.out.println("\n*** Course Management ***");
            System.out.println("1. Add online course/ offline course");
            System.out.println("2. Update course");
            System.out.println("3. Delete course");
            System.out.println("4. Print all/ online course/ offline course");
            System.out.println("5. Search information base on course name");
            System.out.println("6. Exit");
            System.out.print("You choose: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice){
                case 1:
                    System.out.println("*** Add new course ***");
                    addCourse(sc, cm);
                    break;
                case 2:
                    System.out.println("*** Update course ***");
                    updateCourse(sc, cm);
                    break;
                case 3:
                    System.out.println("*** Delete course ***");
                    deleteCourse(sc, cm);
                    break;
                case 4:
                    System.out.println("*** Print course ***");
                    showCourse(sc, cm);
                    break;
                case 5:    
                    System.out.println("*** Searching ***");
                    searchCourse(sc, cm);
                    break;
                case 6:
                    System.out.println("BYE AND SEE YOU NEXT TIME ");
                    return;
                default: 
                        System.out.println("Invalid option");
            }
        }
    }
    
    public static void addCourse(Scanner sc, CourseManagement cm){
        while (true){
            OnlineCourse onc = new OnlineCourse();
            OfflineCourse ofc = new OfflineCourse();
            System.out.print("Online (O) or Offline (F): ");
            String action = sc.nextLine();
            if (action.equalsIgnoreCase("O")){
                System.out.print("Course ID: ");
                String id = sc.nextLine();
                
                System.out.print("Course Name: ");
                String name = sc.nextLine();
                
                int credits;
                while (true) {
                    System.out.print("Credits: ");
                    credits = Integer.parseInt(sc.nextLine());
                    if (credits > 0 ) break; 
                    else System.out.println("Data input is invalid");
                }

                System.out.print("Platform: ");
                String platform = sc.nextLine();
                
                System.out.print("Instructors: ");
                String instructors = sc.nextLine();
                
                System.out.print("Note: ");
                String note = sc.nextLine();
                
                onc.inputAll(id, name, credits, platform, instructors, note);
                cm.addOnlineCourse(onc);
                break;
                
            } else if (action.equalsIgnoreCase("F")){
                System.out.print("Course ID: ");
                String id = sc.nextLine();
                
                System.out.print("Course Name: ");
                String name = sc.nextLine();
                
                int credits;
                while (true) {
                    System.out.print("Credits: ");
                    credits = Integer.parseInt(sc.nextLine());
                    if (credits > 0 ) break; 
                    else System.out.println("Data input is invalid");
                }
                
                LocalDate begin = null, end = null;
                    System.out.print("Begin Date: ");
                    begin = LocalDate.parse(sc.nextLine());
                while(true){
                    System.out.print("End Date: ");
                    end = LocalDate.parse(sc.nextLine());
                    if(begin.isAfter(end)){
                        System.out.println("Data input is invalid, end must be after begin");
                    } else break;
                }

                System.out.print("Campus: ");
                String campus = sc.nextLine();
                ofc.inputAll(id, name, credits, begin.toString(), end.toString(), campus);
                cm.addOfflineCourse(ofc);
                break; 
                
            } else 
                System.out.println("Data input is invalid");
            
        }
    }
    
    public static void updateCourse(Scanner sc, CourseManagement cm){
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine();

            Course course = cm.findCourse(id);
            if (course == null) {
                System.out.println("No data found, do you want to find again? (Y/N): ");
                String action = sc.nextLine().trim();
                while (true) {
                    if (action.equalsIgnoreCase("Y")) {
                        updateCourse(sc, cm);
                } else if (action.equalsIgnoreCase("N")) return;
                    else 
                    System.out.println("Invalid input! Please enter Y (Yes) or N (No): ");
                }
            } else {
                System.out.println("\n*** Search results ***");
                System.out.println(course);
                System.out.println("*** Updating ***");
                System.out.println("Note: Enter empty if you don't want to change it.");

                System.out.print("Course name: ");
                String newName = sc.nextLine().trim();
                if (newName.isEmpty()) newName = null;

                System.out.print("Credits: ");
                String newCredits = sc.nextLine().trim();
                Integer newCredit;
                if (newCredits.isEmpty()){
                    newCredit = null;
                } else newCredit = Integer.parseInt(newCredits);

                if (course instanceof OnlineCourse) {

                    System.out.print("Platform: ");
                    String newPlatform = sc.nextLine().trim();
                    if (newPlatform.isEmpty()) newPlatform = null;

                    System.out.print("Instructors: ");
                    String newInstructors = sc.nextLine().trim();
                    if (newInstructors.isEmpty()) newInstructors = null;

                    System.out.print("Note: ");
                    String newNote = sc.nextLine().trim();
                    if (newNote.isEmpty()) newNote = null;

                    cm.updateOnlineCourse(id, newName, newCredit, newPlatform, newInstructors, newNote);
                    return;

                } else if (course instanceof OfflineCourse) {

                    System.out.print("Begin Date: ");
                    String newBegin = sc.nextLine().trim();
                    if (newBegin.isEmpty()) newBegin = null;

                    System.out.print("End Date: ");
                    String newEnd = sc.nextLine().trim();
                    if (newEnd.isEmpty()) newEnd = null;

                    System.out.print("Campus: ");
                    String newCampus = sc.nextLine().trim();
                    if (newCampus.isEmpty()) newCampus = null;

                    cm.updateOfflineCourse(id, newName, newCredit, newBegin, newEnd, newCampus);
                    return;
                }
            }
            System.out.println("Updated successfully.");
            return;
        }
    }
    
    public static void deleteCourse(Scanner sc, CourseManagement cm){
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine();
            
            boolean deleted = cm.deleteOnlineCourse(id) || cm.deleteOfflineCourse(id);
            if (deleted) {
                System.out.println("Deleted successfully!");
                return;
            } else {
                System.out.println("No data found, do you want to find again? (Y/N): ");
                String action = sc.nextLine().trim();
                while (true) {
                    if (action.equalsIgnoreCase("Y")) {
                        deleteCourse(sc, cm);
                } else if (action.equalsIgnoreCase("N")) return;
                    else 
                    System.out.println("Invalid input! Please enter Y (Yes) or N (No): ");
                }
            }
        }
    }
    
    public static void showCourse(Scanner sc, CourseManagement cm){
        while (true) {
            System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
            String action = sc.nextLine().toUpperCase();

            if (action.equals("A")) {
                cm.showAllCourse();
                return;
            } else if (action.equals("O")) {
                cm.showOnlineCourse();
                return;
            } else if (action.equals("F")) {
                cm.showOfflineCourse();
                return;
            } else {
                System.out.println("Invalid option, please enter A, O, or F.");
            }
        }
    }
    
    public static void searchCourse(Scanner sc, CourseManagement cm){
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine();
            
            Course course = cm.findCourse(id);
            if (course != null) {
                System.out.println("\n*** Search results ***");
                cm.searchCourse(id);
                return;
            } else {
                System.out.println("No data found, do you want to find again? (Y/N): ");
                while (true) {
                    String action = sc.nextLine().trim();
                    if (action.equalsIgnoreCase("Y")) {
                        break;
                } else if (action.equalsIgnoreCase("N")) {
                    return;
                } else {
                    System.out.println("Invalid input! Please enter Y (Yes) or N (No): ");
                    }
                }
            }
        }
    }
}
