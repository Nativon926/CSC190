public class Main {
    public static void main(String[] args) {
        Exercise09_09 p1 = new Exercise09_09();
        Exercise09_09 p2 = new Exercise09_09(6, 4);
        Exercise09_09 p3 = new Exercise09_09(10, 4, 5.6, 7.8);

        System.out.println("Polygon 1 perimeter: " + p1.getPerimeter());
        System.out.println("Polygon 1 area : " + p1.getArea());
        System.out.println("Polygon 2 perimeter: " + p2.getPerimeter());
        System.out.println("Polygon 2 area : " + p2.getArea());
        System.out.println("Polygon 3 perimeter: " + p3.getPerimeter());
        System.out.println("Polygon 3 area : " + p3.getArea());
    }
}