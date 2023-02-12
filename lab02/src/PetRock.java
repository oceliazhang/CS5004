public class PetRock {
    private String name;
    private boolean happy = false;

    /**
     * Constructs a PetRock object with a string name
     * @param name the name of the pet rock
     * if pass an empty string as name, throw IllegalArgumentException
     */
    public PetRock(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    /**
     * Returns the name of the object
     * @return name of object
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a boolean value showing whether the object is happy or not
     * @return boolean value showing whether the object is happy or not
     */
    public boolean isHappy() {
        return happy;
    }

    /**
     * if we play with rock, it will be happy
     */
    public void playWithRock() {
        happy = true;
    }

    /**
     * if the rock is happy, returns the happy message "I'm happy!"
     * if not happy, throws IllegalStateException
     * @return happy message "I'm happy!"
     */
    public String getHappyMessage() {
        if (!happy) {
            throw new IllegalStateException();
        }
        return "I'm happy!";
    }

    /**
     * return the weight of the rock
     * @return the weight of the rock
     */
    public double getWeight() {
        return 50.8;
    }

    /**
     * toString() method
     * @return "Hi, the pet rock " + the rock's name + " weighs 50.8 grams"
     */
    public String toString() {
        return "Hi, the pet rock " + this.name + " weighs 50.8 grams";
    }
}