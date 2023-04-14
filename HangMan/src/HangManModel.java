import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class HangManModel {
    private Scanner fin = new Scanner(new File("F:\\Facultate\\POO\\HangMan\\resources\\words.txt"));
    private List<String> words = new ArrayList<>();
    private Integer mistakes;
    private Integer guessedNo;
    private Boolean[] guessed;

    HangManModel() throws FileNotFoundException {
        while(fin.hasNext()){
            this.words.add(fin.nextLine());
        }
        Boolean[] aux = new Boolean[words.size()];
        this.guessed = aux;
        reset();
    }

    public void reset() {
        this.mistakes = 0;
        this.guessedNo = 0;
        for(int i = 0; i < words.size(); i++){
            guessed[i] = false;
        }

    }

    public String randomWord(){
        int value;
        Random rand = new Random();

        do {
            value = rand.nextInt(words.size());
        } while (guessed[value].equals(true));

        return words.get(value);
    }

    public boolean check(String input, String searchFor) {
        Boolean result = input.equalsIgnoreCase(searchFor);

        if(result.equals(true)) {
            this.guessed[words.indexOf(searchFor)] = true;
            this.guessedNo++;
        }
        else
            this.mistakes++;

        return result;
    }

    public Integer getGuessedNo() {
        return this.guessedNo;
    }

    public Integer getMistakes(){
        return this.mistakes;
    }

    public Integer getWordsNumber(){
        return this.words.size();
    }
}
