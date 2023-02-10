public class Top extends Clothing implements Wearable {

    public Top(String newName, double initialPrice) {
        super(newName, initialPrice);
    }

    // Interface support variable.
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

    // Variable type stores the type of the clothing. For example, it can be "hoodie", "t-shirt", or "sweater".
    private String type;

    // Getter method. If type is not null, it returns the type. If the type is null, it returns null.
    public String getType() {
        if (this.type != null) {
            return this.type;
        }
        else System.out.println("The type is null!");
        return null;
    }

    // Setter method. Can only set the type once.
    public void setType(String newType) {
        if (this.type == null) {
            this.type = newType;
        }
        else {
            System.out.println("This object already has a type!");
        }
    }
}
