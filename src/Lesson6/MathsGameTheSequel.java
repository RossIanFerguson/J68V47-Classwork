package Lesson6;

import java.util.*;
public class MathsGameTheSequel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Times Table you wish to be quizzed on: ");
        int lives = 3;
        int score;
        {
            int Variable = input.nextInt();
            score = 0;
            for (int count = 1; count <= 10; count += 1) {
                if (lives == 0){System.out.print("GAME OVER   ");System.out.print("Your Score Was: " + score);}
                while (lives <= 0);
                int questiona = (Variable * count);
                System.out.print("What is " + Variable + " Times " + count + " :");
                int ans = input.nextInt();
                if (ans == questiona) {
                    System.out.print("Good Job you got that correct\n");
                    score++;}
                if (ans != questiona) {System.out.print("Incorrect,one life lost\n");
                    lives-=1;}

            }
        }
        System.out.print("Your Score Was: " + score);
        if (score == 10){System.out.print("Well Done");}
    }}
