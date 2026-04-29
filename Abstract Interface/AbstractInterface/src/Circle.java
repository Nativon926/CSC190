public class Circle extends GeometricObject{
    // compiler will complain because we haven't implmented abstract methods yet

    private double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;

    }

    public double getPerimeter() {
        return 2*radius * Math.PI;
    }

    public void printCircle() {
        System.out.println("This circle was created " + getDateCreated() + " and the radius is " + radius);
    }
}
