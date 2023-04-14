import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Character.isLetter;

public class HangManView extends JFrame {
    static final String[] messages = {"", "GAME OVER", "CONGRATULATIONS, YOU WON!", "WRONG", "CORRECT"};
    private JLabel word = new JLabel();
    private String searchFor = new String();
    private JTextField userInput = new JTextField(25);
    private JButton enterButton = new JButton("Check");
    private JButton restartButton = new JButton("Restart");
    private JLabel msg= new JLabel();
    private JLabel img = new JLabel();
    private JPanel image = new JPanel();
    private HangManModel model;

    HangManView(HangManModel model){
        JPanel buttons = new JPanel();
        JPanel content = new JPanel();
        JPanel words = new JPanel();
        JLabel l1 = new JLabel("Word we looking for: ");
        JLabel l2 = new JLabel("Your guess: ");

        this.model = model;

        img.setIcon(new ImageIcon("F:\\Facultate\\POO\\HangMan\\resources\\0.png"));
        image.add(img);

        words.add(l1);
        words.add(l2);
        this.word.setText(toString(model.randomWord()));
        words.add(word);
        words.add(userInput);
        words.setLayout(new GridLayout(0, 2));

        msg.setText(messages[0]);

        buttons.add(restartButton);
        buttons.add(enterButton);
        buttons.setLayout(new FlowLayout());

        content.add(image);
        content.add(msg);
        content.add(words);
        content.add(buttons);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        this.setContentPane(content);
        this.pack();
        this.setTitle("Hang Man");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setWord(String word) {
        this.word.setText(word);
    }

    public String getSearchFor(){
        return this.searchFor;
    }

    public String getUserInput() {
        return this.userInput.getText();
    }

    public void addInputListener(ActionListener click){
        this.enterButton.addActionListener(click);
    }

    public void addResetListener(ActionListener click) {
        this.restartButton.addActionListener(click);
    }

    public String toString(String word){
        this.searchFor = word;
        String buffer = new String();
        buffer = String.valueOf(word.charAt(0));
        for(int i = 1; i < word.length() - 1; i++){
            if(isLetter(word.charAt(i))){
                buffer = buffer + "_";
            }
            else
                buffer = buffer + word.charAt(i);
            buffer = buffer + " ";
        }

        return buffer + word.charAt(word.length() - 1);
    }

    public void fillLetter(String word){
        if(word.length() == 1){
            String buffer = this.word.getText();
            Character c = word.charAt(0);
            for(Integer i = 0; this.searchFor.equals(i); i++){
                if(c.compareTo(searchFor.charAt(i)) == 0){

                }
            }
        }
    }

    public void setImg(int number){
        this.img.setIcon(new ImageIcon("F:\\Facultate\\POO\\HangMan\\resources\\" + number + ".png"));
    }

    public void reset(){
        this.img.setIcon(new ImageIcon("F:\\Facultate\\POO\\HangMan\\resources\\0.png"));
        this.word.setText(toString(this.model.randomWord()));
        this.msg.setText(messages[0]);
    }

    public void setMsg(Integer msg) {
        this.msg.setText(messages[msg]);
    }
}
