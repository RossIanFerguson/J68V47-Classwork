import java.util.*;
public class Countries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the capital of Spain: ");
        String UserSpain = input.next();
        if (UserSpain.toLowerCase().equals("madrid")){
            System.out.println("Correct");}
        else {System.out.println("Incorrect, The Correct Answer is Madrid");}

        System.out.print("What is the capital of the UK: ");
        String UserUK = input.next();
        if (UserUK.toLowerCase().equals("london")){
            System.out.println("Correct");}
        else {System.out.println("Incorrect, The Correct Answer is London");}

        System.out.print("What is the capital of Italy: ");
        String UserItaly= input.next();
        if (UserItaly.toLowerCase().equals("milan")){
            System.out.println("Correct");}
        else {System.out.println("Incorrect, The Correct Answer is Milan");}
        }

    }