import java.util.Scanner;

public class Player {
    private Scanner scanner;

    public Player() {
        scanner = new Scanner(System.in);
    }

    public String choose() {
        System.out.print("Choose rock, paper, or scissors: ");
        return scanner.nextLine().toLowerCase();
    }
}

