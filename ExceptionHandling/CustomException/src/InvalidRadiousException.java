public class InvalidRadiousException extends Exception {
    private double radius;

    public InvalidRadiousException(double radius) {
        super("Invalid radius: " + radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
