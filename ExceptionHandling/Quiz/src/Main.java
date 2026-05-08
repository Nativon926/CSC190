import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double v1 = input.nextDouble();
        double v2 = input.nextDouble();
        String line = input.nextLine();
        System.out.println("v1: " + v1 + " v2: " + " line: " + line);
        try {
            System.out.println("Welcome");
            int i = 0;
            int y = 2 / i;
            System.out.println("Welcome to Java");
        }
        catch (RuntimeException ex) {
            System.out.println("welcome");
        }
        finally {
            System.out.println("End");
        }
        System.out.println("End");
    }
}