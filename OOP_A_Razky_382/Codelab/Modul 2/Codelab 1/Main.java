public class Main {
    public static void main(String[] args) {
        
        Animal animal1 = new Animal("Cat", "Mammal", "Nyann~~\n");
        Animal animal2 = new Animal("Dog", "Mammal", "Woof~~\n");

        animal1.displayInfo();
        animal2.displayInfo();
    }
}