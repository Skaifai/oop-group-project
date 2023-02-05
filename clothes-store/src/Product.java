// Main abstract class, which serves as the general
// abstraction superclass for all the products in our store.
public abstract class Product {

    // Constructor method, which allows to pass the values for the variable at the moment of the creation of the object.
    public Product(String newName, double initialPrice) {
        this.name = newName;
        this.setPrice(initialPrice);
    }

    // There can be multiple constructors for different purposes. This one, in particular, is made for the Shoes class.
    public Product(double initialPrice) {
        this.setPrice(initialPrice);
    }

    // Stores the name of the product.
    private String name;

    // Since our name variable is private, we need a getter method to read the name variable.
    // We don't need a setter method, because the name of the product should not be changed.
    //public void setName(String newName) { this.name = newName; }
    public String getName() {
        return this.name;
    }

    // Stores the price value of the product.
    private double price;

    // In contrast to the name of the product, its price can change multiple times during the sales, so we need both
    // setter and getter methods.
    public void setPrice(double newPrice) {
        if (newPrice < 0) System.out.println("Price can't be negative! Set new price.");
        else this.price = newPrice;
    }
    public double getPrice() {
        return this.price;
    }

    // Stores the status of the current product. The product can either be available or not, so we will use a boolean variable
    // "isAvailable", which will server as a flag. The default value is false, because the default value of the amount is 0.
    private boolean isAvailable = false;

    // This method is private, because we only need it for the internal methods of the class. We don't want any external
    // agents to alter the value of this field, because it is entirely dependent on the private variable of this class.
    private void setStatus(boolean newStatus) {
        this.isAvailable = newStatus;
    }
    public boolean getStatus() {
        return this.isAvailable;
    }

    // Stores the amount of the product left in stock. The default value is 0.
    private int amount = 0;

    // When the amount is 0, the isAvailable flag should be always false, when the amount is bigger than 0, it should be
    // always true. We do not need a getter method, because we already have the isAvailable flag, which lets the user
    // know if they can buy the product or not.

    // This method allows user to set the amount directly.
    public void setAmount(int newAmount) {
        this.amount =  newAmount;
        if (this.amount < 1) this.setStatus(false);
        else this.setStatus(true);
    }

    // We can sell products, which should show the price and the name of the product.
    public void sell() {
        if (this.getStatus() == false) {
            System.out.println("We are sorry, but it is not available at the moment.");
        }
        else {
            System.out.println("Thank you for buying " + this.getName() + "!");
            System.out.println("The amount to pay is " + this.getPrice());
        }
    }


}
