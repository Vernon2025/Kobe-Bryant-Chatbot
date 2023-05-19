import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 *
 * @author Laurie White
 * @version April 2012
 */
public class Main {

    /**
     * Create a Magpie, give it user input, and print its replies.
     */
    public static void main(String[] args) {
        KobeBryant kobe = new KobeBryant();

        System.out.println(kobe.getGreeting());
        Scanner in = new Scanner(System.in);
        String statement = in.nextLine();

        while (!statement.equals("Bye")) {
            System.out.println(kobe.getResponse(statement));
            statement = in.nextLine();
        }
    }

}