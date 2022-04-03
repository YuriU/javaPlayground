package combinator;

import java.time.LocalDate;
import static combinator.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+01111111",
                LocalDate.of(2000, 3, 1)
        );

        CustomerValidatorService validatorService = new CustomerValidatorService();
        boolean valid = validatorService.isValid(customer);
        System.out.println(valid);

        // Using combinator

        ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        if(result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.toString());
        }

    }
}
