package V0;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons =  new JButton[10];
    JButton[] actionButtons = new JButton[9];
    JButton sumButton, subButton, divButton, mulButton;
    JButton dcButton , eqButton, dlButton , clsButton, enterButton;
    JPanel panel;
    Font myFont = new Font("Helvetica", Font.BOLD, 40);
    Stack<String> stack = new Stack<String>();
    int frameWidth = 420;
    int textFieldWidth = 300;
    int xPosition = (frameWidth - textFieldWidth) / 2;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 600);
        frame.setLayout(null);
        frame.setResizable(false);
        
        textField = new JTextField();
        textField.setBounds(xPosition, 30, textFieldWidth, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        
        sumButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("*");
        dcButton = new JButton(".");
        eqButton = new JButton("=");
        dlButton = new JButton("DEL");
        clsButton = new JButton("C");
        enterButton = new JButton("Enter");
        
        actionButtons[0] = sumButton;
        actionButtons[1] = subButton;
        actionButtons[2] = divButton;
        actionButtons[3] = mulButton;
        actionButtons[4] = dcButton;    
        actionButtons[5] = eqButton;    
        actionButtons[6] = dlButton;    
        actionButtons[7] = clsButton;
        actionButtons[8] = enterButton;


        for(int i = 0; i<9; i++) {
            actionButtons[i].addActionListener(this);
            actionButtons[i].setFont(myFont);
            actionButtons[i].setFocusable(false);
        }

        for(int i =0; i<10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            
        }
        
        dlButton.setBounds(50,430,145,50);
        clsButton.setBounds(205,430,145,50);
        enterButton.setBounds(50, 500, 300, 50);
        
       
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.blue);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(sumButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(dcButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(dlButton);
        frame.add(clsButton);
        frame.add(enterButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();
    
        if (buttonText.equals("C")) {
            clearTextFieldAndStack();
        } else if (buttonText.equals("DEL")) {
            deleteLastCharacter();
        } else if (buttonText.equals("Enter")) {
            pushInputToStack();
        } else if (buttonText.equals("=")) {
            if (stack.size() >= 2) {
                performOperation();
            }
        } else if (buttonText.equals(".")) {
            appendToTextField(buttonText);
        } else {
            handleNumberOrOperator(buttonText);
        }
    }
    
    private void clearTextFieldAndStack() {
        textField.setText("");
        stack.clear();
    }
    
    private void deleteLastCharacter() {
        String text = textField.getText();
        if (!text.isEmpty()) {
            textField.setText(text.substring(0, text.length() - 1));
        }
    }
    
    private void pushInputToStack() {
        if (!textField.getText().isEmpty()) {
            stack.push(textField.getText());
            textField.setText("");
        }
    }
    private void appendToTextField(String text) {
        textField.setText(textField.getText() + text);
    }
    
    private void handleNumberOrOperator(String buttonText) {
        try {
            Double.parseDouble(buttonText);
            appendToTextField(buttonText);
        } catch (NumberFormatException ex) {
            // if parsing failed then it is an operator not a number
            if (stack.size() >= 2) {
                performOperation();
                stack.push(buttonText);
            }
        }
    }
    
    private void performOperation() {
        if (stack.size() < 3) {
            return;
        }
        String operator = stack.pop();
        double n2 = Double.parseDouble(stack.pop());
        double n1 = Double.parseDouble(stack.pop());
        switch (operator) {
            case "+":
                stack.push(String.valueOf(n1 + n2));
                break;
            case "-":
                stack.push(String.valueOf(n1 - n2));
                break;
            case "*":
                stack.push(String.valueOf(n1 * n2));
                break;
            case "/":
                if (n2 != 0) {
                    stack.push(String.valueOf(n1 / n2));
                } else {
                    // Handle division by zero
                    textField.setText("Error: Division by zero");
                }
                break;
        }
        textField.setText(stack.peek());
    }
}