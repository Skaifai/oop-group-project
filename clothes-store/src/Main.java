import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// import java.sql.*;
// import java.util.Properties;
public class Main {
    public static void main(String[] args) {

        // Lists for the product objects.
        List<Product> listOfProducts = new ArrayList<Product>();

        Top topToAdd = new Top("Some Top", 1000);
        topToAdd.setAmount(1);
        listOfProducts.add(topToAdd);

        Lower lowerToAdd = new Lower("Some Lower", 2000, 3, 1);
        lowerToAdd.setAmount(0);
        lowerToAdd.setPrice(3000);
        lowerToAdd.calculateTotalCost();
        listOfProducts.add(lowerToAdd);

        Formal formalToAdd = new Formal(2001);
        formalToAdd.setAmount(13);
        formalToAdd.adjustPrice(7);
        listOfProducts.add(formalToAdd);

        Informal informalToAdd = new Informal(2001);
        informalToAdd.setColor("Black");
        informalToAdd.changeColor("White");
        informalToAdd.setAmount(100);
        listOfProducts.add(informalToAdd);

        Scanner scan = new Scanner(System.in);
        // Input string variable.
        String input = null;

        System.out.println("Hello! Welcome to our shop!");
        scan.nextLine();
        while (input != "q") {
            System.out.println("Thank you for your patronage! What would you like to do? \nInput the number of the option. " +
                    "To quit the client program enter the letter \"q\".");
            System.out.println("1. Browse products \n2. Buy products \n3. Try products \n4. Go back");
            input = scan.nextLine();
            if (input.equals("q")) break;
            switch(Integer.parseInt(input)) {
                case 1:
                    System.out.println("Browse products.");

                    // Show all products, if there are any
                    showProducts(listOfProducts);
                    break;
                case 2:
                    System.out.println(("Buy product. Please enter the number of product."));
                    input = scan.nextLine();
                    Product productToBuy = listOfProducts.get(Integer.parseInt(input));
                    System.out.println("Do you want to buy " + productToBuy.getName() + "? \n Y/N");
                    input = scan.nextLine();
                    if (input.equals("Y")) productToBuy.sell();
                    else if (input.equals("N")) System.out.println("Fair enough. Returning to the previous menu.");
                    else System.out.println("Incorrect input!");
                    break;
                case 3:
                    System.out.println(("Try product. Please enter the number of product."));
                    input = scan.nextLine();
                    Product productToTry = listOfProducts.get(Integer.parseInt(input));
                    System.out.println("Do you want to try " + productToTry.getName() + "? \nY/N");
                    input = scan.nextLine();
                    if (input.equals("Y")) {
                        productToTry.putOn();
                        productToTry.putOff();
                    }
                    else if (input.equals("N")) System.out.println("Fair enough. Returning to the previous menu.");
                    else System.out.println("Incorrect input!");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Incorrect input!");
            }
        }
    }

    public static void showProducts(List<Product> products) {
        if (products.size() <= 0) System.out.println("Unfortunately, we have nothing left for you! Sorry :c");
        else {
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println(products.indexOf(product) + ". " + product.getName() + " of " + product.getClass() + ", available: " + product.getStatus());
            }
        }
        return;
    }
}