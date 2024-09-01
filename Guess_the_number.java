import java.awt.Color;
import javax.swing.*;

public class Guess_the_number {
    JFrame jframe;
    JLabel label, result, imLabel;
    JTextField input;
    JButton submit, check, Try_Again, exit;
    int randNo;
    ImageIcon img;

    public Guess_the_number() {
        jframe = new JFrame("Guess The Number?");
        jframe.getContentPane().setBackground(new Color(0xadd9e6));
        img = new ImageIcon("im.jpg");
        imLabel = new JLabel(img);
        imLabel.setBounds(110, 20, 380, 200);

        label = new JLabel("Hi, May i know your name please.", SwingConstants.CENTER);
        label.setBounds(90, 240, 400, 20);

        input = new JTextField();
        input.setBounds(220, 270, 120, 20);

        submit = new JButton("Submit");
        submit.setBounds(240, 300, 80, 20);

        check = new JButton("Guess");
        check.setBounds(240, 420, 80, 20);

        Try_Again = new JButton("Try Again");
        Try_Again.setBounds(180, 480, 100, 20);

        exit = new JButton("Exit");
        exit.setBounds(310, 480, 80, 20);

        result = new JLabel("", SwingConstants.CENTER);
        result.setBounds(110, 440, 400, 20);

        randNo = (int) (Math.random() * 100);

        submit.addActionListener(e -> {
            label.setBounds(90, 240, 400, 110);
            label.setText("<html>Hi " + input.getText()
                    + ",<p style=\"font-size: medium;font-family: 'Times New Roman', Times, serif\"> <br/>I have chosen a random number lying between 0 to 100<br/>Can you guess what it is? 🤔🤔</p></html>");
            input.setText("");
            input.setBounds(220, 370, 120, 20);
            jframe.add(check);
            jframe.remove(submit);
            jframe.repaint();
        });

        check.addActionListener(e -> {
            try {
                int userGuess = Integer.parseInt(input.getText());
                if (userGuess == randNo) {
                    result.setText("Hurray! You guessed it right. You are a winner!!");
                } else if (userGuess > randNo) {
                    result.setText("Oops! Your guess is too high!!. No need to worry. Try Again.");
                } else {
                    result.setText("Oops! Your guess is too low!!. No need to worry. Try Again.");
                }
            } catch (NumberFormatException a) {
                result.setText("Please enter a valid number between 0 and 100.");
            }
            jframe.add(result);
            jframe.add(Try_Again);
            jframe.add(exit);
            jframe.remove(check);
            jframe.repaint();

        });

        Try_Again.addActionListener(e -> {
            input.setText("");
            jframe.remove(result);
            jframe.remove(exit);
            jframe.add(check);
            jframe.remove(Try_Again);
            jframe.repaint();
        });

        exit.addActionListener(e -> {
            JOptionPane.showMessageDialog(jframe, "Thankyou! for playing.");
            System.exit(0);
        });

        jframe.add(imLabel);
        jframe.add(submit);
        jframe.add(input);
        jframe.add(label);
        jframe.setLayout(null);
        jframe.setSize(600, 600);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Guess_the_number();
    }
}