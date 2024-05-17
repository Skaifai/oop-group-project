public class Lower extends Clothing implements Wearable{
    private int waistSize;
    private int inseamLength;


    public Lower(String newName, double initialPrice, int waistSize, int inseamLength) {
        super(newName, initialPrice);
        this.waistSize = waistSize;
        this.inseamLength = inseamLength;
    }


    // Getter for waist size
    public int getWaistSize() {
        return waistSize;
    }

    // Getter for inseam length
    public int getInseamLength() {
        return inseamLength;
    }

    // Setter for waist size
    public void setWaistSize(int waistSize) {
        this.waistSize = waistSize;
    }

    // Setter for inseam length
    public void setInseamLength(int inseamLength) {
        this.inseamLength = inseamLength;
    }
    public double calculateTotalCost() {
        double markup = getPrice() * 0.2;
        return getPrice() + markup;
    }

    // Implementation of the putOn method from the Wearable interface
    @Override
    public void putOn() {
        System.out.println("Putting on " + getName());
    }

    // Implementation of the takeOff method from the Wearable interface
    @Override
    public void putOff() {
        System.out.println("Taking off " + getName());
    }

    // Overridden toString method to include information about waist size and inseam length
    @Override
    public String toString() {
        return super.toString() + " with waist size of " + waistSize + " and inseam length of " + inseamLength;
    }
}