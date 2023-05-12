import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        KobeBryant kobeBryant = new KobeBryant();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(kobeBryant.getGreeting());
            while (true) {
                String statement = scanner.nextLine().toLowerCase();
                System.out.println(kobeBryant.getResponse(statement));
            }
        }
        
    }
}
