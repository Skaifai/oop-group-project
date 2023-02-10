import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// import java.sql.*;
// import java.util.Properties;
public class Main {
    public static void main(String[] args) {
        // Lists for the product objects.
        List<Top> listOfTops = new ArrayList<Top>();
        List<Lower> listOfLowers = new ArrayList<Lower>();
        List<Formal> listOfFormals = new ArrayList<Formal>();
        List<Informal> listOfInformals = new ArrayList<Informal>();

        Scanner scan = new Scanner(System.in);
        // Input string variable.
        String input = null;

        System.out.println("Hello! Welcome to our clothes shop!");
        scan.nextLine();

        System.out.println("First of all, are you a client(C) or an employee(E)?");
        input = scan.nextLine();

        if (input.equals("C"))
        {
            System.out.println("Thank you for your patronage! What would you like to do? \nChoose a number of the option. " +
                    "To quit the client program enter the letter \"q\".");
            while (input != "q")
            {
                System.out.println("1. Browse products \n2. Buy products \n3. Try products");
                input = scan.nextLine();
            }

        }
        else if (input.equals("E")) {
            System.out.println("Welcome! What would you like to do? Choose a number of the option. To quit the program enter the letter \"q\".");
            while (input != "q")
            {
                System.out.println("1. Create product \n2. Delete product \n3. Edit product \n4. Sell product");
                input = scan.nextLine();
            }
        }
    }


}