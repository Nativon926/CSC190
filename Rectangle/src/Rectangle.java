public class Rectangle {
    // Data Fields
    public double width = 1.0;
    public double height = 1.0;

    // No-arg constructor
    public Rectangle() {

    }

    // Creation constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width*height;
    }

    public double getPerimeter() {
        return (width*2) + (height*2);
    }
}
