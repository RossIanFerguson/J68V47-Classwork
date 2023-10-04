package Lesson3;

import java.util.*;
public class Account {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("First Name: ");
        String FName = input.next();

        System.out.print("Second Name: ");
        String SName = input.next();

        System.out.print("Year of Birth: ");
        String DOB = input.next();

        String displayName = (FName.substring(0,1)) + SName.toLowerCase();
        System.out.print("Display name: " + displayName);

        String Password = (FName.substring(0,1).toLowerCase()) + (SName.substring(0,3).toUpperCase()) + DOB;
        System.out.print("\nPassword: " + Password);
    }}