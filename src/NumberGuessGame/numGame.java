package NumberGuessGame;

import Game.GameWriteable;
import java.util.*;

public class numGame implements GameWriteable {
    int guesses;
    int numToGuess;
    ArrayList<Integer> prevGuess = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public numGame(int low, int high, boolean me) {
        guesses = 0;
        numToGuess = rand.nextInt(high - low + 1) + low;

        System.out.println("I'm thinking of a number from " + low + " to " + high);
    }

    @Override
    public void play() {
        while (true) {
            int guess = getGuess();

            if (prevGuess.contains(guess)) {
                System.out.println("You already guessed that!");
                continue;
            }

            prevGuess.add(guess);
            guesses++;

            if (guess == numToGuess) {
                System.out.println("Correct!");
                System.out.println("You guessed " + guesses + " times!");
                break;
            } 
            else if (guess > numToGuess) {
                System.out.println("Too high!");
            } 
            else {
                System.out.println("Too low!");
            }
        }
    }

    int getGuess() {
        System.out.print("Enter guess: ");
        return sc.nextInt();
    }

    int getNumGuesses() {
        return guesses;
    }

    @Override
    public boolean isHighScore(String score, String currentHighScore) {
        if (currentHighScore == null) return true;

        int newScore = Integer.parseInt(score);
        int oldScore = Integer.parseInt(currentHighScore);

        // LOWER is better
        return newScore < oldScore;
    }

    @Override
    public String getGameName() {
        return "NumberGuessGame";
    }

    @Override
    public String getScore() {
        return String.valueOf(guesses);
    }
}