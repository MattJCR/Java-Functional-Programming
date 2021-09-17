package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrarionValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Mateo",
                "emailemail.com",
                "+075765123",
                LocalDate.of(1991,04,14)
        );

        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
        System.out.println(customerValidatorService.isValid(customer));

        //Using combinator pattern

        //Lazzy
        CustomerRegistrarionValidator result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult());
        //Need apply to run validation
        ValidationResult validationResult = result.apply(customer);

        System.out.println(result);
        if (validationResult != ValidationResult.SUCCESS) {
            throw new IllegalStateException(validationResult.name());
        }

    }
}
