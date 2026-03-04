//import java.util.Queue;

import java.util.Arrays;

public class CalculatePostfix {
    public static Double postfixToResult(Queue<Object> tokens) {
        Stack<Double> answer = new Stack<Double>();

        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("Empty queue");
        }

        while (tokens.size() > 0) {
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
    }
}