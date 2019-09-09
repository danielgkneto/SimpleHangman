import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] wordsList = new String[] {"tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance", "pancakes", "stream"};
        String selectedWord = wordsList[new Random().nextInt(10)];
        char[] currentGuesses = new char[selectedWord.length()];
        Scanner kb = new Scanner(System.in);
        String guess;
        boolean success = false;
        boolean gameOver = false;
        int guessesLeft = 5;

        Arrays.fill(currentGuesses, '_');

        System.out.println("\nWelcome, let's play hangman!");
        System.out.print("\nHere is the word I'm thinking of: ");
        for (int i = 0; i < currentGuesses.length; i++)
            System.out.print(" " + currentGuesses[i]);

        while (!gameOver) {
            System.out.println("\nEnter you guess: ");
            guess = kb.nextLine();

            if (guess.length() > 1) {
                gameOver = true;
                if (guess.equals(selectedWord))
                    success = true;
            }
            else {
                if (selectedWord.indexOf(guess.charAt(0)) == -1) {
                    guessesLeft--;
                    System.out.print("You have guessed incorrectly " + (5 - guessesLeft) + "/5");
                }
                else {
                    for (int i = 0; i < selectedWord.length(); i++)
                        currentGuesses[i] = (guess.charAt(0) == selectedWord.charAt(i)) ? selectedWord.charAt(i) : currentGuesses[i];
                }

                System.out.println("\nYour guess so far: ");
                success = true;
                for (int i = 0; i < currentGuesses.length; i++){
                    System.out.print(" " + currentGuesses[i]);
                    if (currentGuesses[i] == '_')
                        success = false;
                }
                if (guessesLeft == 0)
                    gameOver = true;
            }
        }

        if (success)
            System.out.print("\nYou've won! The word was: " + selectedWord);
        else
            System.out.print("\nYou've lost! The word was: " + selectedWord);

        System.out.print("\nThank for playing.");
    }
}
