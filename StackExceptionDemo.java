// Custom Exception for Stack Overflow
class StackOverflowException extends Exception {
    public StackOverflowException(String message) {
        super(message);
    }
}

// Custom Exception for Stack Underflow
class StackUnderflowException extends Exception {
    public StackUnderflowException(String message) {
        super(message);
    }
}

// Stack Implementation
class Stack {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor
    public Stack(int size) {
        this.capacity = size;
        this.stack = new int[size];
        this.top = -1;
    }

    // Push operation
    public void push(int item) throws StackOverflowException {
        if (top == capacity - 1) {
            throw new StackOverflowException("Stack Overflow! Cannot push " + item);
        }
        stack[++top] = item;
        System.out.println("Pushed: " + item);
    }

    // Pop operation
    public int pop() throws StackUnderflowException {
        if (top == -1) {
            throw new StackUnderflowException("Stack Underflow! No elements to pop.");
        }
        int item = stack[top--];
        System.out.println("Popped: " + item);
        return item;
    }

    // Display stack elements
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

// Main class
public class StackExceptionDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(3);

        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.display();

            // Uncomment to test stack overflow
            // stack.push(40);

            stack.pop();
            stack.pop();
            stack.pop();

            // Uncomment to test stack underflow
            // stack.pop();

        } catch (StackOverflowException | StackUnderflowException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
