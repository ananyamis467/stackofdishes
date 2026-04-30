package org.example;

//driver
public class App {
    public static void main(String[] args) {
        DishStack stack = new DishStack();
        Dish oneDish  = new Dish("A dish with one fish pattern on it");
        Dish twoDish  = new Dish("A dish with two fish patterns on it");
        Dish redDish  = new Dish("A dish with a red fish pattern on it");
        Dish blueDish = new Dish("A dish with a blue fish pattern on it");

        //Should be 0
        int stackSize = stack.size();
        System.out.println("Initial size: " + stackSize); 

        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        stack.push(blueDish);

        // Should be 4
        int sizeAfterPushes = stack.size();
        System.out.println("Size after pushes: " + sizeAfterPushes); 

        // Should be blueDish (not removed)
        Dish peekedDish = stack.peek();
        System.out.println("Peeked dish: " + peekedDish.description);

        // Should be blueDish
        Dish poppedDish = stack.pop();
        System.out.println("Popped dish: " + poppedDish.description);

        // Should be redDish
        Dish anotherPoppedDish = stack.pop();
        System.out.println("Another popped dish: " + anotherPoppedDish.description);

        // Should be 2
        int finalSize = stack.size();
        System.out.println("Final size: " + finalSize); 

        //Edge case: fill stack to test overflow message 
        System.out.println("\n Filling stack to test overflow ");
        DishStack smallTest = new DishStack();
        for (int i = 1; i <= 11; i++) {
            smallTest.push(new Dish("Dish #" + i));
        }
        System.out.println("Size after attempting 11 pushes (max 10): " + smallTest.size());
    }
}
