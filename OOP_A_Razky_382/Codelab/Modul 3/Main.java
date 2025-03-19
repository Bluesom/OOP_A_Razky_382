import java.util.Scanner; // Import Scanner for user input

// Main class to execute the game
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object for input
        
        // Display character selection menu
        System.out.println("Choose your character:");
        System.out.println("1. Brimstone");
        System.out.println("2. General Character");
        int choice = scanner.nextInt(); // Read user choice
        
        GameCharacter player; // Declare player character
        
        // Initialize player based on choice
        if (choice == 1) {
            player = new Hero("Brimstone", 150, 20);
        } else {
            player = new GeneralCharacter("General Character", 100, 10);
        }
        
        // Create an enemy character
        Enemy enemy = new Enemy("Viper", 200, 15);

        // Display initial status of characters
        System.out.println("Initial Status:");
        System.out.println(player.getName() + " has health: " + player.getHealth());
        System.out.println(enemy.getName() + " has health: " + enemy.getHealth());
        System.out.println();

        // Simulate a fight
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            player.attack(enemy); // Player attacks enemy
            if (enemy.getHealth() > 0) { // Check if enemy is still alive
                enemy.attack(player); // Enemy attacks player
            }
        }

        // Determine and print the winner
        if (player.getHealth() > 0) {
            System.out.println(player.getName() + " wins!");
        } else {
            System.out.println(enemy.getName() + " wins!");
        }

        scanner.close(); // Close scanner to avoid resource leak
    }
}