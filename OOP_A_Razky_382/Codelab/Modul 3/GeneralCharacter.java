// GeneralCharacter class extends GameCharacter
public class GeneralCharacter extends GameCharacter {
    private final int attackPower; // Attack power of general character

    // Constructor to initialize name, health, and attack power
    public GeneralCharacter(String name, int health, int attackPower) {
        super(name, health);
        this.attackPower = attackPower;
    }

    // Implementation of attack method
    @Override
    public void attack(GameCharacter target) {
        System.out.println(getName() + " attacks " + target.getName() + " using Excalibur");
        target.setHealth(target.getHealth() - attackPower); // Reduce target's health
        
        System.out.println(target.getName() + " current health: " + target.getHealth()); // Print target's health
    }
}