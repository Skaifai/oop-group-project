// Abstract class, which represents the clothes.
// One of the two children of the Product superclass. Has two child classes: Top and Lower.
public abstract class Clothing extends Product implements Wearable {

    public Clothing(String newName, double initialPrice) {
        super(newName, initialPrice);
    }

    // Interface methods support variables.
    private boolean isEquipped = false;

    // Interface methods with no implementation.
    public void putOn() {
    }

    public void putOff() {
    }
}