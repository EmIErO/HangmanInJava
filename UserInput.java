import java.util.*;

public class UserInput {
    private Scanner reader;
    private String currentInput;

    private final List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", 
                                                        "m", "n", "o", "p", "r", "s", "t", "u", "v", "w", "q", "x", "y", "z");

    public UserInput() {
        this.reader = new Scanner(System.in);
    }

    public Scanner getReader() {
        return this.reader;
    }

    public String getCurrentInput() {
        return this.currentInput;
    }

    public void validate(String input) {
        if (this.alphabet.contains(input)) {
            this.currentInput = input.toUpperCase();
        } else {
            this.currentInput = input;
        }
    }
}

