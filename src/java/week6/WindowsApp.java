/**
 * Week6
 * This program generates 2 different windows, each containing different shapes.
 * An abstract class is used throughout the program.
 * @see <a href="https://stackoverflow.com/questions/3182440/benefits-of-using-an-abstract-classes-vs-regular-class">StackOverflow discussion on benefits of using abstract classes vs regular classes</a>
 * Within each shape class i am using the extends keyword which creates an actual subclass, each shape , for example square is a subclass of shape which is how
 * i am utilising the ovveride methods.
 * @see <a href="https://ioflood.com/blog/java-extends/
 */

import java.util.ArrayList;
import java.util.List;

public class WindowsApp {
    //--List that contains all the Window objects--
    private List<Window> windows = new ArrayList<>();
    //The window being added to the list
    public void addWindow(Window window) {
        windows.add(window);
    }

    public void bringToFront(Window window) {
        windows.remove(window);
        windows.add(window);
    }

    public void draw() {
        for (Window window : windows) {
            window.draw();
        }
    }
    //Main method
    public static void main(String[] args) {
        WindowsApp app = new WindowsApp();

        // Generating 2 different windows and their shapes respectively.
        Window w1 = new Window("w1");
        w1.addShape(new Square());
        w1.addShape(new Circle());
        w1.addShape(new Triangle());

       
        Window w2 = new Window("w2");
        w2.addShape(new Square());
        w2.addShape(new Circle());
        w2.addShape(new Triangle());

        app.addWindow(w1);
        app.addWindow(w2);

        // Draw the app
        app.draw();

        //Bringing w1 to the front
        app.bringToFront(w1);

        // Redraw
        app.draw();
    }
}