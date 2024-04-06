import java.util.Scanner;

// Class representing a human player
public class HumanPlayer implements Player {
    private Scanner scanner;

    public HumanPlayer(Scanner scanner) {
        this.scanner = scanner;
    }

    public int makeGuess(int minRange, int maxRange) {
        System.out.println("Enter your guess between " + minRange + " and " + maxRange + ": ");
        return scanner.nextInt();
    }

    public void updateGuessRange(int guess, String feedback) {
        // Human player doesn't need to update guess range
    }
}
 