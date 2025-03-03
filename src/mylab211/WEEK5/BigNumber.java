package mylab211.WEEK5;

import java.math.BigInteger;
import java.util.Scanner;

public class BigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        String S1 = scanner.nextLine();
        System.out.print("Enter second number: ");
        String S2 = scanner.nextLine();
        
        BigInteger num1 = new BigInteger(S1);
        BigInteger num2 = new BigInteger(S2);
        
        BigInteger sum = num1.add(num2);
        BigInteger mul = num1.multiply(num2);
        
        System.out.println("Sum: " + addLargeNumbers(S1, S2));
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + multiplyLargeNumbers(S1, S2));
        System.out.println("Porduct: " + mul);

        scanner.close();
    }

    public static String addLargeNumbers(String S1, String S2) {
        int maxLength = Math.max(S1.length(), S2.length()) + 1;
        int[] array = new int[maxLength];
        int i = S1.length() - 1;
        int j = S2.length() - 1;
        int carry = 0, index = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = S1.charAt(i--) - '0';
            int digit2 = S2.charAt(j--) - '0';
            int sum = digit1 + digit2 + carry;
            array[index] = sum % 10;
            index++;
            carry = sum / 10;
        }

        return sumResult(array, array.length);
    }

    public static String multiplyLargeNumbers(String S1, String S2) {
        int[] array = new int[S1.length() + S2.length()];

        for (int i = S1.length() - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = S2.length() - 1; j >= 0; j--) {
                int digit1 = S1.charAt(i) - '0';
                int digit2 = S2.charAt(j) - '0';
                int mul = digit1 * digit2 + array[i + j + 1] + carry;
                array[i + j + 1] = mul % 10;
                carry = mul / 10;
            }
            array[i] += carry;
        }

        return multiplyResult(array, array.length);
    }

    private static String sumResult(int[] arr, int length) {
        String result = "";
        for (int k = length - 1; k >= 0; k--) {
            result = result + arr[k];
        }
        return result;
    }
    private static String multiplyResult(int[] arr, int length) {
        String result = "";
        for (int k = 0; k <= length - 1; k++) {
            result = result + arr[k];
        }
        return result;
    }
}
