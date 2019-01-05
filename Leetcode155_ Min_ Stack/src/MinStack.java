import javafx.beans.binding.When;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> normalStack;
    private Stack<Integer> minStack;

    public MinStack() {
            normalStack = new Stack<>();
            minStack = new Stack<>();
        }

    public void push(int x) {
           normalStack.push(x);
           if (minStack.empty() || x <= minStack.peek())
               minStack.push(x);
        }

    public void pop() {
           if (normalStack.isEmpty()) return;
           if (minStack.peek().equals(normalStack.pop())) minStack.pop();
        }

    public int top() { return normalStack.peek(); }

    public int getMin() { return minStack.peek();}

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
