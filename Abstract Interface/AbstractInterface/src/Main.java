public class Main {
    public static void main(String[] args) {
        GeometricObject geoOb1 = new Circle(5);
        GeometricObject geoOb2 = new Rectangle(5, 3);

        System.out.println("The two objects have the same area? " +
                equalArea(geoOb1, geoOb2));

        displayGeometricObject(geoOb1);
        displayGeometricObject(geoOb2);
    }

    public static boolean equalArea(GeometricObject object1, GeometricObject object2) {
        return object1.getArea() == object2.getArea();
    }

    public static void displayGeometricObject(GeometricObject object) {
        System.out.println();
        System.out.println("The area is " + object.getArea());
        System.out.println("The perimeter is " + object.getPerimeter());
    }
}