package streams;


import imperative.Main;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Mateo", Gender.MALE),
                new Person("Alexia", Gender.FEMALE),
                new Person("Sara", Gender.FEMALE),
                new Person("Juan", Gender.MALE),
                new Person("Pedro", Gender.MALE),
                new Person("Sara", Gender.UNDEFINE),
                new Person("Luisa", Gender.FEMALE)
        );

        Set<Gender> genders = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet());
        System.out.println(genders);

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(gender -> System.out.println(gender));

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        boolean only = people.stream().allMatch(personPredicate);
        System.out.println("only: " + only);
        boolean any = people.stream().anyMatch(personPredicate);
        System.out.println("any: " + any);
        boolean none = people.stream().noneMatch(personPredicate);
        System.out.println("none: " + none);

        people.stream().sorted(Comparator.comparing(person -> person.name)).collect(Collectors.toList())
                .forEach(System.out::println);
        people.stream().sorted(Comparator.comparing(person -> person.gender)).collect(Collectors.toList())
                .forEach(System.out::println);

    }
    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, UNDEFINE
    }
}
