package InternShip;
import java.util.Scanner;
import java.util.Random;
public class NumberGame 
{

	public static void main(String[] args) 
	{
		        Scanner scanner = new Scanner(System.in);
		        Random random = new Random();

		        int minRange = 1;
		        int maxRange = 50;
		        int rounds = 0;
		        int totalAttempts = 0;
		        boolean playAgain = true;

		        System.out.println("Welcome to the Number Guessing Game!");

		        while (playAgain) {
		            rounds++;
		            int randomNum = random.nextInt(maxRange - minRange + 1) + minRange;
		            int attempts = 0;
		            int userGuess;

		            System.out.println("\nRound " + rounds + ":");
		            System.out.println("Guess a number between " + minRange + " and " + maxRange + ".");

		            while (true) {
		                attempts++;
		                System.out.print("Enter your guess: ");

		                while (!scanner.hasNextInt()) {
		                    System.out.println("Invalid input. Please enter a valid integer.");
		                    scanner.next();
		                }

		                userGuess = scanner.nextInt();

		                if (userGuess == randomNum) {
		                    System.out.println("Congratulations! Your guess is correct.");
		                    break;
		                } else if (userGuess < randomNum) {
		                    System.out.println("Too low. Try again.");
		                } else {
		                    System.out.println("Too high. Try again.");
		                }

		                if (attempts >= 5) {
		                    System.out.println("Sorry, you've reached the maximum number of attempts.");
		                    System.out.println("The correct number was: " + randomNum);
		                    break;
		                }
		            }

		            totalAttempts += attempts;
		            System.out.println("Number of attempts: " + attempts);

		            System.out.print("Do you want to play again? (yes/no): ");
		            String playAgainInput = scanner.next().toLowerCase();
		            playAgain = playAgainInput.equals("yes");

		            
		            scanner.nextLine();
		        }

		        System.out.println("\nThank you for playing!");
		        System.out.println("Total rounds played: " + rounds);
		        System.out.println("Total attempts made: " + totalAttempts);
		        scanner.close();
		    }
		


	}

	
