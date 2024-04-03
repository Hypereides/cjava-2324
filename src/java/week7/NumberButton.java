import javax.swing.*;

public class NumberButton extends JButton {
    public NumberButton(int number, JTextField display) {
        super(String.valueOf(number));
        addActionListener(e -> display.setText(display.getText() + number));
    }
}