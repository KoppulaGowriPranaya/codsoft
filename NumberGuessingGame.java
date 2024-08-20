import java.util.Random;// random is used to generate random numbers
import java.util.Scanner;//it is used to readinput from the user
class NumberGuessingGame
{
    public static void main(String[] args)
     {
        Scanner scanner= new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = random.nextInt(100);// it generates number between 1 to 100
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasGuessedCorrectly = true;
                }

                if (!hasGuessedCorrectly) {
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing the Number Guessing Game! Goodbye.");
        scanner.close();
    }
}

