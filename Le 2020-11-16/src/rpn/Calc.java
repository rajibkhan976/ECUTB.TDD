package rpn;

import java.util.Stack;

public class Calc {

    private Stack<Double> stack;
    private IWordProvider provider;

    public Calc() {

        stack = new Stack<Double>();
    }

    public Calc(IWordProvider provider) {

        this.provider = provider;
        stack = new Stack<Double>();
    }

    String[] getWords(String strExpr) {

        return strExpr.split(" ");
    }

    public Double compute(String strExpr) throws ExpressionException {

        if (strExpr == null) {
            throw new ExpressionException("Kan inte vara null.");
        }

        if (strExpr == "") {
            throw new ExpressionException("Kan inte vara tom");
        }

        stack.clear();

        String[] words = getWords(strExpr);

        for (int i = 0; i < words.length; i++) {
            _compute(words[i]);
        }

        return stack.pop();
    }
    
    public Double compute() throws ExpressionException {

        stack.clear();
        while (provider.hasMore()) {
            String word = provider.nextWord();
            _compute(word);

        }

        return stack.pop();
    }    

    private void _compute(String word) throws ExpressionException {

        switch (word) {
        case "*":
            if (stack.size() >= 2) {
                stack.push(stack.pop() * stack.pop());
            } else {
                throw new ExpressionException("Det saknas operander!");
            }
            break;

        case "-":
            if (stack.size() >= 2) {
                stack.push(stack.pop() - stack.pop());
            } else {
                throw new ExpressionException("Det saknas operander!");
            }
            break;

        case "+":
            if (stack.size() >= 2) {
                stack.push(stack.pop() + stack.pop());
            } else {
                throw new ExpressionException("Det saknas operander!");
            }
            break;

        case "/":
            if (stack.size() >= 2) {
                stack.push(stack.pop() / stack.pop());
            } else {
                throw new ExpressionException("Det saknas operander!");
            }
            break;

        case "sqrt":
            if (stack.size() >= 1) {
                stack.push(Math.sqrt(stack.pop()));
            } else {
                throw new ExpressionException("Det saknas en operand!");
            }
            break;

        case "sqr":
            if (stack.size() >= 1) {
                stack.push(Math.pow(stack.pop(), 2));
            } else {
                throw new ExpressionException("Det saknas en operand!");
            }
            break;

        default:
            try {

                Double dbl = Double.parseDouble(word);
                stack.push(dbl);

            } catch (NumberFormatException e) {
                throw new ExpressionException("�r inte ett tal eller en otill�ten operator.");
            }

            break;
        }
    }

}
