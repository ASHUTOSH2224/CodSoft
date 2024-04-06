
// Interface for AI opponent behavior
interface AIPlayer {
    int makeGuess(int minRange, int maxRange);
    void updateGuessRange(int guess, String feedback);
}
