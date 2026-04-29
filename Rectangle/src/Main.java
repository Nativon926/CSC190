public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 40);
        Rectangle r2 = new Rectangle(3.5, 35.9);

        System.out.println("Width: " + r1.width + " Height: " + r1.height +
                " Area: " + r1.getArea() + " Perimeter: " + r1.getPerimeter());
        System.out.println("Width: " + r2.width + " Height: " + r2.height +
                " Area: " + r2.getArea() + " Perimeter: " + r2.getPerimeter());
    }
}