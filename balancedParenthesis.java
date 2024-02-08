import java.util.*;

public class balancedParenthesis {

    public boolean isValid(String s) {
        Stack<Character> myStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                myStack.push(c);
            } else {
                if (myStack.isEmpty()) {
                    return false;
                }

                char top = myStack.pop();

                // it corresponds to the most recent opening parenthesis
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        balancedParenthesis bp = new balancedParenthesis();

        // Test cases to verify the solution
        String test1 = "{[()]}";
        String test2 = "{[}]";
        String test3 = "(]";

        System.out.println("Test 1: " + bp.isValid(test1));
        System.out.println("Test 2: " + bp.isValid(test2));
        System.out.println("Test 3: " + bp.isValid(test3));
    }
}

// In this code, the isValid function cheeks if a given string of parenthesis s is balanced by using a stack.
// It pushed any openinig parenthesis onto the stack and pops off from the stack whenever a closing parenthesis is encountered.
// If the stack is empty even after pushing, return false, coz we didn't push anything
// If the stack is empty at the end, the string is balanced.

// Time Complexity: O(n), where n is the length of the string. This is because we are processing each character in the stirng exactly once.
// Space Complexity: O(N), in the worst case scenario, when all the characters in the stirng are opening characters, so we push each character onto the stack. 
// In the average case, however the space complexity would be less than O(n), coz we would push only few opening characters when we have less opening characters than more closing characters. 