import java.util.Random;

public class ComputerPlayer {
    private static ComputerPlayer instance;
    private Random random;

    private ComputerPlayer() {
        random = new Random();
    }

    public static ComputerPlayer getInstance() {
        if (instance == null) {
            instance = new ComputerPlayer();
        }
        return instance;
    }

    public String choose() {
        String[] choices = { "rock", "paper", "scissors" };
        return choices[random.nextInt(choices.length)];
    }
}
