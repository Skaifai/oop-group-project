// Abstract class which represents the shoes.
// One of the two children of the Product superclass. Has two child classes: Formal and Informal.
public abstract class Shoe extends Product implements Wearable {
    public Shoe(double initialPrice) {
        super(initialPrice);
    }

    // Interface methods support.
    boolean isEquipped = false;
    // Interface methods with the implementation.
    public void putOn() {
        if (this.getName() != null && this.isEquipped == false) {
            isEquipped = true;
            System.out.println(this.getName() + " looks good on you!");
        }
        else if (this.isEquipped == true) {
            System.out.println("You are already wearing " + this.getName() + "!");
        }
        else System.out.println("We are not sure if you can wear this.");
    }

    public void putOff() {
        if (this.isEquipped == true) {
            isEquipped = false;
            System.out.println("You removed " + this.getName() + ".");
        }
        else System.out.println("You are not wearing " + this.getName() + "!");
    }
}