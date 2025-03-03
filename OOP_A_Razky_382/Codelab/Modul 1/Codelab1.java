import java.time.LocalDate; // Importing LocalDate library to get the current year
import java.util.Scanner;   // Importing Scanner library for user input

public class Codelab1 {
    public static void main(String[] args) {
        // Variable declarations
        String nama;      // Declares a String variable for the name
        char kelamin;     // Declares a char variable for gender
        int tahunLahir, umur; // Declares integer variables for birth year and age

        // Creating a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Asking for and reading the user's name
        System.out.print("Masukkan nama: "); // Prompting the user to enter their name
        nama = scanner.nextLine(); // Reads the full line as the name (including spaces)

        // Asking for and reading the user's gender
        System.out.print("Masukkan jenis kelamin (L/P): "); // L for Male, P for Female
        kelamin = scanner.next().charAt(0); // Reads the first character of the input

        // Variable to store the full description of gender
        String jenisKelamin;

        // Using a switch statement to determine the gender description
        switch(kelamin) {
            case 'L': // If the input is uppercase 'L'
            case 'l': // If the input is lowercase 'l'
                jenisKelamin = "Laki-Laki"; // Sets gender as Male
                break; // Exits the switch statement
            case 'P': // If the input is uppercase 'P'
            case 'p': // If the input is lowercase 'p'
                jenisKelamin = "Perempuan"; // Sets gender as Female
                break;
            default: // If the input is not recognized
                jenisKelamin = "Pilihan tidak Valid!"; // Sets gender as Unknown
                break;
        }

        // Asking for and reading the user's birth year
        System.out.print("Masukkan tahun kelahiran: "); 
        tahunLahir = scanner.nextInt(); // Reads the birth year as an integer
        
        // Calculating the age
        umur = LocalDate.now().getYear() - tahunLahir;
        // Gets the current year using LocalDate.now().getYear() and subtracts the birth year
        
        // Displaying the user data
        System.out.println("\nData Diri:"); 
        System.out.println("Nama            : " + nama); // Displays the name
        System.out.println("Jenis Kelamin   : " + jenisKelamin); // Displays the gender description
        System.out.println("Umur            : " + umur + " tahun"); // Displays the calculated age

        // Closing the scanner to prevent resource leaks
        scanner.close();
    }
}
