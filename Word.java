import java.util.*;

public class Word {
    private String word;
    private List<String> letters;
    private int length;
    private String clue;

    private final int FIRST_ON_LIST = 0;
    private final int SECOND_ON_LIST = 1;

    public Word (String wordAndClue) {
        this.letters = new ArrayList<String>();
        exctractWordAndClue(wordAndClue);
        extractLetters(word);
        this.length = letters.size();
    }

    public String getWord() {
        return this.word;
    }

    public List<String> getLetters() {
        return this.letters;
    }

    public int getLength() {
        return this.length;
    }

    public String getClue() {
        return this.clue;
    }

    private void exctractWordAndClue(String wordAndClue) {
        String[] output = wordAndClue.split("\\|");
        this.word = output[SECOND_ON_LIST].trim().toUpperCase();
        this.clue = output[FIRST_ON_LIST].trim();
    }

    private void extractLetters(String word) {
        String [] arr = word.toUpperCase().split("");

        for (int i = 0; i < arr.length; i++) {
            this.letters.add(arr[i]);
        }
    }
}