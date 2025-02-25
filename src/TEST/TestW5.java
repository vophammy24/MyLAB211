/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;

import java.util.Scanner;
import mylab211.WEEK5.CMMenu;
import mylab211.WEEK5.CourseManagement;

/**
 *
 * @author MY
 */
public class TestW5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManagement cm = new CourseManagement();
        CMMenu.menu(sc);
        
    }
}
