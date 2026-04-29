public class Exercise09_09 {
    private int n = 3; // num sides
    private double side = 1;
    private double x = 0;
    private double y = 0;

    public Exercise09_09() {

    }

    public Exercise09_09(int n, double side) {
        this.side = side;
        this.n = n;
    }

    public Exercise09_09(int n, double side, double x, double y) {
        this.side = side;
        this.n = n;
        this.x = x;
        this.y= y;
    }

    public double getSide() {
        return side;
    }

    public int getNumberSide() {
        return n;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y =y;
    }

    public double getPerimeter() {
        return side*n;
    }

    public double getArea() {
        return ((n*Math.pow(side, 2) / (4 * Math.tan(Math.PI / n))));
    }
}
