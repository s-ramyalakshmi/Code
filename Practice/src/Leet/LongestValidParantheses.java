package Leet;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ramyalakshmi.s created on 2020-08-13
 */
public class LongestValidParantheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if(!stack.isEmpty())
                    count = Math.max(count, i-stack.peek());
                else
                    stack.push(i);
            }
        }
        return count;
    }
}
