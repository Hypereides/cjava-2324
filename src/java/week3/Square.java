public class Square {
    Point bottomLeft;
    int sideLength;

    Square(Point bottomLeft, int sideLength) {
        this.bottomLeft = bottomLeft;
        this.sideLength = sideLength;
    }

    int getArea() {
        return sideLength * sideLength;
    }
}
