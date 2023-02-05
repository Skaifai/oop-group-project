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

    // Override the sell method from the parent class to add information about the size of the shoe
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
    public void wear() {
        if (this.getStatus() == false) {
            System.out.println("We are sorry, but it is not available at the moment.");
        }
        else {
            System.out.println("You are now wearing " + this.getName());
        }
    }

    // Add a new method to change the price of the shoe based on the size
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