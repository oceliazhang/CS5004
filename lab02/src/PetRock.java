public class PetRock {
    private String name;
    private boolean happy = false;
    private double weight = 50.8;

    public PetRock(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHappy() {
        return happy;
    }

    public void playWithRock() {
        happy = true;
    }

    public String getHappyMessage() {
        if (!happy) {
            throw new IllegalStateException();
        }
        return "I'm happy!";
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Hi, the pet rock " + this.name + " weighs 50.8 grams";
    }
}
