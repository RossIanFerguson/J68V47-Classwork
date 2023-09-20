import java.util.*;
public class Toaster {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("First Name: ");
        String FName = input.next();

        System.out.print("Second Name: ");
        String SName = input.next();

        System.out.print("Enter Total Value of Order: ");
        int Order = input.nextInt();

        System.out.print("Enter Desired Deposit: ");
        int Deposit = input.nextInt();

        System.out.print("== Receipt ==");

        System.out.print("\nCustomer: "+ FName.substring(0,1) + " " + SName);

        System.out.print("\nOrder Total: " + Order);

        System.out.print("\nDeposit Paid: " + Deposit);

        int Remainder = Order - Deposit;

        System.out.print("\nRemainder to pay: " + Remainder);

        if (Deposit > 100) System.out.println("\nYou Deposited over £100! You get a free toaster!");

        }}