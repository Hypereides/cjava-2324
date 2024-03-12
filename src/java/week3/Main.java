/*
 * Following program generates a total of 10- squares   with set ( initial) coordinates of (0,0)
 */

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Square> stack = new Stack<>();
        for (int i = 1; i <= 10; i++) {
            Point point = new Point(i, i);
            stack.push(new Square(point, i));
        }

        int previousArea = 0;
        int previousPreviousArea = 0;
        while (!stack.isEmpty()) {
            Square square = stack.pop();
            int currentArea = square.getArea();
            System.out.println("Popped square with area: " + currentArea);
            if (previousArea != 0) {
                int diff = Math.abs(currentArea - previousArea);
                System.out.println("Difference from previous: " + diff);
                if (previousPreviousArea != 0 && diff == previousPreviousArea) {
                    if (Math.sqrt(diff) == (int) Math.sqrt(diff)) {
                        System.out.println("Square with side " + Math.sqrt(diff)
                                + " has area equal to difference of areas of two previously popped squares.");
                    } else {
                        System.out.println("Difference of areas does not correspond to a square with integer side length.");
                    }
                }
            }
            previousPreviousArea = previousArea;
            previousArea = currentArea;
        }
    }
}