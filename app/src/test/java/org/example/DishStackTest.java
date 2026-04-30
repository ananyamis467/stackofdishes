package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

//tests
public class DishStackTest {

    private DishStack stack;
    private Dish oneDish;
    private Dish twoDish;
    private Dish redDish;
    private Dish blueDish;

    @BeforeEach
    void setUp() {
        stack   = new DishStack();
        oneDish  = new Dish("A dish with one fish pattern on it");
        twoDish  = new Dish("A dish with two fish patterns on it");
        redDish  = new Dish("A dish with a red fish pattern on it");
        blueDish = new Dish("A dish with a blue fish pattern on it");
    }

    //size()
    @Test
    void testSizeIsZeroWhenEmpty() {
        assertEquals(0, stack.size());
    }

    @Test
    void testSizeIncreasesAfterEachPush() {
        stack.push(oneDish);
        assertEquals(1, stack.size());
        stack.push(twoDish);
        assertEquals(2, stack.size());
    }

    @Test
    void testSizeDecreasesAfterEachPop() {
        stack.push(oneDish);
        stack.push(twoDish);
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void testSizeAfterFourPushes() {
        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        stack.push(blueDish);
        assertEquals(4, stack.size());
    }

    //push()
    @Test
    void testPushOntoFullStackDoesNotChangeSize() {
        // Fill the stack to MAX_SIZE (10)
        for (int i = 0; i < 10; i++) {
            stack.push(new Dish("Dish #" + i));
        }
        assertEquals(10, stack.size());

        // Attempt to push onto a full stack
        stack.push(new Dish("Overflow dish"));
        assertEquals(10, stack.size()); // size must remain 10
    }

    @Test
    void testPushOntoFullStackDoesNotOverwriteTop() {
        for (int i = 0; i < 10; i++) {
            stack.push(new Dish("Dish #" + i));
        }
        Dish topBeforeOverflow = stack.peek();
        stack.push(new Dish("Overflow dish"));
        assertSame(topBeforeOverflow, stack.peek()); // top must be unchanged
    }

    //pop()

    @Test
    void testPopReturnsTopDish() {
        stack.push(oneDish);
        stack.push(blueDish);
        Dish popped = stack.pop();
        assertEquals("A dish with a blue fish pattern on it", popped.description);
    }

    @Test
    void testPopFollowsLifoOrder() {
        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        stack.push(blueDish);

        assertSame(blueDish, stack.pop());
        assertSame(redDish,  stack.pop());
        assertSame(twoDish,  stack.pop());
        assertSame(oneDish,  stack.pop());
    }

    @Test
    void testPopFromEmptyStackReturnsNull() {
        assertNull(stack.pop());
    }

    @Test
    void testPopReducesSizeByOne() {
        stack.push(oneDish);
        stack.push(twoDish);
        stack.pop();
        assertEquals(1, stack.size());
    }

    //peek()
    @Test
    void testPeekReturnsBlueDish() {
        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        stack.push(blueDish);

        Dish peeked = stack.peek();
        assertEquals("A dish with a blue fish pattern on it", peeked.description);
    }

    @Test
    void testPeekDoesNotRemoveTopDish() {
        stack.push(oneDish);
        stack.push(blueDish);

        stack.peek();
        assertEquals(2, stack.size());
        assertSame(blueDish, stack.peek()); // still on top
    }

    @Test
    void testPeekFromEmptyStackReturnsNull() {
        assertNull(stack.peek());
    }

    //combined scenario from spec
    @Test
    void testFullSpecScenario() {
        // Initial size should be 0
        assertEquals(0, stack.size());

        stack.push(oneDish);
        stack.push(twoDish);
        stack.push(redDish);
        stack.push(blueDish);

        // After 4 pushes, size should be 4
        assertEquals(4, stack.size());

        // Peek should return blueDish without removing it
        Dish peekedDish = stack.peek();
        assertEquals("A dish with a blue fish pattern on it", peekedDish.description);
        assertEquals(4, stack.size()); // still 4 after peek

        // First pop should return blueDish
        Dish poppedDish = stack.pop();
        assertEquals("A dish with a blue fish pattern on it", poppedDish.description);

        // Second pop should return redDish
        Dish anotherPoppedDish = stack.pop();
        assertEquals("A dish with a red fish pattern on it", anotherPoppedDish.description);

        // Final size should be 2
        assertEquals(2, stack.size());
    }
}
