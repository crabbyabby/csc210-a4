/**
 * Class that calculates value from Postfix
 * @author Abigail Lei
 * @version Spring 2026
 */
public class CalculatePostfix {
    
    /**
     * Method that calculates value from queue of postfix
     * @param tokens queue holding equation in postfix
     * @return Double of equation result
     * @throws IllegalArgumentException if multiple numbers in stack at end
     */
    public static Double postfixToResult(Queue<Object> tokens) {
        Stack<Double> answer = new Stack<Double>();

        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("Empty queue");
        }

        while (!tokens.isEmpty()) {
            Object next = tokens.dequeue();
            if (next instanceof Double) {
                Double numValue = Double.valueOf(next.toString());
                answer.push(numValue);
            } else if (next instanceof Character) {
                Double second = answer.pop();
                Double first = answer.pop();
                Double newNumber = compute(first, second, (Character) next);
                answer.push(newNumber);
            }
        }

        if (answer.size() > 1) {
            throw new IllegalArgumentException("Multiple numbers remaining");
        }

        return answer.pop();
    }

    /**
     * Helper method that computes small expressions
     * @param first Double in equation
     * @param second Double in equation
     * @param change Character operator used in equation
     * @return Double of the answer outputted
     * @throws IllegalArgumentException if there is division by 0
     * @throws IllegalArgumentException if there is an unknown character
     */
    public static Double compute(Double first, Double second, Character change) {

        if (change == '+') {
            return first + second;
        } else if (change == '-') {
            return first - second;
        } else if (change == '*') {
            return first * second;
        } else if (change == '/') {
            if (second == 0) {
                throw new IllegalArgumentException("Cannot divide by 0");
            } else {
                return first / second;
            }
        } else {
            throw new IllegalArgumentException("Unknown operator");
        }
    }

    public static void main(String args[]){
        // Use the main method to make your code run from the command line

        // Here's how to print the equation passed from the command line:
        // System.out.println(args[0]);
        // You will want to pass this to the Tokenizer class to parse
            if (args.length != 1) {
                System.err.println("Usage: java CalculatePostfix \"<postfix expr>\"");
                return;
            }
            Queue<Object> tokens = Tokenizer.readTokens(args[0]);
            Double result = postfixToResult(tokens);
            System.out.println("Answer: " + result);
    }
}
