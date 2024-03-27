import java.util.ArrayList;
import java.util.List;

public class Window {
    private List<Shape> shapes = new ArrayList<>();
    private String name;

    public Window(String name) {
        this.name = name;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void draw() {
        System.out.println("Drawing window " + name);
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}