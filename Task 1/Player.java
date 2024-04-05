import java.util.Scanner;

// Interface for player behavior
interface Player {
    int makeGuess(int minRange, int maxRange);
    void updateGuessRange(int guess, String feedback);
}
