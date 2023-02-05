public class Top extends Clothing implements Wearable {

    public Top(String newName, double initialPrice) {
        super(newName, initialPrice);
    }

    // interface
    boolean isEquipped = false;

    public void putOn() {
        if (this.isEquipped == false) {
            isEquipped = true;
            System.out.println(this.getName() + " looks good on you!");
        }
        else System.out.println("You are already wearing " + this.getName() + "!");
    }
    public void putOff() {
        if (this.isEquipped == true) {
            isEquipped = false;
            System.out.println("You removed " + this.getName() + ".");
        }
        else System.out.println("You are not wearing " + this.getName() + "!");
    }
}
