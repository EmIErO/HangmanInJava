import java.util.*;
import java.lang.*;

public class Player {
    public static final int CHANCES = 10;

    private Word wordToGuess;
    private int numOfGuesses;
    private int numOfCoveredLetters;
    private List<String> guessedLetters;

    private final int WRONG_WORD = 2;
    private final List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", 
                                                        "m", "n", "o", "p", "r", "s", "t", "u", "v", "w", "q", "x", "y", "z",
                                                        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
                                                        "M", "N", "O", "P", "R", "S", "T", "U", "V", "W", "Q", "X", "Y", "Z", " ");


    public Player(String wordAndClue) {
        this.wordToGuess = new Word(wordAndClue);
        this.numOfGuesses = 0;
        this.numOfCoveredLetters = -1;
        this.guessedLetters = new ArrayList<String>();
    }

    public Word getWordToGuess() {
        return this.wordToGuess;
    }

    public int getNumOfGuesses() {
        return this.numOfGuesses;
    }

    public int getNumOfCoveredLetters() {
        return this.numOfCoveredLetters;
    } 

    public void setGuessedLetters(List<String> letters) {
        this.guessedLetters = letters;
    }

    public int getNumOfGuessesForDisplay() {
        return this.numOfGuesses + 1;
    }

    public void addGuessedLetter(String letter) {
        
        if (isInWord(letter)) {
            this.guessedLetters.add(letter);
        } else {
            this.numOfGuesses++;
            return;
        }
    }

    public void markWhiteSpaces() {
        if (isInWord(" ")) {
            this.guessedLetters.add(" ");
        } else {
            return;
        }
    }

    public boolean compareWords(String word) {
        if (word.length() == this.wordToGuess.getLength()) {
            String [] arr = word.split("");
            for (int i = 0; i < word.length(); i++) {

                if (!this.alphabet.contains(arr[i])) {
                    numOfGuesses += WRONG_WORD;
                    return false;
                }

                if (wordToGuess.getLetters().get(i).equals(arr[i].toUpperCase())) {
                    continue;
                    
                } else {
                    numOfGuesses += WRONG_WORD;
                    return false;
                }
            }
            return true;
        } 
        numOfGuesses += WRONG_WORD;
        return false;
    }
     
    public boolean hasGuessesLeft() {
        return this.numOfGuesses < CHANCES;
    }

    public void printClue(){
        if (this.numOfGuesses == (CHANCES - 1)) {
            System.out.println("\n\tCapital of: " + this.wordToGuess.getClue());
        } else {
            return;
        }
    }

    public void printWordToGuess() {
        for (String letter: this.wordToGuess.getLetters()) {
            if (isInGuessedLetters(letter)) {
                System.out.print(letter);
            } else {
                System.out.print("*");
            }
        }
        System.out.print("\n");
    }

    public void countCoveredLetters() {
        this.numOfCoveredLetters = 0;
        for (String letter: this.wordToGuess.getLetters()) {
            if (!isInGuessedLetters(letter)) {
                 numOfCoveredLetters++; 
            }
        }
        System.out.print("\n");
    }

    private boolean isInWord(String letter) {
        for (String correctLetter: this.wordToGuess.getLetters()) {
            if (letter.equals(correctLetter)) {
                return true;
            } 
        }
        return false;
    }

    private boolean isInGuessedLetters(String letter) {
        for (String correctLetter: this.guessedLetters) {
            if (letter.equals(correctLetter)) {
                return true;
            }
        }
        return false;
    }

}