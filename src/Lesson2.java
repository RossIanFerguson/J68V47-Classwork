import java.util.*;
public class Lesson2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String firstName = input.nextLine();

        System.out.print("What is your Hobby? ");
        String hobby = input.nextLine();

        System.out.println(firstName + " Enjoys " + hobby);
        System.out.println("It makes " + firstName + " Very Happy as they enjoy it thoroughly");

    }
}