import java.util.Scanner;

public class Game {
    private Player player;
    private ComputerPlayer computerPlayer;
    private Validator validator;
    private int numRounds;
    private Scanner scanner;

    public Game() {
        player = new Player();
        computerPlayer = ComputerPlayer.getInstance();
        validator = ValidatorFactory.createValidator();
        numRounds = 0;
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            System.out.print("How many rounds do you want to play? ");
            numRounds = Integer.parseInt(scanner.nextLine());
            int playerScore = 0;
            int computerScore = 0;
            for (int i = 0; i < numRounds; i++) {
                System.out.println("Round " + (i+1) + ":");
                String playerChoice = player.choose();
                if (validator.isValid(playerChoice)) {
                    String computerChoice = computerPlayer.choose();
                    System.out.println("Computer chose " + computerChoice);
                    if (playerChoice.equals(computerChoice)) {
                        System.out.println("It's a tie!");
                    } else if (playerChoice.equals("rock") && computerChoice.equals("scissors")
                            || playerChoice.equals("paper") && computerChoice.equals("rock")
                            || playerChoice.equals("scissors") && computerChoice.equals("paper")) {
                        System.out.println("Congratulations, you won this round!");
                        playerScore++;
                    } else {
                        System.out.println("Sorry, you lost this round.");
                        computerScore++;
                    }
                } else {
                    System.out.println("\u001B[31mInvalid input. Please try again.\u001B[0m");
                    i--; // repeat this round
                }
            }
            // \u001B[0m this make text red
            System.out.println("\u001B[34mFinal score:\u001B[0m");
            System.out.println("\u001B[32mPlayer:\u001B[0m " + playerScore);
            System.out.println("\u001B[33mComputer:\u001B[0m " + computerScore);
            if (playerScore > computerScore) {
                System.out.println("Congratulations, you won the game!");
            } else if (playerScore < computerScore) {
                System.out.println("Sorry, you lost the game.");
            } else {
                System.out.println("It's a tie game!");
            }
            System.out.print("Do you want to play again? (yes/no) ");
            String answer = scanner.nextLine().toLowerCase();
            if (!answer.equals("yes") && !answer.equals("y")) {
                playAgain = false;
                System.out.println("Thanks for playing.");
            }
        }
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
