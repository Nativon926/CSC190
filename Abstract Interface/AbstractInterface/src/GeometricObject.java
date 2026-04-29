import java.util.Date;

public abstract class GeometricObject {
    private String color ="white";
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "created on " + dateCreated + "\n color: " + color + "\n is filled: " + filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}
