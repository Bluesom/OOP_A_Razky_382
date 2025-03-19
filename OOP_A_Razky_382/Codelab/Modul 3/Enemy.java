// Enemy class extends GameCharacter
public class Enemy extends GameCharacter{
    private final int attackPower; // Attack power of the enemy

    // Constructor to initialize name, health, and attack power
    public Enemy(String name, int health, int attackPower) {
        super(name, health);
        this.attackPower = attackPower;
    }

    // Implementation of attack method
    @Override
    public void attack(GameCharacter target) {
        System.out.println(getName() + " attacks " + target.getName() + " using Snake Bite");
        target.setHealth(target.getHealth() - attackPower); // Reduce target's health
        
        System.out.println(target.getName() + " current health: " + target.getHealth()); // Print target's health
    }
}