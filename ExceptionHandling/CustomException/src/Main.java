public class Main {
    public static void main(String[] args) {
        try {
            new CircleWithRadiusException(5);
            new CircleWithRadiusException(-5);
            new CircleWithRadiusException(0);
        }
        catch( InvalidRadiousException ex) {
            System.out.println(ex);
        }

    }
}