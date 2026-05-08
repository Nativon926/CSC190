import java.util.Scanner;
public class Main {
    // File may not exist or wrong administration
    public static void main(String[] args) throws Exception {
        // Make sure file doesn't already exist
        java.io.File file = new java.io.File("scores.txt");
        /*if(file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        // Write a new file
        java.io.PrintWriter output = new java.io.PrintWriter(file);

        output.print("John T Smith ");
        output.println(90);
        output.print("Eric K. Jones ");
        output.println(85);

        output.close();
*/
        Scanner input = new Scanner(file);
        while(input.hasNext()) {
            String firstName = input.next();
            String mi = input.next();
            String lastName = input.next();

            int score = input.nextInt();

            System.out.println(firstName + " " + mi + " " + lastName + " " + score);
        }

        input.close();
    }
}