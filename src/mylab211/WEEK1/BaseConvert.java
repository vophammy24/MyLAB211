/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylab211.WEEK1;

import java.util.Scanner;

public class BaseConvert {
    private String input;
    private int inputBase;

    public BaseConvert(String input, int inputBase) {
        this.input = input;
        this.inputBase = inputBase;
    }
    
    //chuyển tất cả về hệ thâp phân
    private int toDecimalValue() {
        int decimalValue = 0;
        for (int i = 0; i < input.length(); i++) { //cho i chạy từ đầu đến cuối giá trị đầu vào
            char c = input.charAt(input.length() - 1 - i); //cho i chạy ngược từ cuối đến đầu để lấy giá trị binary
            int digit = Character.isDigit(c) ? c - '0' : Character.toUpperCase(c) - 'A' + 10; //chuyển đổi c thành số hoặc chữ cái
            decimalValue += digit * Math.pow(inputBase, i); //cập nhật giá trị thập phân
        }
        return decimalValue;
    }
    
    public String toBinary() {
        int decimalValue = toDecimalValue();//chuyển về thập phân
        StringBuilder binary = new StringBuilder();
        while (decimalValue > 0) {
            binary.insert(0, decimalValue % 2);
            decimalValue /= 2;
        }
        return binary.length() > 0 ? binary.toString() : "0";
    }

    public String toDecimal() {
        return Integer.toString(toDecimalValue());
    }

    public String toHexadecimal() {
        int decimalValue = toDecimalValue();
        StringBuilder hex = new StringBuilder();
        while (decimalValue > 0) {
            int remainder = decimalValue % 16;
            hex.insert(0, (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A'));
            decimalValue /= 16;
        }
        return hex.length() > 0 ? hex.toString() : "0";
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continueConverting = true;

        while (continueConverting) {
            System.out.println("Choose the input base (2, 10, 16):");
            int inputBase = scanner.nextInt();

            System.out.println("Choose the output base (2, 10, 16):");
            int outputBase = scanner.nextInt();

            System.out.println("Please enter the number to be converted:");
            String input = scanner.next();

            BaseConvert convert = new BaseConvert(input, inputBase);
            String output = "";

            switch (outputBase) {
                case 2:
                    output = convert.toBinary();
                    break;
                case 10:
                    output = convert.toDecimal();
                    break;
                case 16:
                    output = convert.toHexadecimal();
                    break;
                default:
                    System.out.println("Invalid output base");
                    continue;
            }

            System.out.println("After convert value: " + output);

            System.out.println("Continue convert another number? (y/n):");
            String response = scanner.next().toLowerCase();
            continueConverting = response.equals("y");
        }

        System.out.println("Program end.");
    }
}
