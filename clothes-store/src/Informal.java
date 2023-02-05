public class Informal extends Shoe implements Wearable{

    public Informal(double initialPrice) {
        super(initialPrice);
    }
    // create a new attribute to store shoe color information
    private String color;

    // Пиши свой код ниже.
    // add getter and setter method for color of the shoe
    public String getColor() {
        return this.color;
    }
    public void setColor(String newColor) {
        this.color = newColor;
    }

    // Override the putOn and putOff methods from the shoe class for the additional data of the color of the shoes
    @Override
    public void putOn() {
        if (this.getName() != null && this.isEquipped == false) {
            isEquipped = true;
            System.out.println(this.getName() + " looks amazing!");
            System.out.println("The color of the shoe is " + this.getColor());
        }
        else if (this.isEquipped == true) {
            System.out.println("You are already wearing " + this.getName() + "!");
        }
        else System.out.println("We are not sure if you can wear this.");
    }

    @Override
    public void putOff() {
        if (this.isEquipped == true) {
            isEquipped = false;
            System.out.println("You removed " + this.getName() + ".");
            System.out.println("The color of the shoe is " + this.getColor());
        }
        else System.out.println("You are not wearing " + this.getName() + "!");
    }

    // here you can see a new method called changeColor that sets a new color of the shoe
    public void changeColor(String newColor) {
        this.setColor(newColor);
        System.out.println("The color of the shoe has been changed to " + this.getColor());
    }
}

