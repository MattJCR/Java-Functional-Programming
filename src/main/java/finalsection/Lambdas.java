package finalsection;

import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        String name = "Matt";
        System.out.println(name);
        name = upperName.apply(name);
        System.out.println(name);
    }
    static Function<String,String> upperName = (name) -> {
        if (name.isEmpty() || name.isBlank()){
            throw new IllegalStateException("Null or empty name");
        }
        return name.toUpperCase();
    };
}
