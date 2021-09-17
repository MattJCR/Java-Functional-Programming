package functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        List<String> phoneList = Arrays.asList("07000000000","06000012000","07000056301");
        System.out.println(isFoundNumberValue(phoneList.get(0)));
        System.out.println(isFoundNumberValue(phoneList.get(1)));

        System.out.println(isFoundNumberValuePredicate.test(phoneList.get(0)));
        System.out.println(isFoundNumberValuePredicate.test(phoneList.get(1)));

        System.out.println(isFoundNumberValuePredicate.and(containsNumber3).test(phoneList.get(2)));
        System.out.println(isFoundNumberValuePredicate.or(containsNumber3).test(phoneList.get(0)));
    }

    static boolean isFoundNumberValue(String phoneNumber) {
        return phoneNumber.startsWith("07") & phoneNumber.length() == 11;
    }

    static Predicate<String> isFoundNumberValuePredicate =
            phoneNumber -> phoneNumber.startsWith("07") & phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 =
            phoneNumber -> phoneNumber.contains("3");
}
