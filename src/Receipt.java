import java.util.*;
public class Receipt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(" name of first item ");
        String item1 = input.nextLine();
        System.out.print(item1 + " cost? ");
        float num1 = input.nextFloat();

        System.out.println(" name of second item ");
        String item2 = input.nextLine();
        System.out.print(item2 + " cost? ");
        float num2 = input.nextFloat();

        System.out.println(" name of third item ");
        String item3 = input.nextLine();
        System.out.print(item3 + " cost? ");
        float num3 = input.nextFloat();



        float Totalcost = Float.sum(num1,Float.sum(num2,num3));

        System.out.println("NesSmart");
    }
}
