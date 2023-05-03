public class RockPaperScissorsValidator implements Validator {
    @Override
    public boolean isValid(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }
}
