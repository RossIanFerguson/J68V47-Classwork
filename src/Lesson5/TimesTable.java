package Lesson5;

import java.util.*;
public class TimesTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Times Table you wish to view: ");
        int Start = input.nextInt();
        int multiplier = (Start*12);
        for( int count=Start; count<=multiplier; count+=Start ){System.out.println(count);}


    }}
