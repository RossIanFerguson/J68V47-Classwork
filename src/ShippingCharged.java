import java.util.*;
public class ShippingCharged {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Total Purchase Amount: ");
        int Purchase = input.nextInt();
        int Shipping = 0;
        if (Purchase < 50) System.out.println(Shipping = 10);
        System.out.print("Shipping Cost is: "+Shipping);
        System.out.print("\nTotal Cost is: " + (Shipping+Purchase));
    }}