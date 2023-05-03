public class ValidatorFactory {
    public static Validator createValidator() {
        return new RockPaperScissorsValidator();
    }
}
