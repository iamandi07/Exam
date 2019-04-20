package Domain;

public class RentalValidatorException extends RuntimeException {
    RentalValidatorException(String message) {

        super("Car Validator Exception ||| " + message);
    }
}