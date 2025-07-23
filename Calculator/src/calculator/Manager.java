package calculator;
import java.util.*;

public class Manager {
    private List<String> tokens = new ArrayList<>();
    private Hashtable<String, Integer> precedence = new Hashtable<>();

    public Manager() {
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
        precedence.put("^", 3);
        precedence.put("sqrt", 4);
        precedence.put("cbrt", 4);
        precedence.put("%", 2);
    }
    public List<String> getTokens() {
        return this.tokens;
    }
    private boolean isNumber(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");
    }

    public void add_number(int number) {
        if (!tokens.isEmpty() && isNumber(tokens.get(tokens.size() - 1))) {
            // It's a number → append digit
            int lastIndex = tokens.size() - 1;
            String updated = tokens.get(lastIndex) + Integer.toString(number);
            tokens.set(lastIndex, updated);
        } else {
            // It's not a number → add new token
            this.tokens.add(Integer.toString(number));
        }
    }
    public void add_number(String s) {
        if (!tokens.isEmpty() && isNumber(tokens.get(tokens.size() - 1))) {
            String last = tokens.get(tokens.size() - 1);
            // Prevent multiple dots in one number
            if (s.equals(".") && last.contains(".")) return;

            tokens.set(tokens.size() - 1, last + s);
        } else {
            // Only allow dot if it starts like "0."
            if (s.equals(".")) tokens.add("0.");
            else tokens.add(s);
        }
    }

    public void add_operator(String operator) {
        this.tokens.add(operator);
    }

    public void back() {
        if (!this.tokens.isEmpty()) this.tokens.remove(tokens.size() - 1);
    }

    public String calculate() {
        if (tokens.isEmpty()) {return "0";}
        double output = this.evaluatePostfix(this.toPostfix(tokens));
        tokens.clear();
        tokens.add(Double.toString(output));
        return Double.toString(output);
    }
    public List<String> toPostfix(List<String> infix) {
        Stack<String> opStack = new Stack<>();
        List<String> output = new ArrayList<>();

        for (int i = 0; i < infix.size(); i++) {
            String s = infix.get(i);

            // --- Detect unary minus and convert to negative number ---
            if (s.equals("-")) {
                boolean isUnary = (i == 0) || (
                        infix.get(i - 1).equals("(") ||
                                precedence.containsKey(infix.get(i - 1))
                );

                if (isUnary && i + 1 < infix.size() && isNumber(infix.get(i + 1))) {
                    String neg = "-" + infix.get(i + 1);
                    infix.set(i + 1, neg);
                    continue; // skip the "-" token
                }
            }

            if (isNumber(s)) {
                output.add(s);
            } else if (s.equals("(")) {
                opStack.push(s);
            } else if (s.equals(")")) {
                while (!opStack.isEmpty() && !opStack.peek().equals("(")) {
                    output.add(opStack.pop());
                }
                if (!opStack.isEmpty() && opStack.peek().equals("(")) {
                    opStack.pop(); // discard "("
                }
            } else if (precedence.containsKey(s)) {
                while (!opStack.isEmpty() &&
                        !opStack.peek().equals("(") &&
                        precedence.get(opStack.peek()) >= precedence.get(s)) {
                    output.add(opStack.pop());
                }
                opStack.push(s);
            }
        }

        while (!opStack.isEmpty()) {
            output.add(opStack.pop());
        }

        return output;
    }

    public double evaluatePostfix(List<String> postfix) {
        Stack<Double> output = new Stack<>();
        for(String s : postfix) {
            if (isNumber(s)) {
                output.push(Double.valueOf(s));
            }
            else if (s.equals("%")) {
                double b = output.pop();
                double a = output.pop();
                output.push(a % b);
            }
            else {
                if (s.equals("sqrt") || s.equals("cbrt")) {
                    double a = output.pop();
                    if (s.equals("sqrt"))
                        output.push( Math.sqrt(a));
                    else
                        output.push(Math.cbrt(a));
                } else {
                    double b = output.pop();
                    double a = output.pop();
                    switch (s) {
                        case "+": output.push((a + b)); break;
                        case "-": output.push((a - b)); break;
                        case "*": output.push((a * b)); break;
                        case "/": output.push((a / b)); break;
                        case "^": output.push(Math.pow(a, b)); break;
                    }
                }
            }

        }
        return output.pop();
    }
}
