package org.example;

//driver
public class DishStack {
    private static final int MAX_SIZE = 10;
    private Dish[] stack;
    private int top;

    public DishStack() {
        stack = new Dish[MAX_SIZE];
        top = -1;
    }

    // Push a Dish object onto the stack
    public void push(Dish dish) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack is full! Cannot push: " + dish.description);
            return;
        }
        stack[++top] = dish;
    }

    // Pop a Dish off the top of the stack
    public Dish pop() {
        if (top == -1) {
            System.out.println("Stack is empty! Nothing to pop.");
            return null;
        }
        Dish popped = stack[top];
        stack[top--] = null; // clear reference and move top down
        return popped;
    }

    // Peek at the top Dish without removing it
    public Dish peek() {
        if (top == -1) {
            System.out.println("Stack is empty! Nothing to peek at.");
            return null;
        }
        return stack[top];
    }

    // Return the current number of elements in the stack
    public int size() {
        return top + 1;
    }
}


