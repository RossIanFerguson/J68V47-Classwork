package Lesson6;

import java.util.Scanner;
import java.time.LocalTime;
public class ARDI {public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("1: Say “hello”\n" +
            "2: Tell me the time\n" +
            "3: Tell me a joke\n" +
            "4: Quit\n");
    int response;
    response = 0;
    while (response != 4) {
        System.out.print("Input Response: ");
        response = input.nextInt();
        if (response == 1) {
            System.out.print("-Hello-\n ");
        }
        if (response == 2) {
            System.out.println("-"+LocalTime.now()+"-");
        }
        if (response == 3) {
            System.out.print("-You.- \n");


    }

}}}
