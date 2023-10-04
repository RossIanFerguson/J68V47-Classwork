package Lesson5;

import java.util.*;
public class MathsGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Times Table you wish to be quizzed on: ");
        int Variable = input.nextInt();
        int score = 0;
        for (int count = 1; count <= 10; count += 1) {
            int questiona = (Variable * count);
            System.out.print("What is "+Variable+" Times "+count+" :");
            int ans = input.nextInt();
            score = 0;
            if (ans == questiona) {
                System.out.print("Good Job you got that correct\n");
                score++;
            }
        }
        System.out.print("Your Score Was: " + score);
    }}