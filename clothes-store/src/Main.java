import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Connection url and properties.
        String url = new String();
        url = "jdbc:postgresql://localhost:5433/clothes";
        Properties props = new Properties();

        // Adding properties.
        props.setProperty("user", "postgres");
        props.setProperty("password", "1210");
        props.setProperty("SSL", "false");

        // Creating the connection to the database.
        DatabaseOperations DBOps = new DatabaseOperations(url, props);

        // Dropping the old table in case it is left from the previous demonstration.
        DBOps.deleteTable();

        // Creating the table from scratch.
        DBOps.createTable();

        // Lists for the product objects.
        List<Product> listOfProducts = new ArrayList<Product>();

        // Adding some objects to work with.
        Top topToAdd = new Top("Some Top", 1000);
        topToAdd.setAmount(1);
        // Adding the product to the list.
        listOfProducts.add(topToAdd);
        // Adding the product to the database.
        DBOps.addProduct(topToAdd);

        Lower lowerToAdd = new Lower("Some Lower", 2000, 3, 1);
        lowerToAdd.setAmount(0);
        lowerToAdd.setPrice(3000);
        lowerToAdd.calculateTotalCost();
        // Adding the product to the list.
        listOfProducts.add(lowerToAdd);
        // Adding the product to the database.
        DBOps.addProduct(lowerToAdd);

        Formal formalToAdd = new Formal(2001);
        formalToAdd.setAmount(13);
        formalToAdd.adjustPrice(7);
        // Adding the product to the list.
        listOfProducts.add(formalToAdd);
        // Adding the product to the database.
        DBOps.addProduct(formalToAdd);

        Informal informalToAdd = new Informal(2001);
        informalToAdd.setColor("Black");
        informalToAdd.changeColor("White");
        // Adding the product to the list.
        informalToAdd.setAmount(100);
        // Adding the product to the database.
        DBOps.addProduct(informalToAdd);

        // New scanner. Allows us to read input from the console.
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
                    DBOps.readProducts();
                    // showProducts(listOfProducts);
                    break;
                case 2:
                    System.out.println(("Buy product. Please enter the number of product."));
                    input = scan.nextLine();
                    Product productToBuy = listOfProducts.get(Integer.parseInt(input));
                    System.out.println("Do you want to buy " + productToBuy.getName() + "? \n Y/N");
                    input = scan.nextLine();
                    if (input.equals("Y")) {
                        productToBuy.sell();
                        DBOps.updateProduct(productToBuy);
                    }
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
        DBOps.closeConnection();
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