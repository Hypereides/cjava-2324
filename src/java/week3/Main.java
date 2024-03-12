/*
 * Following program generates a total of 10 squares, each initialized at the point (0,0).
 * The program then compares the areas of these squares.
 */
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Square> stack = new Stack<>();
        for (int i = 1; i <= 10; i++) {
            Point point = new Point(0, 0); // Changed to (0,0)
            stack.push(new Square(point, i));
        }

        int previousArea = 0;
        int irArea = 0;
        while (!stack.isEmpty()) {
            Square square = stack.pop();
            int currentArea = square.getArea();
            System.out.println("Popped square with area: " + currentArea);
            if (previousArea != 0) {
                int diff = Math.abs(currentArea - previousArea);
                System.out.println("Difference from previous: " + diff);
                              
                // If the difference in areas is the same as the area of the previous square,
                // check if the difference is a perfect square. If so, print a message.
                if (irArea != 0 && diff == irArea) {
                    if (Math.sqrt(diff) == (int) Math.sqrt(diff)) {
                        System.out.println("Square with side " + Math.sqrt(diff)
                                + " has area equal to difference of areas of two previously popped squares.");
                    } else {
                        System.out.println("Difference of areas does not correspond to a square with integer side length.");
                    }
                }
            }
            irArea = previousArea;
            previousArea = currentArea;
        }
    }
}