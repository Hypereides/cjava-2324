import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class OperatorButton extends JButton {
    public OperatorButton(String operator, JTextField display, Stack<Double> stack) {
        super(operator);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double secondOperand = Double.parseDouble(display.getText());
                stack.push(secondOperand);
                display.setText("");

                if (stack.size() >= 2) {
                    double firstOperand = stack.pop();
                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = firstOperand + stack.pop();
                            break;
                        case "-":
                            result = firstOperand - stack.pop();
                            break;
                        case "*":
                            result = firstOperand * stack.pop();
                            break;
                        case "/":
                            result = firstOperand / stack.pop();
                            break;
                    }

                    display.setText(String.valueOf(result));
                    stack.push(result);
                }
            }
        });
    }
}