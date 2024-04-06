import java.util.Scanner;

// Class representing the game
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose game mode:");
            System.out.println("1. Play with AI");
            System.out.println("2. Play with a friend");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            if (choice == 1) {
                playWithAI(scanner);
            } else if (choice == 2) {
                playWithFriend(scanner);
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        scanner.close();
    }

    public static void playWithAI(Scanner scanner) {
        Player player = new HumanPlayer(scanner);
        AIPlayer ai = new AI(1, 100);
        playGame(player, ai, scanner);
    }
    
    
    
    

    public static void playWithFriend(Scanner scanner) {
        Player player1 = new HumanPlayer(scanner);
        Player player2 = new HumanPlayer(scanner);
        playGame(player1, player2, scanner);
    }
    

    public static void playGame(Player player1, AIPlayer player2, Scanner scanner) {
        int minRange = 1;
        int maxRange = 100;

        while (true) {
            // Player 1's turn
            int guess1 = player1.makeGuess(minRange, maxRange);
            if (guess1 == player2.makeGuess(minRange, maxRange)) {
                System.out.println("Player 1 guessed the number correctly!");
                break;
            } else if (guess1 < player2.makeGuess(minRange, maxRange)) {
                System.out.println("Player 1 guessed too low!");
                minRange = guess1 + 1;
            } else {
                System.out.println("Player 1 guessed too high!");
                maxRange = guess1 - 1;
            }

            // Check if player 1 has won
            if (minRange > maxRange) {
                System.out.println("Player 2 wins! Player 1's guess was incorrect.");
                break;
            }

            // Player 2's turn
            int guess2 = player2.makeGuess(minRange, maxRange);
            if (guess2 == player1.makeGuess(minRange, maxRange)) {
                System.out.println("Player 2 guessed the number correctly!");
                break;
            } else if (guess2 < player1.makeGuess(minRange, maxRange)) {
                System.out.println("Player 2 guessed too low!");
                minRange = guess2 + 1;
            } else {
                System.out.println("Player 2 guessed too high!");
                maxRange = guess2 - 1;
            }

            // Check if player 2 has won
            if (minRange > maxRange) {
                System.out.println("Player 1 wins! Player 2's guess was incorrect.");
                break;
            }
        }
    }
}
