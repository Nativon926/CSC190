public class Circle {

    // Member variable, eaach object will have their own radius
    private double radius;

    // Create Constructors
    // Default Constructor
    public Circle() {
        radius = 0;
    }

    public Circle(double newRadius) {
        this.radius = newRadius; // Particulur object we're operating on now
    }

    double getArea() {
        return Math.PI * radius * radius;
    }
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

}
