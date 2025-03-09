import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the game 'Guess the number'! Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
        System.out.println("Choose a difficulty(1-Easy, 2-Medium, 3-Hard): ");
        int difficulty = scanner.nextInt();

        /*set difficulty */
        int range = switch (difficulty) {
            case 1 -> 50;
            case 2 -> 100;
            case 3 -> 500;
            default -> 100;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; 
        int attempts = 0;
        int maxattempts = 10;

        System.out.println("Guess a number between 1 and " + range +": ");
        while (attempts < maxattempts) {
            int guess = scanner.nextInt();
            attempts++;
            if (guess < randomNumber) {
                System.out.println("Too low! Try again.");                                
            } else if (guess > randomNumber){
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congrats! You guessed the number in: " + attempts + "attempts.");
                break;
            }
        }
        if (attempts == maxattempts) {
            System.out.println("Sorry, you've run out of attempts. The number was " + randomNumber + ".");
        }
        scanner.close();
    }
}
