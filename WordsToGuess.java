import java.util.*;
import java.io.*;

public class WordsToGuess {

    private List<String> wordsToGuess;
    private int listSize;

    public WordsToGuess(String fileName) {
        this.wordsToGuess = new ArrayList<String>();
        extractWords(fileName);
        this.listSize = wordsToGuess.size();
    }

    private void extractWords(String fileName) {
        String line = "";

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            
            while ((line = br.readLine()) != null){
                this.wordsToGuess.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(this.listSize);
    }

    public String getWord() {
        return this.wordsToGuess.get(getRandomNumber());
    }
}