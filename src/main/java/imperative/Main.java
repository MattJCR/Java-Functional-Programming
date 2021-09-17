package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Mateo", Gender.MALE),
            new Person("Alexia", Gender.FEMALE),
            new Person("Sara", Gender.FEMALE),
            new Person("Juan", Gender.MALE),
            new Person("Pedro", Gender.MALE),
            new Person("Luisa", Gender.FEMALE)
        );

        //Imperative
        System.out.println("//Imperative");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        //Declarative
        System.out.println("//Declarative");
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList())
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
        MALE, FEMALE
    }
}
