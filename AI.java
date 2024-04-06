// Class representing an AI player
class AI implements AIPlayer {
    private int minRange;
    private int maxRange;

    public AI(int minRange, int maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public int makeGuess(int minRange, int maxRange) {
        // AI's guess logic goes here
        // For simplicity, AI chooses the midpoint of the current range
        return minRange + (int) (Math.random() * (maxRange - minRange + 1));
    }

    public void updateGuessRange(int guess, String feedback) {
        // AI may update its guess range based on feedback
        if (feedback.equals("Too low!")) {
            minRange = guess + 1;
        } else if (feedback.equals("Too high!")) {
            maxRange = guess - 1;
        }
    }
}

