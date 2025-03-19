// Hero class extends GameCharacter
public class Hero extends GameCharacter{
    private final int attackPower; // Attack power of the hero

    // Constructor to initialize name, health, and attack power
    public Hero(String name, int health, int attackPower) {
        super(name, health);
        this.attackPower = attackPower;
    }

    // Implementation of attack method
    @Override
    public void attack(GameCharacter target) {
        System.out.println(getName() + " Attacks " + target.getName() + " using Orbital Strike");
        target.setHealth(target.getHealth() - attackPower); // Reduce target's health
        
        System.out.println(target.getName() + " current health: " + target.getHealth()); // Print target's health
    }
}