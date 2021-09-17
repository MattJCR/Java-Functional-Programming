package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(Customer customer){
        return customer.getEmail().contains("@");
    }

    private boolean isPhoneNumberValid(Customer customer){
        return customer.getPhoneNumber().startsWith("+0");
    }

    private boolean isAdult(Customer customer){
        return Period.between(customer.getDob(), LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Customer customer) {
        return isEmailValid(customer) && isPhoneNumberValid(customer) && isAdult(customer);
    }


}
