package Domain;

public class RentalValidator implements IValidator<Rental>{

    /**
     * Validates a rental.
     *
     * @param rental the car to validate.
     *            Raises RuntimeException if there are validation errors.
     */
    public void validate(Rental rental) {

        String number = rental.getDistance1();
        String errors = "";
        if (number == "0") {
            throw new CarValidatorException(errors);
        }
    }
}