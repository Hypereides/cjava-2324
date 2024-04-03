import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class RPNGui {
    private JTextField display;
    private Stack<Double> stack;

    public RPNGui() {
        stack = new Stack<>();
        JFrame frame = new JFrame("RPN Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        display = new JTextField();
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4));

        for (int i = 0; i <= 9; i++) {
            buttonsPanel.add(new NumberButton(i, display));
        }

        buttonsPanel.add(new OperatorButton("+", display, stack));
        buttonsPanel.add(new OperatorButton("-", display, stack));
        buttonsPanel.add(new OperatorButton("*", display, stack));
        buttonsPanel.add(new OperatorButton("/", display, stack));

        frame.add(buttonsPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new RPNGui();
    }
}