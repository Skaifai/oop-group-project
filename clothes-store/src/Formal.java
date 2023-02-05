public class Formal extends Shoe implements Wearable {
    public Formal(double initialPrice) {
        super(initialPrice);
    }

    // This is a  new attribute to store the size of the shoe
    private int size;

    // Getter and setter methods for the size attribute
    public int getSize() {
        return this.size;
    }
    public void setSize(int newSize) {
        this.size = newSize;
    }

    // "sell" method from the parent class to add information about the size of the shoe
    // if the status of the shoe is available, then it returns the following line including the size of the particular shoe
    @Override
    public void sell() {
        if (this.getStatus() == false) {
            System.out.println("We are sorry, but it is not available at the moment.");
        }
        else {
            System.out.println("Thank you for buying " + this.getName() + "!");
            System.out.println("The size of the shoe is " + this.getSize());
            System.out.println("The amount to pay is " + this.getPrice());
        }
    }
    // Implement the wear method from the Wearable interface
    // The method checks if the shoe is available depending on the stored status that we can see in the product class
    public void wear() {
        if (this.getStatus() == false) {
            System.out.println("We are sorry, but it is not available at the moment.");
        }
        else {
            System.out.println("You are now wearing " + this.getName());
        }
    }

    // "ajustPrice" method is created to change the price of the shoe based on the size.
    // and if there is no available size it prints the following line of words
    public void adjustPrice(int size) {
        if (size == 7) {
            this.setPrice(this.getPrice() + 10.0);
        }
        else if (size == 8) {
            this.setPrice(this.getPrice() + 20.0);
        }
        else if (size == 9) {
            this.setPrice(this.getPrice() + 30.0);
        }
        else if (size == 10) {
            this.setPrice(this.getPrice() + 40.0);
        }
        else {
            System.out.println("This size is not available.");
        }
    }
}