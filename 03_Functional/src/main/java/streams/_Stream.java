package streams;

import java.util.List;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John",  Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex",  Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

        people.stream()
                .map(p -> p.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream()
                .mapToInt(p -> p.name.length())
                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                //.filter(p -> Gender.FEMALE.equals(p.gender))
                .allMatch(person -> Gender.FEMALE.equals(person.gender));

        System.out.println(containsOnlyFemales);


        boolean containsAnyFemale = people.stream()
                //.filter(p -> Gender.FEMALE.equals(p.gender))
                .anyMatch(person -> Gender.FEMALE.equals(person.gender));
        System.out.println(containsAnyFemale);

        people.stream()
                .sorted((p1, p2) -> -p1.name.compareTo(p2.name))
                .forEach(s -> System.out.println(s));
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

    static enum Gender {
        MALE,
        FEMALE
    }
}
