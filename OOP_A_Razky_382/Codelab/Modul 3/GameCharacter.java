public abstract class GameCharacter {
    private String name; // Name of the character
    private int health; // Health of the character

    // Constructor to initialize name and health
    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Setter method for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for health
    public int getHealth() {
        return health;
    } 

    // Setter method for health
    public void setHealth(int health) {
        this.health = health;
    }

    // Abstract method for attacking another character (to be implemented by subclasses)
    public abstract void attack(GameCharacter target);
}