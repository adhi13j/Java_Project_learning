import javax.swing.*;
import calculator.Manager;

public class Calculator {
    private JButton a3Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton plus;
    private JButton minus;
    private JButton remind;
    private JButton divide;
    private JButton multiply;
    private JButton power;
    private JButton a0Button;
    private JButton calculate;
    private JPanel root;
    private JButton back;
    private JButton open;
    private JButton close;
    private JButton sqrt;
    private JButton cbrt;
    private JPanel Output;
    private JLabel outputText;
    private JButton decimal;

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(calculator.root); // Important
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        Manager m = new Manager();
        String answer = m.calculate() ;

        // Digits
        calculator.a0Button.addActionListener(e -> {
            m.add_number(0);
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.a1Button.addActionListener(e -> {
            m.add_number(1);
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.a2Button.addActionListener(e -> {
            m.add_number(2);
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.a3Button.addActionListener(e -> {
            m.add_number(3);
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.a4Button.addActionListener(e -> {
            m.add_number(4);
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.a5Button.addActionListener(e -> {
            m.add_number(5);
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.a6Button.addActionListener(e -> {
            m.add_number(6);
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.a7Button.addActionListener(e -> {
            m.add_number(7);
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.a8Button.addActionListener(e -> {
            m.add_number(8);
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.a9Button.addActionListener(e -> {
            m.add_number(9);
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });

// Operators
        calculator.plus.addActionListener(e -> {
            m.add_operator("+");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.minus.addActionListener(e -> {
            m.add_operator("-");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.multiply.addActionListener(e -> {
            m.add_operator("*");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.divide.addActionListener(e -> {
            m.add_operator("/");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.power.addActionListener(e -> {
            m.add_operator("^");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.sqrt.addActionListener(e -> {
            m.add_operator("sqrt");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.cbrt.addActionListener(e -> {
            m.add_operator("cbrt");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.open.addActionListener(e -> {
            m.add_operator("(");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.close.addActionListener(e -> {
            m.add_operator(")");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });

// Backspace
        calculator.back.addActionListener(e -> {
            m.back();
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });

// Calculate and show result
        calculator.calculate.addActionListener(e -> {
            String result = m.calculate();
            calculator.outputText.setText(result);
        });
        calculator.decimal.addActionListener(e -> {
            m.add_number(".");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });
        calculator.remind.addActionListener(e -> {
            m.add_operator("%");
            calculator.outputText.setText(String.join(" ", m.getTokens()));
        });


    }
}
