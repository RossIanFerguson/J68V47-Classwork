package Lesson2;

import java.util.*;
public class QuickMaffs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("First Number? ");
        int num1 = input.nextInt();

        System.out.print("Second Number? ");
        int num2 = input.nextInt();

        int Multiplication = num1 * num2;
        int Addition = num1 + num2;
        int Division = num1 / num2;
        int Subtraction = num1 - num2;
        int Modulo = num1 % num2;
        int Exponent = (int) Math.pow(num1,num2);

        System.out.print(num1 + " Times " + num2 + " Equals " + Multiplication);
        System.out.print("\n" + num1 + " Plus " + num2 + " Equals " + Addition);
        System.out.print("\n" + num1 + " Divided By " + num2 + " Equals " + Division);
        System.out.print("\n" + num1 + " Subtracted By " + num2 + " Equals " + Subtraction);
        System.out.print("\n" + num1 + " When divided by " + num2 + " And the remainder is taken is " + Modulo);
        System.out.print("\n" + num1 + " To the power off " + num2 + " Equals " + Exponent);
    }
}
