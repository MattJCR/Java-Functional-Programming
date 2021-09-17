package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Funtion {

    public static void main(String[] args) {

        //Funciones
        int increment = increment(1);
        System.out.println(increment);

        increment = incrementByOneFunction.apply(1);
        System.out.println(increment);

        int multiply = multipleBy10Funtion.apply(increment);
        System.out.println(multiply);

        int incrementAndMultiply = incrementByOneFunctionAndMultipleBy10Funtion.apply(1);
        System.out.println(incrementAndMultiply);

        //BiFunciones
        incrementAndMultiply = incrementByOneAndMultiply(4,100);
        System.out.println(incrementAndMultiply);

        incrementAndMultiply = incrementByOneAndMultiplyBiFunction.apply(4,100);
        System.out.println(incrementAndMultiply);

    }

    static Function<Integer,Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer,Integer> multipleBy10Funtion = number -> number * 10;
    static Function<Integer,Integer> incrementByOneFunctionAndMultipleBy10Funtion = incrementByOneFunction.andThen(multipleBy10Funtion);
    static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrement, numberToMultiply) -> (numberToIncrement + 1) * numberToMultiply;

    static int increment(int number){
        return number+1;
    }

    static int incrementByOneAndMultiply(int number,int numToMultiply){
        return (number+1) * numToMultiply;
    }
}
