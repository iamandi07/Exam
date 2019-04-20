package Domain;

public class CarValidator implements IValidator<Car>{

    /**
     * Validates a car.
     *
     * @param car the car to validate.
     *            Raises RuntimeException if there are validation errors.
     */
    public void validate(Car car) {

        String number = car.getDistance();
        String errors = "";
        if (number == "0") {
            throw new CarValidatorException(errors);
        }
    }
}