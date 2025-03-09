package pt.com;

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static class MyStack {
        private final int maxSize;
        private final int[] stack;
        private int top = -1;

        public MyStack(int maxSize) {
            this.maxSize = maxSize;
            stack = new int[maxSize];
        }

        public void push(int value) {
            if (top == (maxSize - 1)) {
                System.out.println("Stack is full");
            } else {
                top++;
                stack[top] = value;
            }
        }

        public Integer pop() {
            Integer response = null;

            if (top >= 0) {
                response = stack[top];
                stack[top] = 0;
                top--;
            } else {
                System.out.println("Stack is empty");
            }

            return response;
        }
    }
}