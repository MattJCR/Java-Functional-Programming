package combinatorpattern;

import functionalInterface._Funtion;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpattern.CustomerRegistrarionValidator.*;
import static combinatorpattern.CustomerRegistrarionValidator.ValidationResult.*;

public interface CustomerRegistrarionValidator extends Function <Customer, ValidationResult> {

    static CustomerRegistrarionValidator isEmailValid () {
        System.out.println("Running isEmailValid.");
        return customer -> customer.getEmail().contains("@") ?
                SUCCESS: EMAIL_NOT_VALID;
    }

    static CustomerRegistrarionValidator isPhoneNumberValid () {
        System.out.println("Running isPhoneNumberValid.");
        return customer -> customer.getPhoneNumber().startsWith("+0") ?
                SUCCESS: PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrarionValidator isAdult () {
        System.out.println("Running isAdult.");
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?
                SUCCESS: IS_NOT_AN_ADULT;
    }

    default CustomerRegistrarionValidator and (CustomerRegistrarionValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer):result;
        };
    }


    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
