/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylab211.WEEK2;

import java.util.Scanner;

/**
 *
 * @author MY
 */
public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true){
            System.out.println("======Calculator Program======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            
            if (choice == 4) {
                System.out.println("Quiting...");
                break;
            }

            System.out.print("Enter Row Matrix 1:");
            int row1 = scanner.nextInt();
            System.out.print("Enter Column Matrix 1:");
            int column1 = scanner.nextInt();
            MatrixProgram matrix1 = new MatrixProgram(row1, column1);
            matrix1.inputMatrix(scanner);
            
            System.out.print("Enter Row Matrix 2:");
            int row2 = scanner.nextInt();
            System.out.print("Enter Column Matrix 2:");
            int column2 = scanner.nextInt();
            MatrixProgram matrix2 = new MatrixProgram(row2, column2);
            matrix2.inputMatrix(scanner);

            MatrixProgram result = null;
            
            if ((choice == 1 || choice == 2) && (row1 != row2 || column1 != column2)) {
                System.out.println("Matrix dimensions do not match for addition or subtraction.");
                continue;
            }
            
            if (choice == 3 && column1 != row2) {
                System.out.println("Matrix dimensions do not match for multiplication.");
                continue; 
            }
            
            try {
                switch (choice) {
                    case 1:
                        result = matrix1.additionMatrix(matrix2);
                        System.out.println("-------- Result --------");
                        matrix1.displayMatrix();
                        System.out.println("+");
                        matrix2.displayMatrix();
                        System.out.println("=");
                        result.displayMatrix();
                        break;
                    case 2:
                        result = matrix1.subtractionMatrix(matrix2);
                        System.out.println("-------- Result --------");
                        matrix1.displayMatrix();
                        System.out.println("-");
                        matrix2.displayMatrix();
                        System.out.println("=");
                        result.displayMatrix();
                        break;
                    case 3:
                        result = matrix1.multiplicationMatrix(matrix2);
                        System.out.println("-------- Result --------");
                        matrix1.displayMatrix();
                        System.out.println("*");
                        matrix2.displayMatrix();
                        System.out.println("=");
                        result.displayMatrix();
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1-4.");
                        continue;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

class MatrixProgram{
    private int row;
    private int column;
    private int[][] data;

    public MatrixProgram(int row, int column) {
        this.row = row;
        this.column = column;
        data = new int[row][column];
    }
    
    public void inputMatrix(Scanner scanner){
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                while (true){
                    System.out.print("Enter Matrix [" + (i + 1) + "][" + (j + 1) + "]:");
                    if(scanner.hasNextInt()) {
                        data[i][j] = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Value of matrix is digit.");
                        scanner.next();
                    }
                }
            }
        }
    }
    
    public void displayMatrix() {
        for (int i = 0; i < row; i++) {
            System.out.print("[");
            for (int j = 0; j < column; j++) {
                System.out.print(data[i][j]);
                if (j != column - 1)
                    System.out.print("][");
            }
        }
        System.out.println("]");
    }
    
    public MatrixProgram additionMatrix(MatrixProgram matrix2){
        if (this.row != matrix2.row || this.column != matrix2.column){
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }
        MatrixProgram result = new MatrixProgram(row, column);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                result.data[i][j] = this.data[i][j] + matrix2.data[i][j];
            }
        }
        return result;
    }
    
    public MatrixProgram subtractionMatrix(MatrixProgram matrix2){
        if (this.row != matrix2.row || this.column != matrix2.column){
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }
        MatrixProgram result = new MatrixProgram(row, column);
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                result.data[i][j] = this.data[i][j] - matrix2.data[i][j];
            }
        }
        return result;
    }
    
    public MatrixProgram multiplicationMatrix(MatrixProgram matrix2){
        if (this.column != matrix2.row){
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }
        MatrixProgram result = new MatrixProgram(row, column);
        for (int i = 0; i < this.row; i++){
            for (int j = 0; j < matrix2.column; j++){
                for (int k = 0; k < this.column; k++){
                    result.data[i][j] += this.data[i][k] * matrix2.data[k][j];
                }
            }
        }
        return result;
    }
    
}
