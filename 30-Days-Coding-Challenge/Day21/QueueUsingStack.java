
// 232. Implement Queue using Stacks ( Easy )
// Question Link - https://leetcode.com/problems/implement-queue-using-stacks/description/
// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty). Implement the MyQueue class: void push(int x) Pushes element x to the back of the queue. int pop() Removes the element from the front of the queue and returns it. int peek() Returns the element at the front of the queue. boolean empty() Returns true if the queue is empty, false otherwise.

import java.util.Stack;

public class QueueUsingStack {

    private final Stack<Integer> s1;
    private final Stack<Integer> helper;
    private int front;

    public QueueUsingStack() {
        this.s1 = new Stack<>();
        this.helper = new Stack<>();
    }

    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        while (!s1.isEmpty()) {
            helper.push(s1.pop());
        }
        helper.push(x);

        while (!helper.isEmpty()) {
            s1.push(helper.pop());
        }
    }

    public int pop() {
        int res = s1.pop();
        if (!s1.empty())
            front = s1.peek();
        return res;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return s1.isEmpty();
    }

    public Stack<Integer> getHelper() {
        return helper;
    }

}
