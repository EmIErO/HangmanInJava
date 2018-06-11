import java.util.*;
import java.lang.*;

public class Hangman {

    private WordsToGuess wordsToGuess;
    private Player player;
    private UserInput input;

    private boolean isRunning;

    public static void main(String[] args) {
        Hangman hangman = new Hangman("countries_and_capitals.txt");
        hangman.run();
    }

    public Hangman(String fileName) {
        this.wordsToGuess = new WordsToGuess(fileName);
        this.input = new UserInput();
        this.isRunning = true;
    }

    private void run() {
        while (isRunning) {
            printMenu();
            input.validate(this.input.getReader().nextLine());
            handleMenu();
        }
    }

    private void printMenu() {
        System.out.println("\n1. New game \n");
        System.out.println("2. Exit \n");        
    }

    private void handleMenu() {
        switch (this.input.getCurrentInput()) {
                case "1":
                    newGame();
                    break;
                case "2":
                    isRunning = false;
                    break;
        }
    }

    private void newGame() {
        this.player = new Player(this.wordsToGuess.getWord());
        this.player.markWhiteSpaces();
        while (player.hasGuessesLeft() && (player.getNumOfCoveredLetters() != 0)) {

            System.out.println("Cheat: " + player.getWordToGuess().getWord());

            player.printWordToGuess();
            System.out.println("\nInsert letter/word: \n");
            updateWordToGuess(this.input.getReader().nextLine());
            player.printClue();
            checkIfWon();
            
        }
    }

    private void checkIfWon() {
        player.countCoveredLetters();

        if (this.player.getNumOfCoveredLetters() == 0) {
            System.out.println(player.getWordToGuess().getWord() + "\n");
            System.out.println("\nYOU WON!!! \n");
        } else if (!player.hasGuessesLeft()) {
            System.out.println("\nYOU LOST!!! \n"); 
            System.out.println("The answer was: " + player.getWordToGuess().getWord() + "\n");           
        } else return;
    }

    public void updateWordToGuess(String string) {
        if (string.length() == 1) {
            input.validate(string);
            this.player.addGuessedLetter(this.input.getCurrentInput());

        } else if (string.length() == 0) {
            return;

        } else {

            if (this.player.compareWords(string)) {
                this.player.setGuessedLetters(this.player.getWordToGuess().getLetters());
            }
        }
    }
}