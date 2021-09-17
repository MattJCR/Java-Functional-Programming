package finalsection;

import java.util.Objects;
import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        //Callbacks like JS
        hello("Matt","", value -> System.out.println(value));
        hello("Sara",null, value -> System.out.println(value));
        hello("Juan","Montana", value -> System.out.println(value));

        helloRunnable("Runnable",null, () -> System.out.println("No last name"));
    }
    static void hello(String name, String last, Consumer<String> callback) {
        System.out.println("name: " + name);
        if (Objects.nonNull(last) && !last.isEmpty()) {
            System.out.println("last: " + last);
        } else{
            callback.accept("No last name");
        }
    }
    static void helloRunnable(String name, String last, Runnable callback) {
        System.out.println("name: " + name);
        if (Objects.nonNull(last) && !last.isEmpty()) {
            System.out.println("last: " + last);
        } else{
            callback.run();
        }
    }
}
